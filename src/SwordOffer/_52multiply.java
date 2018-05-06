package SwordOffer;

import java.util.Arrays;

/**
 * 给定一个数组A[0,1,...,n-1],请构建一个数组B[0,1,...,n-1],
 * 其中B中的元素B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]。不能使用除法。
 * i 中的每个元素为A中对应位置的左右两边元素的乘积
 */
public class _52multiply {
    public static int[] multiply(int[] A) {
        //校验输入
        if (A== null || A.length == 0)
            return A;
        //构建返回数组
        int[] B = new int[A.length];
        B[0] =1;
        //计算左边的乘积值,第一个元素的左边乘积值补为1
        for (int i=1;i<A.length;i++){
            B[i] = B[i-1] * A[i-1];
        }

        //再次遍历，让左边乘上右边
        int right = 1;
        for (int i=A.length-1;i>=0;i--){
            B[i] *= right;
            right = right*A[i];
        }
        return B;
    }

    public static void main(String[] args) {
        int [] nums ={3,4,5,6};
        System.out.println(Arrays.toString(multiply(nums)));
        System.out.println();

    }
}
