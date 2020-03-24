package algorithm;

/**
 * 生成100个随机数，用选择排序算法从小到大排序排序。
 * O(n^2)
 */
public class SelectionSort {
    public static void main(String[] args) {
        int arr[] = new int[100];
        StringBuilder initStr = new StringBuilder();
        for(int i=0;i<100;i++){
            arr[i] = (int)(Math.random()*100);
            initStr.append(arr[i]).append(",");
        }
        StringBuilder finalStr = new StringBuilder();
        for(int i=0;i<arr.length;i++){
            for(int j=i+1;j<arr.length;j++){
                if(arr[j] < arr[i]){
                    int swap = arr[i];
                    arr[i] = arr[j];
                    arr[j] = swap;
                }
            }
            finalStr.append(arr[i]).append(",");
        }
        System.out.println(initStr);
        System.out.println(finalStr);
    }
}
