package tool.tokenBucket;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.util.Arrays;

/**
 * java实现一个简单的令牌桶，（不考虑机器时间之间的差异）
 */

public class RateLimiter {

    private static JedisPool jedisPool;

    public TokenBucket build(String key, int capacity, double rate) {
        return new TokenBucket(key, capacity, rate);
    }

    public static class TokenBucket {
        /**
         * 指定的桶
         */

        private String tokenKey;
        /**
         * 指定的容量
         */
        private int capacity;
        /**
         * 指定的速率/秒
         */
        private double rate;

        public TokenBucket(String key, int capacity, double rate) {
            this.tokenKey = key;
            this.capacity = capacity;
            this.rate = rate;
        }

        /**
         * LUA脚本
         * local capacity= tonumber(ARGV[1])
         * local rate=tonumber(ARGV[2])
         * local now =tonumber(redis.call('time')[1])
         * local tokens = tonumber(redis.call('get'， KEYS[1]) or 0)
         * local modify_time = tonumber(redis.call('get', KEYS[2]) or
         * <p>
         * if tokens <capacity then
         *    local delta= math.min(rate * (now - modify_ time),capacity-tokens)
         *    if delta >=1 then
         *      tokens = tokens + delta
         *      redis.call('set"，KEYS[2],now)
         *      redis.call('set",KEYS[1], tokens)
         *    end
         *end
         *
         *
         *if tokens >= 1 then
         *    redis.call('set',KEYS[1],tokens -1)
         *    return 1
         *else
         *    return 0
         *end
         */
        /**
         * 思路：
         * 1. 首先，获取指定桶的token
         * 2.判断当前桶的token是否小于指定的最大容量，则按照速率生成令牌（速率需要用当前时间与修改时间对比），得到一个值delta，若delta大于1，则生成令牌，并且不允许超过最大容量capacity，把生成的token设置到当前桶，并存储修改时间
         * 3.如果当前桶的令牌数大于1时，减去一个令牌，表示申请令牌成功，返回1 否则失败
         */
        String script =
                "    local capacity= tonumber(ARGV[1])\n" +
                        "    local rate=tonumber(ARGV[2])\n" +
                        "    local now =tonumber(redis.call('time')[1])\n" +
                        "    local tokens = tonumber(redis.call('get'， KEYS[1]) or 0)\n" +
                        "    local modify_time = tonumber(redis.call('get', KEYS[2]) or\n" +
                        "\n" +
                        "if tokens <capacity then \n" +
                        "        local delta= math.min(rate * (now - modify_ time),capacity-tokens)\n" +
                        "        if delta >=1 then\n" +
                        "        tokens = tokens + delta\n" +
                        "        redis.call('set\",KEYS[2],now)\n" +
                        "        redis.call('set\",KEYS[1], tokens)\n" +
                        "        end\n" +
                        "        end\n" +
                        "\n" +
                        "    if tokens >= 1 then\n" +
                        "        redis.call('set',KEYS[1],tokens -1)\n" +
                        "        return 1\n" +
                        "    else\n" +
                        "        return 0\n" +
                        "    end";

        public boolean acquire() {
            Jedis jedis = jedisPool.getResource();
            try {
                while (true) {
                    String[] keys = new String[]{this.tokenKey, this.tokenKey + ":time"};
                    String[] args = new String[]{String.valueOf(capacity), String.valueOf(rate)};
                    Long result = (Long) jedis.eval(script, Arrays.asList(keys), Arrays.asList(args));
                    String info = String.format("tryAcquire token key=%s,tokenSize=%s result=%s", this.tokenKey, jedis.get(keys[1]), result == 1);
                    if (result == 1) {
                        return true;
                    }
                }
            } catch (NumberFormatException e) {
                System.out.printf(String.valueOf(e));
            } finally {
                jedis.close();
            }
            return false;
        }

        /**
         * 获取令牌，有超时时间
         *
         * @param timeout
         * @return
         */

        public boolean tryAcquire(int timeout) {
            Jedis jedis = jedisPool.getResource();
            try {
                long tm = System.currentTimeMillis();
                while (true) {
                    String[] keys = new String[]{this.tokenKey, this.tokenKey + ":time"};
                    String[] args = new String[]{String.valueOf(capacity), String.valueOf(rate)};
                    Long result = (Long) jedis.eval(script, Arrays.asList(keys), Arrays.asList(args));
                    String info = String.format("tryAcquire token key %s,tokenSize= %s result =%s", this.tokenKey, jedis.get(keys[0]), result == 1);
                    if (result == 1) {
                        return true;
                    }
                    if (System.currentTimeMillis() - tm > timeout) {
                        return false;
                    }
                }

            } catch (NumberFormatException e) {
                System.out.printf(String.valueOf(e));
            } finally {
                jedis.close();
            }
            return false;
        }

    }

}