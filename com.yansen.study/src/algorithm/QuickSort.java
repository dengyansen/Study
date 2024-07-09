package algorithm;

/**
 * https://www.runoob.com/w3cnote/quick-sort.html
 * 快速排序
 * 思路：先找一个基数，用一个变量存起来，
 * 然后从右找一个比基数小，填坑，从左找一个比基数大，互换，依次交替
 */

public class QuickSort {
    static void quickSort(int[] nums, int left, int right) throws InterruptedException {

        int base = nums[left], l = left, r = right;
        if (left >= right) {
            return;
        }
        while (l != r) {
            System.out.println(66);
            // 从右边往左边检索,当右边的数小于基数时，停止
            while (base <= nums[r] && l < r) {
                r--;
            }
            // 从左边往右边检索,当左边的数大于基数时，停止
            while (nums[l] <= base && l < r) {
                l++;
            }
            //这里表示找到右边有小于基数的，左边有大于基数的，因此交换位置
            int temp = nums[r];
            nums[r] = nums[l];
            nums[l] = temp;
        }
        // 当代码执行到这里时，把基数和中点的数交换位置
        nums[left] = nums[l];
        nums[l] = base;
        // 分治法，继续排序基数左边的
        quickSort(nums, left, l - 1);
        // 分治法，继续排序基数右边的
        quickSort(nums, l + 1, right);
        System.out.println(66);

    }


    public static void main(String[] args) throws Exception {
//        int arr[] = new int[100];
        int arr[] = new int[]{5,2,3,1};
//        StringBuilder initStr = new StringBuilder();
//        for (int i = 0; i < arr.length; i++) {
//            arr[i] = (int) (Math.random() * 100);
//            initStr.append(arr[i]).append(",");
//        }
        quickSort(arr, 0, arr.length - 1);
        StringBuilder initStr1 = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            initStr1.append(arr[i]).append(",");
        }
        System.out.println(initStr1);
    }
}
