package algorithm.sort;

/**
 * 插入排序
 * 算法复杂度n^2
 * 原地排序
 * 稳定
 */
public class InsertionSort {
    public static void main(String[] args) {
        int arr[] = {1,5,0,8,312,54,6};
        //1、从Index为1 的开始比较，循环n-1次，
        // 2、每次和前一个比较，若后一个比前一个小，则交换
        //3、 重复2直到下标<0
        for(int next = 1;next<arr.length;next++){
            int pre = next - 1;//
            int temp = arr[next];
            while (pre >= 0 && temp < arr[pre]){
                arr[pre+1] = arr[pre];
                pre--;
            }
            //最终位置
            arr[pre+1] = temp;
        }
//        System.out.println(arr.length);
        for(int i = 0;i<arr.length;i++){
            System.out.println(arr[i]);
        }
    }
}
