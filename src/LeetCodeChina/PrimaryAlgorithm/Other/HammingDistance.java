package LeetCodeChina.PrimaryAlgorithm.Other;

/**
 * 两个整数之间的汉明距离指的是这两个数字对应二进制位不同的位置的数目。

 * 给出两个整数 x 和 y，计算它们之间的汉明距离。
 */
public class HammingDistance {

    public int hammingDistance_01(int x, int y) {
        int result = 0;
        for (int i=0;i<31;i++){
            int currentX = x&1;
            int currentY = y&1;
            x=x>>1;
            y=y>>1;
            if (currentX != currentY)
                result++;
        }
        return result;
    }

    public static void main(String[] args) {
        HammingDistance hammingDistance = new HammingDistance();
        System.out.println(hammingDistance.hammingDistance_01(0,4));

    }
}
