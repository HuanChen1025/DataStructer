package LeetCodeChina;

public class _204_CountPrimes {
    /**
     * 除 2 以外，质数必为奇数
     * 当 n 到10000 时，输出的数字不符合要求
     * 能通过大部分的测试用例，
     *
     * 这里面虽然赛选除了一部分，但是最大的缺陷是有些数的因子是最简质数的组合，所以此法失效
     * @param n
     * @return
     */
    public static int countPrimes_01(int n) {
        if (n<=2)
            return 0;
        int res;
        if (n<=3)
            return 1;
        else if (n<=5)
            return 2;
        else if (n<=7)
            return 3;
        else if (n<=10)
            return 4;
        else {
            res =4;
            for (int i=11;i<n;i+=2){
                if (i%3!=0 && i%5!=0 && i%7 != 0 && i%9 != 0 ){
                    res++;
                    System.out.println(i);
                }
            }
        }
        return res;
    }

    /**
     * 埃拉托斯特尼筛法
     * https://blog.csdn.net/lisonglisonglisong/article/details/45309651
     * https://zh.wikipedia.org/wiki/%E5%9F%83%E6%8B%89%E6%89%98%E6%96%AF%E7%89%B9%E5%B0%BC%E7%AD%9B%E6%B3%95
     * @param n
     * @return
     */
    public static int countPrimes_02(int n) {
        boolean[] isPrimes = new boolean[n];

        if (n<2)
            return 0;

        int count =0;

        for (int i=2;i<n;i++){

            if (!isPrimes[i])
            {
                count++;
                //针对当前选中的质数，去掉除它自己外，在 小于 n 的范围内的其他的倍数
                for (int j=2;i*j<n;j++){
                    isPrimes[i*j] = true;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(countPrimes_02(10000));

    }

}
