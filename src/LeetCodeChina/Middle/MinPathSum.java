package LeetCodeChina.Middle;

/**
 * 64. 最小路径和
 * 给定一个只含非负整数的 m x n 网格，找到一条从左上角到右下角的可以使数字之和最小的路径。

 * 注意: 每次只能向下或者向右移动一步。
 *
 * 方法可以，属于动态规划，但是处理不好，耗时严重
 */
public class MinPathSum {
    public int minPathSum(int[][] grid) {
        if (grid == null || grid.length ==0 || grid[0].length == 0)
            return 0;

        int[][] dp = grid;
        for (int i=0;i<dp.length;i++){
            for (int j=0;j<dp[0].length;j++){
                if (i==0 && j==0){
                    dp[0][0] = grid[0][0];
                }
                else if (i==0){
                    dp[i][j] += dp[i][j-1];
                }
                else if (j == 0){
                    dp[i][j] += dp[i-1][j];
                }
                else {
                    dp[i][j] = Math.min(dp[i-1][j]+dp[i][j],dp[i][j-1]+dp[i][j]);
                }
            }
        }
        return dp[dp.length-1][dp[0].length-1];
    }


    /**
     * 改进的动态规划，首行，首列和其他的分开，不能改变原数组
     * @param grid
     * @return
     */
    public int minPathSum_01(int[][] grid) {
        if (grid == null || grid.length ==0 || grid[0].length == 0)
            return 0;

        int m = grid.length;
        int n = grid[0].length;

        int [][] dp = new int[m][n];

        //第一个
        dp[0][0] = grid[0][0];

        //首行
        for (int i=1;i<n;i++){
            dp[0][i] = dp[0][i-1] + grid[0][i];
        }

        //首列
        for (int i =1;i<m;i++){
            dp[i][0] = dp[i-1][0] + grid[i][0];
        }

        for (int i=1;i<m;i++){
            for (int j=1;j<n;j++){
                dp[i][j] = Math.min(dp[i-1][j]+grid[i][j],dp[i][j-1]+grid[i][j]);
            }
        }

        return dp[m-1][n-1];
    }

    public static void main(String[] args) {
        MinPathSum minPathSum = new MinPathSum();
        //[[1,2,5],[3,2,1]]
        int [][] nums = {{1,2,5},{3,2,1}};
        System.out.println(minPathSum.minPathSum(nums));

    }
}
