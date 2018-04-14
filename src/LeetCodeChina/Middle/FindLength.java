package LeetCodeChina.Middle;

import java.util.HashMap;

/**
 * 718. Maximum Length of Repeated Subarray

 */
public class FindLength {

    /**
     * 哈希表
     *
     * 不能用哈希表，因为有重复元素
     * @param A
     * @param B
     * @return
     */
    public int findLength(int[] A, int[] B) {
        if (A.length == 0 || B.length == 0)
            return 0;

        //不能用哈希表，因为有重复元素
        HashMap<Integer,Integer> Amap = new HashMap<>();

        for (int i=0;i<A.length;i++){
            Amap.put(A[i],i);
        }
        int currentMax = 0;
        int resultMax = 0;

        for (int Bindex=0;Bindex<B.length;Bindex++){
            int Aindex =  Amap.get(B[Bindex]);
            for (int i=Aindex,j=Bindex;i<A.length && j<B.length;){
                if (A[i] == B[j]){
                    i++;
                    j++;
                    currentMax++;
                }
            }
            if (currentMax>resultMax){
                resultMax = currentMax;
            }
        }
        return resultMax;
    }


    /**
     * 动态规划
     * 时间复杂度O(N^2)，空间复杂度O（N^2)
     *
     * https://blog.csdn.net/koala_tree/article/details/78488711
     * 利用动态规划的思想，首先寻找问题的最优子结构，给出问题的状态转移方程；
     * 利用 dp[i][j] 来存储A[i]和B[j]之前的LCS（最长公共子序列）；
     * 当A[n]=B[m]时，dp[i][j] = dp[i-1][j-1] + 1;max = Math.max(max, dp[i][j])。
     * @param A
     * @param B
     * @return
     */
    public int findLength_01(int[] A, int[] B) {
        if (A.length == 0 || B.length == 0)
            return 0;
        if (A== null || B == null)
            return 0;

        int m = A.length;
        int n = B.length;
        int resultMax = 0;

        int[][] dp = new int[m+1][n+1];

        for (int i=0;i<=m;i++){
            for (int j=0;j<=n;j++){
                if (i==0 || j==0){
                    dp[i][j] =0;
                }
                else {
                    if (A[i-1] == B[j-1]){
                        dp[i][j] = dp[i-1][j-1] +1;
                        resultMax = Math.max(resultMax,dp[i][j]);
                    }
                }
            }
        }
        return resultMax;
    }




    public static void main(String[] args) {
        int[] A ={1,2,3,2,1};
        int[] B ={3,2,1,4,7};

        FindLength findLength = new FindLength();

        System.out.println(findLength.findLength(A,B));

    }
}
