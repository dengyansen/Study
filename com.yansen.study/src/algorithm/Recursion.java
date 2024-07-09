package algorithm;
/**
 * 递归
 */
public class Recursion {
    public static void main(String[] args) {
        int i =5;
        System.out.println(sum(i));
    }
    static int sum(int sum){
        if(sum == 1){
            return sum;
        }else{
            return sum*sum(sum-1);
            /**sum(5) = 5*sum(4)
             * sum(4) = 4*sum(3)
             * sum(3) = 3*sum(2)
             * sum(2) = 2*sum(1)
             * sum(1) = 1;
             * so,sum(5) = 5*4*3*2*sum(1)
             *
             */


        }
    }
}
