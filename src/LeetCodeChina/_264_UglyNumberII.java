package LeetCodeChina;

/**
 * 编写程序找第 n 个丑数。
 * 例如， 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 就是前10个丑数。
 */
public class _264_UglyNumberII {
    /**
     * 暴力法
     * Status: Time Limit Exceeded
     * 测试用例：500 / 596 test cases passed.
     * @param n
     * @return
     */
    public static int nthUglyNumber_01(int n) {
        if (n<=0)
            return 0;

        int res =0;
        int start =1;

        while (true){
            res +=isUglyNumber(start);
            if (res == n){
                break;
            }
            start++;
        }
        return start;
    }

    private static int isUglyNumber(int n){
        while (n%2==0)
            n /=2;

        while (n%3 == 0)
            n /=3;

        while (n%5 == 0)
            n /=5;
        return n==1?1:0;
    }

    /**
     * 因为ugly number 都是在前一个数的基础上乘上2或3或5之后生成的。
     * 通过对比查找最小值。
     *
     * @param n
     * @return
     */
    public static int nthUglyNumber_02(int n) {
        //缓存数组
        int [] ugly = new int[n];
        ugly[0] =1;
        int index2 =0, index3 =0,  index5 =0;
        int factor2=2,factor3=3,factor5=5;

        for (int i=1;i<n;i++){
            ugly[i] = Math.min(Math.min(factor2,factor3),factor5);
            if (factor2 == ugly[i]) factor2 = 2*ugly[++index2]; //如果当前最小值和 factor2相等，则将factor2提升两倍。
            if (factor3 == ugly[i]) factor3 = 3*ugly[++index3];
            if (factor5 == ugly[i]) factor5 = 5*ugly[++index5];
        }

        //为什么是 n-1.因为索引下标是从0开始的
        return ugly[n-1];
    }

    public static void main(String[] args) {
        System.out.println(nthUglyNumber_02(2));
    }
}
