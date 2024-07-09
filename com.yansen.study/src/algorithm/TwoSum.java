package algorithm;

import java.util.HashMap;

public class TwoSum {
    public static void main(String[] args) {
        int res[] = new TwoSum().twoSum(new int[]{3,2,4}, 6);
        System.out.println(res[0]);
        System.out.println(res[1]);
    }

    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> subs = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int sub = target - nums[i];
            subs.put(sub, nums[i]);
        }
        boolean find = false;
        int sub2 = 0;
        int[] result = new int[2];
        for (int i = 0; i < nums.length; i++) {
            if (!find && subs.get(nums[i]) != null) {
                result[0] = i;
                sub2 = subs.get(nums[i]);
                find = true;
            }
        }
        if (find) {
            for (int i = 0; i < nums.length; i++) {
                if (sub2 == nums[i] && i != result[0]) {
                    result[1] = i;
                    return result;
                }
            }
        }
        return null;
    }

}
