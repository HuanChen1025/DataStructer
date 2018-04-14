package LeetCodeChina.MiddleAlgorithm.Math;

/**
 * 阶乘后的零

 * 给定一个整数 n，返回 n! 结果尾数中零的数量。

 * 注意: 你的解决方案应为对数时间复杂度。
 */
public class TrailingZeroes {

    /**
     * 主要为找 5 和 5 的倍数，他们的个数就是 0 的个数
     *
     * 1、 每隔5个，会产生一个0，比如 5， 10 ，15，20.。。
     * 2 、每隔 5×5 个会多产生出一个0，比如 25，50，75，100 ； 25*4 =100
     * 3 、每隔 5×5×5 会多出一个0，比如125.  125*8=1000

     * 所以100！末尾有多少个零为：100/5+100/25=20+4=24那么1000！末尾有多少个零呢？
     * 同理得： 1000/5+1000/25+1000/125=200+40+8=248
     * 到此，问题解决了，但我们在学习过程中应当学会发散思维、举一反三。
     * @param n
     * @return
     */
    public int trailingZeroes_01(int n) {
        //5 以下都不会产生 0
        if (n<5)
            return 0;
        int res = 0;

        while (n>=5){
           res += n/5;
           n = n/5;
        }

        return res;
    }

    public static void main(String[] args) {
        TrailingZeroes trailingZeroes = new TrailingZeroes();
        System.out.println(trailingZeroes.trailingZeroes_01(30));

    }
}
