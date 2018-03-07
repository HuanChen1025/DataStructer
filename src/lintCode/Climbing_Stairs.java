package lintCode;

public class Climbing_Stairs {
    /**
     * https://www.cnblogs.com/grandyang/p/4079165.html
     * @param n: An integer
     * @return: An integer
     */
    public static int climbStairs(int n) {
        // write your code here
        if (n ==1){
            return 1;
        }
        if (n == 0){
            return 0;
        }
        int [] dp = new int[n];
        dp[0] = 1; //爬到第一步只有一种解决方案
        dp[1] = 2; //爬到第二步有两种解决方案
        for (int i = 2; i < n; ++i){
            dp[i] = dp[i-1] + dp[i-2]; // 爬到第 i 步，要么是从第 i-1 步来，要么是从第 i-2 步；来，所有第i步的解决方案为这两步的方案的和
        }
        return dp[n-1];
    }

    public static void main(String[] args) {
        System.out.println(climbStairs(0));
    }
}
