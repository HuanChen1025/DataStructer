package LeetCodeChina.PrimaryAlgorithm.Other;

/**
 * 编写一个函数，输入是一个无符号整数，返回的是它所有 位1 的个数（也被称为汉明重量）。

 * 例如，32位整数 '11' 的二进制表示为 00000000000000000000000000001011，所以函数返回3。
 */
public class HammingWeight {

    /**
     * 本题是别人的经典解法
     *
     * 另外题目告诉我们，我们需要将 n 看成一个 32位的无符号整数
     * @param n
     * @return
     */
    // you need to treat n as an unsigned value
    public int hammingWeight_01(int n) {
        int res = 0;
        for (int i = 0; i < 32; ++i) {
            res += (n & 1);
            n = n >> 1;
        }
        return res;
    }

    public static void main(String[] args) {
        HammingWeight hammingWeight = new HammingWeight();
        //  4294967295 (11111111111111111111111111111111)
        System.out.println(hammingWeight.hammingWeight_01(11));
    }
}
