package LeetCodeChina.PrimaryAlgorithm.Arrays;

/**
 * 假设有一个数组，它的第 i 个元素是一个给定的股票在第 i 天的价格。
 * 设计一个算法来找到最大的利润。你可以完成尽可能多的交易（多次买卖股票）。
 * 然而，你不能同时参与多个交易（你必须在再次购买前出售股票）。
 *
 * 贪心算法，如果第二天价格比第一天价格高，卖掉。
 *
 * 问题：如果股价高买，跌了之后再涨起来，卖不卖呢
 */
public class MaxProfit {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0)
            return 0;

        int max = 0;
        for (int i=1;i<prices.length;i++){
            //采用 i，i-1 形式，而不是 i+1,i 的形式
            if (prices[i]>prices[i-1]){
                max +=(prices[i]-prices[i-1]);
            }
        }
        return max;
    }
}
