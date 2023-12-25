package leetCode.leetcode.editor.cn;//给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 的那 两个 整数，并返回它们的数组下标。
//
// 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
//
// 你可以按任意顺序返回答案。
//
//
//
// 示例 1：
//
//
//输入：nums = [2,7,11,15], target = 9
//输出：[0,1]
//解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
//
//
// 示例 2：
//
//
//输入：nums = [3,2,4], target = 6
//输出：[1,2]
//
//
// 示例 3：
//
//
//输入：nums = [3,3], target = 6
//输出：[0,1]
//
//
//
//
// -109 <= nums[i] <= 109
// -109 <= target <= 109
// 只会存在一个有效答案
//
// Related Topics 数组 哈希表
// 👍 11001 👎 0


import java.util.ArrayList;
import java.util.HashMap;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public static void main(String[] args) {
        new Solution().add(1,1);
//        int[] nums = {1, 3, 5};
//        int[] result = new Solution().twoSum(nums, 6);
//        for (Integer i : result) {
// 提示：
//
//
// 2 <= nums.length <= 103
//            System.out.println(i);
//        }

    }
    int add(int a, int b){
        System.out.println(a+b);
    }

    /**
     * 第二种解法
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{i, map.get(target - nums[i])};
            } else {
                map.put(nums[i], i);
            }
        }
        throw new IllegalArgumentException("no solution");
    }
//第一种解法：性能不太好，为了避免重复用了list
//    public int[] twoSum(int[] nums, int target) {
//        int[] arr = new int[2];
//        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
//        for (int i = 0; i < nums.length; i++) {
//            ArrayList<Integer> list = map.get(nums[i]);
//            if (list == null) {
//                list = new ArrayList<>(2);
//            }
//            if (list.size() < 2) {
//                list.add(i);
//            }
//            map.put(nums[i], list);
//        }
//        for (int i = 0; i < nums.length; i++) {
//            int key = target - nums[i];
//            if (key == nums[i]) {
//                ArrayList<Integer> list = map.get(key);
//                if (list != null && list.size() > 1) {
//                    arr[0] = list.get(0);
//                    arr[1] = list.get(1);
//                    return arr;
//                }
//            } else {
//                ArrayList<Integer> list = map.get(key);
//                if (list != null) {
//                    arr[0] = i;
//                    arr[1] = list.get(0);
//                }
//            }
//        }
//        return arr;
//    }
}
//leetcode submit region end(Prohibit modification and deletion)
