package LeetCodeChina.MiddleAlgorithm.Other;

/**
 * 两整数之和
 */
public class GetSum {

    /**
     * 不使用运算符 + 和-，计算两整数a 、b之和。
     * 使用位运算
     *
     * 由于不能适用+等运算符，根据提示，应该用位运算来完成。
     *
     * 异或运算（^）可以模拟一种不进位加法，比如：10^11=01，每一位的加法就相当于该位相加，但不进位。
     * 接下来的问题就是如何解决进位问题！由于异或运算仅仅是忽略了进位，那么每次有进位发生时，异或运算相当于忽略了高位的一个1。
     *
     * 按位与（&）运算可以帮助我们判断该位是否有进位，如10&11= 10，得到的1就是需要进位的位。
     * 由于加法进位是加在高位上的，所以很自然的想到了把与运算的结果往左移一位，再和异或结果相加，即为最后结果。
     *
     * 其实不是很明白
     * @param a
     * @param b
     * @return
     */
    public int getSum(int a, int b) {
        if (a == 0 || b==0)
            return a ==0?b:a;
        while (b != 0 ){    //b 表示进位
             int x = a^b; //a 和 b 求异或
             b = (a&b)<<1;
             a=x;
        }
        return a;
    }

    public static void main(String[] args) {
        GetSum getSum = new GetSum();
        System.out.println(getSum.getSum(1,5));

    }
}
