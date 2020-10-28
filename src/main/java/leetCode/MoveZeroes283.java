package leetCode;

import java.util.Arrays;
import java.util.Collections;
//2020.10.25 1

public class MoveZeroes283 {
    //给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
    //
    // 示例:
    //
    // 输入: [0,1,0,3,12]
    //输出: [1,3,12,0,0]
    //
    // 说明:
    //
    //
    // 必须在原数组上操作，不能拷贝额外的数组。
    // 尽量减少操作次数。
    //
    public static void main(String[] args) {
//        int[] arr = {0,2,0,3,12};
        int[] arr = {1,2,0,3,12};
        Solution.moveZeroes(arr);
        for (int a: arr) {
            System.out.println(a);
        }
    }
    static class Solution {
        public static void moveZeroes(int[] nums) {
            /**
             * 1.//第一次遍历的时候，j指针记录非0的个数，只要是非0的统统都赋给nums[j]
             */
            if(nums == null){
                return;
            }
            int j = 0 ;
            for(int i = 0; i < nums.length; i++){
                if(nums[i] != 0 ){
                    nums[j++] = nums[i];
                }
            }
            //非0元素统计完了，剩下的都是0了
            //所以第二次遍历把末尾的元素都赋为0即可
            for(int i=j;i<nums.length;++i) {
                nums[i] = 0;
            }
        }

        /**
         * 交换解法
         * @param nums
         */
        public static void moveZeroes2(int[] nums) {
            /**
             * 1.//第一次遍历的时候，j指针记录非0的个数，只要是非0的统统都赋给nums[j]
             */
            if(nums == null){
                return;
            }
            int j = 0 ;
            for(int i = 0; i < nums.length; i++){
                if(nums[i] != 0 ){
                    int temp = nums[j];
                    nums[j++] = nums[i];
                    nums[i] = nums[temp];
                }
            }

        }
    }
}
