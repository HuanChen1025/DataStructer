package LeetCodeChina.MiddleAlgorithm.Math;

/**
 * x 的平方根
 *
 * 实现 int sqrt(int x) 函数。

 * 计算并返回 x 的平方根。

 * x 保证是一个非负整数。
 */
public class MySqrt {
    /**
     *
     * 平方根，开方
     *
     * 只需要返回整数部分
     *
     * 因为x的平方根不会超过x/2+1，
     * 所以我们用二分法从x/2+1开始寻找，为防止溢出，
     * 中间变量我们使用long 。
     *
     * 菜的不行，写不出来完全AC的答案
     *
     * @param x
     * @return
     */
    public int mySqrt(int x) {
        //保证输入
        if (x<=0)
            return 0;

         long i = 0;
         long j = x / 2 + 1;
        while (i <= j)
        {
             long mid = (i + j) / 2;
             long sq = mid * mid;
            if (sq == x) return (int)mid;
            else if (sq < x) i = mid + 1;
            else j = mid - 1;
        }
        return (int)j;
    }

    public static void main(String[] args) {


    }
}
