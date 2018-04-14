package LeetCodeChina.MiddleAlgorithm.dp;

/**
 * 不同路径
 */
public class UniquePaths {

    /**
     * 机器人位于一个 m x n 网格的左上角, 在下图中标记为“Start” (开始)。

     * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角，在下图中标记为“Finish”(结束)。

     * 问有多少条不同的路径？
     *
     * 动态规划，斐波那契数列，和爬梯子一样
     *
     * 因此我们构建一个二维数组来存储每个格子的路径数，从终点处开始向上推。
     * 如果碰到某行或者某列是0的情况，那么路径数就直接为1，
     * 否则，该格子的路径数等于其下面的格子路径数加上其右边的格子的路径数。
     *
     * 从下往上走，使用二维数组，满足斐波那契数列，碰到某行或者某列是0的情况，
     * 那么路径数就直接为1（因为只有一条路可走）
     *
     * 否则，按照斐波那契的公式，由它的副对角线的路径相加
     * @param m
     * @param n
     * @return
     */
    public int uniquePaths(int m, int n) {
        int[][] result = new int[m][n];
        for (int i=0;i<m;i++)
            for (int j=0;j<n;j++){
            if (i==0 || j==0)
                result[i][j]=1;
            else {
                result[i][j] = result[i-1][j] + result[i][j-1];
            }

            }
        return result[m-1][n-1];
    }
}
