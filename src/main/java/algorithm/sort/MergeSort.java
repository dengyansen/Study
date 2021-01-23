package algorithm.sort;

import java.util.Arrays;

/**
 * 归并排序用的是分治思想,始终记得，分治是一种解决问题的思想，递归是编程的技巧
 * 递推公式：
 * mergeSort(p,r) = merge(mergeSort(p,mid),mergeSort(mid+1,r));
 * 什么时候不再分解问题呢？但p>=r时
 *
 * 像QuickSort一样，合并排序是一种分而治之算法。它将输入数组分为两个半部分，将自身称为两个半部分，然后合并两个已排序的半个部分。
 * merge（）函数用于合并两个半部分。merge（arr，l，m，r）是一个关键过程，假定对arr [l..m]和arr [m + 1..r]进行排序并将两个排序后的子数组合并为一个。
 *
 * MergeSort（arr []，l，r）
 * 如果r> l
 *      1.找到中间点，将数组分为两半：
 *              中间m =（l + r）/ 2
 *     2.调用mergeSort作为上半部分：
 *              调用mergeSort（arr，l，m）
 *      3.调用mergeSort作为下半部分：
 *              调用mergeSort（arr，m + 1，r）
 *      4.合并在步骤2和3中分类的两个部分：
 *              调用merge（arr，l，m，r）
 */
public class MergeSort {
    public static void main(String[] args) {
        int[] arr = CommArr.getCommArr();
        CommArr.printArr(arr);
        mergeSort(arr,0,arr.length-1);
        System.out.println("------");
        CommArr.printArr(arr);
    }
    private static void mergeSort(int[] arr,int p,int r) {
        if(p>=r){
            return;
        }
        int mid = (p+r)/2;
        mergeSort(arr,p,mid);
        mergeSort(arr,mid+1,r);
        merge(arr,p,mid,r);
    }

    /**
     * 将数组 [p,mid] 与[mid,r]合并
     * @param arr
     * @param p
     * @param mid
     * @param r
     */

    private static void copy(int[] temp, int i, int[] arr, int start,int end) {
        for(;start<=end;start++,i++){
            temp[i] = arr[start];
        }
    }


    // Merges two subarrays of arr[].
    // First subarray is arr[l..m]
    // Second subarray is arr[m+1..r]
    static void merge(int arr[], int p, int mid, int r)
    {
        // Find sizes of two subarrays to be merged
        int n1 = mid - p + 1;
        int n2 = r - mid;

        /* Create temp arrays */
        int L[] = new int[n1];
        int R[] = new int[n2];

        /*Copy data to temp arrays*/
        for (int i = 0; i < n1; ++i)
            L[i] = arr[p + i];
        for (int j = 0; j < n2; ++j)
            R[j] = arr[mid + 1 + j];

        /* Merge the temp arrays */

        // Initial indexes of first and second subarrays
        int i = 0, j = 0;

        // Initial index of merged subarry array
        int k = p;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k++] = L[i++];
            } else {
                arr[k++] = R[j++];
            }
        }
        /* Copy remaining elements of L[] if any */
        while (i < n1) {
            arr[k++] = L[i++];
        }
        /* Copy remaining elements of R[] if any */
        while (j < n2) {
            arr[k++] = R[j++];
        }
    }

}
