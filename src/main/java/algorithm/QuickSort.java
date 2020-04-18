package algorithm;

/**
 * https://www.runoob.com/w3cnote/quick-sort.html
 * 快速排序
 * 思路：先找一个基数，用一个变量存起来，
 * 然后从右找一个比基数小，填坑，从左找一个比基数大，互换，依次交替
 */

public class QuickSort {
    static void quickSork(int []arr,int left,int right) throws InterruptedException {
        if(left < right){
            int base = arr[left],i =left,j = right;
            while(i<j){

                while(i<j && arr[j] >= base ){//从右往左找第一个比基数小的，否则-1，继续寻找
                    j--;
                }
                if(i < j) arr[i++] = arr[j];
                while (i<j && arr[i] <= base  ){//从左往右找第一个比基数大的,否则加1
                    i++;
                }
                if(i < j) arr[j--] = arr[i];
            }
            arr[i] = base;//基数交换
            quickSork(arr, left,i -1);//对左边的数组排序
            quickSork(arr, i+1,right);//对右边的数组排序
        }

    }
    public static void main(String[] args) throws Exception{
        int arr[] = new int[100];
        StringBuilder initStr = new StringBuilder();
        for(int i=0;i<arr.length;i++){
            arr[i] = (int)(Math.random()*100);
            initStr.append(arr[i]).append(",");
        }
        quickSork(arr,0,arr.length-1);
        StringBuilder initStr1 = new StringBuilder();
        for(int i=0;i<arr.length;i++){
            initStr1.append(arr[i]).append(",");
        }
        System.out.println(initStr1);
    }
}
