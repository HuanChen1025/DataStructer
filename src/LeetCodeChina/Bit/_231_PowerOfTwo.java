package LeetCodeChina.Bit;

/**
 * Given an integer, write a function to determine if it is a power of two.
 */
public class _231_PowerOfTwo {
    /**
     * 位运算
     * 算法思想为对满足条件的数，每次都除2
     * @param n
     * @return
     */
    public static boolean isPowerOfTwo_01(int n) {
        if (n<=0)
            return false;
        int mod = n%2;  //如果不是2的倍数，不能进入while循环，
        while (mod == 0 && n>0){
            n = n>>1;
            mod = n%2;
        }
        return n==1;
    }

    /**
     * 这个方法真的非常奇妙
     * 因为2的幂在二进制中必然只包含一个1，所以可以使用 n & (n-1) 来判断
     *
     * 两行代码AC，并且效率相当高，避免了使用循环带来的时间性能
     * @param n
     * @return
     */
    public static boolean isPowerOfTwo_02(int n) {
        if (n<=0) return false;
        return (n&(n-1))==0;
    }

        public static void main(String[] args) {
        System.out.println(isPowerOfTwo_02(4));
    }
}
