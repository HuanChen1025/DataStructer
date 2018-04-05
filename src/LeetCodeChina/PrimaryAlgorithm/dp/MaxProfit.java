package LeetCodeChina.PrimaryAlgorithm.dp;

/**
 * 买卖股票的最佳时机
 *
 * 假设你有一个数组，其中第 i 个元素是一支给定股票第 i 天的价格。

 * 如果您只能完成最多一笔交易（即买入和卖出一股股票），则设计一个算法来找到最大的利润。
 */
public class MaxProfit {

    /**
     * 最直觉的方法，双重for循环从后往前遍历，
     * 时间复杂度不能接受
     * 对于大数组，时间性能太差
     * @param prices
     * @return
     */
    public int maxProfit_01(int[] prices) {
        //校验输入
        if (prices == null || prices.length == 0)
            return 0;
        int result = 0;
        for (int i=prices.length-1;i>=0;i--){
            for (int j=i;j>=0;j--){
                int temp = prices[i]- prices[j];
                if (temp>result)
                    result = temp;
            }
        }
        return result;
    }

    /**
     * 寻求线性时间的方法
     * 找最小值的方式行不通
     *
     * 类似 [6,15,1,6,9] 无法成功查找
     * @param prices
     * @return
     */
    public int maxProfit_02(int[] prices) {
        //校验输入
        if (prices == null || prices.length == 0)
            return 0;

        int buyPricce = prices[prices.length-1];
        int buyIndex = 0;
        int maxProfit = 0;
        //从后往前遍历寻找最小值
        for (int i=prices.length-1;i>=0;i--){
            if (buyPricce>prices[i]){
                buyPricce = prices[i];
                buyIndex = i;
            }
        }
        buyIndex = prices.length - buyIndex;
        System.out.println(buyIndex);
        System.out.println(buyPricce);

        for (int i=buyIndex;i<prices.length;i++){
            if ((prices[i]-buyPricce)>maxProfit)
                maxProfit = prices[i]-buyIndex;
        }
        return maxProfit;
    }

    /**
     * 快速求取最大利润
     *
     * O(N) 时间复杂度，O（1） 空间复杂度，快速查找
     * @param prices
     * @return
     */
    public int maxProfit_03(int[] prices) {
        //校验输入
        if (prices == null || prices.length == 0)
            return 0;

        int  resultMax = 0;
        int current = prices[0];

        // 变量current为买入价格，resultMax为最大利润
        // 低则买入，高则卖出
        for (int i=1;i<prices.length;i++){
            //价格低于当前，买入
            if (current>prices[i])
                current = prices[i];
            else {  //价格高于当前，卖出
                int currentMax = prices[i] - current;
                //与最大值比较，大于则替换返回最大值
                if (currentMax > resultMax)
                    resultMax = currentMax;
            }
        }
        return resultMax;
    }

    public static void main(String[] args) {
        MaxProfit maxProfit = new MaxProfit();
        int [] arr = {6,15,1,6,9};
        System.out.println(maxProfit.maxProfit_03(arr));
    }
}
