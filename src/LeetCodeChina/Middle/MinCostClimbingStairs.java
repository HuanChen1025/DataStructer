package LeetCodeChina.Middle;

/**
 * 本题的关键是要记住之前的结果，下一次使用的时候不再重复计算
 *
 * https://zhuanlan.zhihu.com/p/32980698
 */
public class MinCostClimbingStairs {

    public int minCostClimbingStairs(int[] cost) {
        if (cost.length == 0 || cost == null)
            return 0;
        int n = cost.length;

        if (n<2)
            return 0;

        int[] cm = new int[n+1];

        cm[0] = 0;
        cm[1] = 0;

        for (int i=2;i<=n;i++){
            //当前最小花费，包含两种情况，上一步一次过来和上上一步两次过来
            //dp[i] = min(dp[i-1] + cost[i - 1], dp[i-2] + cost[i-2])。
            cm[i] = Math.min(cm[i-2]+cost[i-2],cm[i-1]+cost[i-1]);
        }

        //最后返回dp[cost.length]，即跳到楼梯顶（第cost.length阶）的最小花费。
        return cm[n];
    }

    public static void main(String[] args) {
        int [] cost = {1, 100, 1, 1, 1, 100, 1, 1, 100, 1};
        MinCostClimbingStairs minCostClimbingStairs = new MinCostClimbingStairs();
        System.out.println(minCostClimbingStairs.minCostClimbingStairs(cost));
    }
}
