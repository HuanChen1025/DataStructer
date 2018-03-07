package lintCode;

public class Trailing_Zeros {
    /**
     * @param n: An integer
     * @return: An integer, denote the number of trailing zeros in n!
     */
    public static long trailingZeros(long n) {
        // write your code here, try to do it without arithmetic operators.
        long result = compute(n);
        int num =0;
        while (true){
            if (result%10 == 0){
                num++;
                result = result/10;
            }else {
                break;
            }
        }
        return num;

    }
    /**
     * 使用递归的方式实现阶乘
     * 如果输入数字过大，递归的计算时间相当耗时
     * @param n
     * @return
     */
    private static long compute(long n){
        if (n == 0){
            return 1;
        }
        else {
            long sum = n * compute(n - 1);
            return sum;
        }
    }

    /**
     * 不需要采用计算完阶乘之后，再去求取0的个数
     * 解析如下：
     * 只有2和5相乘才会出现0，其中整十也可以看做是2和5相乘的结果，
     * 所以，可以在n之前看看有多少个2以及多少个5就行了，又发现2的数量一定多于5的个数，
     * 于是我们只看n前面有多少个5就行了，于是n/5就得到了5的个数，还有一点要注意的就是25这种，
     * 5和5相乘的结果，所以，还要看n/5里面有多少个5，也就相当于看n里面有多少个25，
     * 还有125，625.。。
     * @param n
     * @return
     */
    public static long trailingZeros2(long n) {
        long count = 0;
        for(int i = 1; Math.pow(5,i) <= n; i++) {
            count += n / (long)Math.pow(5,i);//注意强制类型转换
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(trailingZeros2(11));
    }

}
