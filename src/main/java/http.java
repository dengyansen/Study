import cn.hutool.http.HttpRequest;
import cn.hutool.json.JSONObject;
import tomcat.Http;

import java.util.HashMap;
import java.util.Map;

public class http {
    public static void main(String[] args) {
        String url = "https://www.baidu.com";
        Map<String, Object> param = new HashMap<>();
        param.put("pwd", "!S");
        param.put("data", "");
        String res = HttpRequest.post(url)
                .header("content-type", "application/json;charset=UTF-8")
                .execute().body();
        System.out.println(res);
    }
}
