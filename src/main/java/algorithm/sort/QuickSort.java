package algorithm.sort;

/**
 * 分而治之
 *
 */
public class QuickSort {
    public static void main(String[] args) {
        int arr[] = {1,5,0,8,312,54,6};
        sort(arr,0,arr.length-1);
        for(int i = 0 ;i<arr.length;i++){
            System.out.println(arr[i]);
        }
    }
    static int partition(int arr[], int low, int high) {
        int pivot = arr[high];
        int index = low ;//index of current smaller element
        //原地分区，从左到右，假设左是已排序区间，右是未排序区间，每次把排完序的扔到左边的末尾。依次是 low,low+1,low+2...
        for(int i = low;i<high;i++){
            if(arr[i] < pivot){
                //swap a[i] with a[index]
                int temp = arr[index];
                arr[index] = arr[i];
                arr[i] = temp;
                index++;//已排序Index+1
            }
        }
        //swap pivot(or a[high]) with a[index]
        int temp = arr[index];
        arr[index] = arr[high];
        arr[high] = temp;
        return index;
    }
    static void sort(int arr[],int begin,int end){
        if(begin < end){
            int pi = partition(arr,begin,end);//pi is the index of pivot
            //左边排序
            sort(arr,begin,pi-1);//注意，这里如果写成0到pi会死循环
            //右边排序
            sort(arr,pi+1,end);
        }
    }
//    static int partition(int arr[], int low, int high) {
//        int pivot = arr[high];
//        int i = (low-1); // index of smaller element
//        for (int j=low; j<high; j++)
//        {
//            // If current element is smaller than the pivot
//            if (arr[j] < pivot)
//            {
//                i++;
//
//                // swap arr[i] and arr[j]
//                int temp = arr[i];
//                arr[i] = arr[j];
//                arr[j] = temp;
//            }
//        }
//
//        // swap arr[i+1] and arr[high] (or pivot)
//        int temp = arr[i+1];
//        arr[i+1] = arr[high];
//        arr[high] = temp;
//
//        return i+1;
//    }
//
//
//    /* The main function that implements QuickSort()
//      arr[] --> Array to be sorted,
//      low  --> Starting index,
//      high  --> Ending index */
//    static void sort(int arr[], int low, int high)
//    {
//        if (low < high)
//        {
//            /* pi is partitioning index, arr[pi] is
//              now at right place */
//            int pi = partition(arr, low, high);
//
//            // Recursively sort elements before
//            // partition and after partition
//            sort(arr, low, pi-1);
//            sort(arr, pi+1, high);
//        }
//    }
}
