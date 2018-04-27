package Interview.huawei;

import java.util.Scanner;

/**
 * 最大连续四个数最大
 */
public class Max4 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] arr = new int[21];
        for (int i=0;i<arr.length;i++){
            arr[i] = in.nextInt();
        }
        in.close();
        System.out.println(max4(arr));
    }

    /**
     * 暴力求解
     * @param arr
     * @return
     */
    public static  int  max4(int arr[]){
        int sum = 0;
        int index = -1;
        for (int i=0;i<arr.length-3;i++){
            int temp = arr[i] + arr[i+1] + arr[i+2] +arr[i+3];
            if (temp>sum){
                sum = temp;
                index =i;
            }
        }
        return index;   //返回索引从 0 开始
    }

    /**
     * 本题是动态规划求解
     * @param arr
     * @return
     */
    public static  int  max4_01(int arr[]){
        //校验输入，如何区分实际 0 和 错误 0
        if (arr.length == 0 || arr == null)
            return 0;

        //dp 的索引为 arr.length -4
        int [] dp = new int[arr.length-3];

        dp[0] = arr[0] +arr[1] +arr[2] +arr[3];

        for (int i=1;i<dp.length;i++){
           // dp[i] = dp[i-]


        }









        return -1;
    }
}
