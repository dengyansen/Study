package algorithm.sort;

/**
 *
 * 递推公式：
 * quick_sort(p…r) = quick_sort(p…q-1) + quick_sort(q+1, r)
 * 终止条件：
 * p >= r
 * 像合并排序一样，QuickSort是一种分而治之算法。它选择一个元素作为枢轴，并围绕拾取的枢轴对给定数组进行分区。 quickSort有许多不同的版本，它们以不同的方式选择枢轴。
 * 1.始终选择第一个元素作为枢轴。
 * 2.始终选择最后一个元素作为枢轴（在下面实现）
 * 3.选择一个随机元素作为枢轴。
 * 4.选择中位数作为枢轴。
 * quickSort中的关键过程是partition（）。分区的目标是，给定一个数组和一个数组元素x作为枢轴，将x放在已排序数组中的正确位置，并将所有较小的元素（小于x）放在x之前，并将所有较大的元素（大于x）放在之后X。所有这些都应在线性时间内完成。
 *
 * 递归QuickSort函数的伪代码：
 * / *低->起始索引，高->结束索引* /
 * quickSort（arr []，低，高）
 * {
 *     如果（低<高）
 *     {
 *         / * pi是分区索引，arrpi现在
 *            在正确的地方* /
 *         pi = partition（arr，low，high）;
 *
 *         quickSort（arr，low，pi-1）; //在pi之前
 *         quickSort（arr，pi + 1，高）; //在pi之后
 *     }
 * }
 *
 * 分区算法
 * 进行分区的方法有很多，下面的伪代码采用CLRS书中给出的方法。逻辑很简单，我们从最左边的元素开始，然后将较小（或等于）元素的索引记为i。
 * 遍历时，如果找到较小的元素，则将当前元素与arr [i]交换。否则，我们将忽略当前元素。
 *
 * / *低->起始索引，高->结束索引* /
 * quickSort（arr []，低，高）
 * {
 *     如果（低<高）
 *     {
 *         / * pi是分区索引，arr[pi]现在在正确的地方* /
 *         pi = partition（arr，low，high）;
 *
 *         quickSort（arr，low，pi-1）; //在pi之前
 *         quickSort（arr，pi + 1，高）; //在pi之后
 *     }
 * }
 * partition（）的伪代码
 *
 * / *此函数将最后一个元素作为枢轴，放置
 *    枢轴元素在其正确位置进行排序
 *     数组，并放置所有较小的对象（小于枢轴）
 *    在枢轴的左侧，所有更大的元素在右侧
 *    枢轴* /
 * 分区（arr []，低，高）
 * {
 *     //枢纽（要放置在正确位置的元素）
 *     枢轴= arr [高];
 *
 *     i =（low-1）//较小元素的索引
 *
 *     对于（j =低; j <=高-1; j ++）
 *     {
 *         //如果当前元素小于枢轴
 *         如果（arr [j] <枢纽）
 *         {
 *             i ++; //较小元素的增量索引
 *             交换arr [i]和arr [j]
 *         }
 *     }
 *     swap arr [i + 1]和arr [high]）
 *     return（i + 1）
 * }
 *
 * 归并排序与快排区别：
 *可以发现，归并排序的处理过程是由下到上的，先处理子问题，然后再合并。
 *而快排正好相反，它的处理过程是由上到下的，先分区，然后再处理子问题。
 * 归并排序虽然是稳定的、时间复杂度为 O(nlogn) 的排序算法，但是它是非原地排序算法。
 * 我们前面讲过，归并之所以是非原地排序算法，主要原因是合并函数无法在原地执行。
 * 快速排序通过设计巧妙的原地分区函数，可以实现原地排序，解决了归并排序占用太多内存的问题。
 */
public class QuickSortExample {
    public static void main(String[] args) {
        int arr[] = CommArr.getCommArr();
        CommArr.printArr(arr);
        System.out.println("quick sort after");
        quickSort(arr,0,args.length-1);
        CommArr.printArr(arr);          
    }

    private static void quickSort(int[] arr, int low, int height) {
        if(low<height){
            //分区
            int mid = partition(arr,low,height);
            //左边数组排序
            quickSort(arr,low,mid);
            //右边数组排序
            quickSort(arr,mid+1,height);
        }

    }

    /**
     * 分区，获取中位数
     * @param arr
     * @param low
     * @param height
     * @return
     */
    private static int partition(int[] arr, int low, int height) {
        int pivot = arr[height];//中枢元素
        int i = low;//较小元素的索引,此游标从左往右，不让检索元素，将比pivot小的放在左，那么大的都在右，最后将pivot放在此游标，注意，此小区间尚未完整排序
        int temp = 0;
        for(int j = low;j<=height;j++){
            if(arr[j]>pivot){
                //swap arr[i] arr[j]
                temp = arr[i];
                arr[i++] = arr[j];
                arr[j] = temp;
            }
        }
        //swap pivot arr[i]
        temp = arr[i];
        arr[i] = pivot;
        arr[height] = temp;
        return i+1;
    }
}
