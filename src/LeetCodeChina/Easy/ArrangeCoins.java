package LeetCodeChina.Easy;

/**
 * 441. 排列硬币
 */
public class ArrangeCoins {

    public int arrangeCoins(int n) {
        if (n<=0)
            return 0;

        //第 i 个 正常完成需要多少个硬币
        //当 n 为1804289383 时，超出内存限制
        int[] dp = new int[n];
        dp[0] =1;
        for (int i=1;i<n;i++){
        dp[i] = dp[i-1] +i+1;
        }
        int start = 0;
        int end = n-1;

        while (start <= end){
            int middle = (start + end)/2;
            if (dp[middle] > n){
                end = middle-1;
            }
            else if (dp[middle]<n){
                start = middle+1;
            }
            else {
                return middle+1;
            }

        }

        return start;
    }

    /**
     * 考虑采用更优化的方法
     * @param n
     * @return
     */
    public int arrangeCoins_01(int n) {
        if (n<=0)
            return 0;
        int start = 0;
        int end = n;



        while (start < end){
            int middle =(start + end)/2;


        }

        return -1;
    }



    public static void main(String[] args) {
        ArrangeCoins arrangeCoins = new ArrangeCoins();
        System.out.println(arrangeCoins.arrangeCoins(1));

    }
}
