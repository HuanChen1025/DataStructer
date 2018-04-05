package LeetCodeChina.PrimaryAlgorithm.Other;

/**
 *  颠倒二进制位
 *
 *  颠倒给定的32位无符号整数的二进制位。

 *  例如，给定输入 43261596（二进制表示为 00000010100101000001111010011100 ），返回 964176192（二进制表示为 00111001011110000010100101000000）。
 */
public class ReverseBits {
    // you need treat n as an unsigned value

    /**
     *O(N),O(1)的算法
     * @param n
     * @return
     */
    public int reverseBits_01(int n) {
        int resultDate = 0;
        for (int i=0;i<=31;i++){
            int index = n&1;
            n=n>>1;
            //如果当前右移输出的是 1，把这个1向左移动 31-i 位，再与之前的和相加
            if (index ==1){
                int temp = 1<<31-i;
                resultDate +=temp;
            }
            index = 0; //索引重新赋值为0
        }
        return resultDate;
    }

    public static void main(String[] args) {
        ReverseBits reverseBits = new ReverseBits();
        System.out.println(reverseBits.reverseBits_01(43261596));
    }
}
