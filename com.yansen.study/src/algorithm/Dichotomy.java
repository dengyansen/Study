package algorithm;

/**
 * 已知 整数0-100，
 * 利用二分法，寻找某个数。
 * O(log2n)
 */
public class Dichotomy {
    public static void main(String[] args) {
        int arr[] = new int[100];
        for(int i=0;i<arr.length;i++){
            arr[i] = i;
        }
        int selectNum = (int) (100*Math.random());
        int low = arr[0];
        int high = arr[arr.length-1];
        int mid = (low + high)/2;
        int count = 0;
        int index = 0;
        while (low <= high){
            if(arr[mid] < selectNum){
                low = mid;
            }else{
                high = mid;
            }
            if(arr[mid] == selectNum){
                index = mid;
                break;
            }
            mid = (low + high)/2;
            count ++;
        }
        System.out.println("count ="+count);
        System.out.println("selectNum ="+selectNum);
        System.out.println("index ="+index);

    }
}
