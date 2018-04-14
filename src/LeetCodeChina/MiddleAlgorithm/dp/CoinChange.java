package LeetCodeChina.MiddleAlgorithm.dp;

/**
 * 零钱兑换
 */
public class CoinChange {
    /**
     * 给定不同面额的硬币(coins)和一个总金额(amount)。
     * 写一个函数来计算可以凑成总金额所需的最少的硬币个数。
     * 如果没有任何一种硬币组合方式能组成总金额，返回-1。
     *
     * 采用 dp 数组记录 account 以下每一次的最低零钱兑换
     *
     * 太难了，并不是我写的
     *
     * 并且只是读都有些吃力
     * @param coins
     * @param amount
     * @return
     */
    public int coinChange(int[] coins, int amount) {
        if (coins == null || coins.length==0)
            return -1;
        int[] dp = new int[amount+1];
        for (int i=0;i<dp.length;i++)
            dp[i] = amount+1;

        dp[0] = 0;

        for (int i=1;i<=amount;i++){
            for (int j=0;j<coins.length;j++){
                if (coins[j]<=i){
                    dp[i] = Math.min(dp[i],dp[i-coins[j]]+1);
                }
            }
        }
        return dp[amount]>amount ? -1 : dp[amount];
    }

    public static void main(String[] args) {

        int[] coins = {2};

        CoinChange coinChange = new CoinChange();

        System.out.println(coinChange.coinChange(coins,1));



    }
}
