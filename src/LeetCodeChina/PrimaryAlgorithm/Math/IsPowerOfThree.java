package LeetCodeChina.PrimaryAlgorithm.Math;

/**
 * 3的幂
 *
 *  给出一个整数，写一个函数来确定这个数是不是3的一个幂。
 */
public class IsPowerOfThree {

    boolean initalOne =  false;

    /**
     * 如何判断是第一个1 呢
     * @param n
     * @return
     */
    public boolean isPowerOfThree_01(int n) {
        if (n<=0)
            return false;
        else if (n==1)
            return true;
       else if (n%3 ==0){
           //此处直接 return 否则会出现错误
           return isPowerOfThree_01( n /=3);
         }
        else {
            return false;
        }
    }

    /**
     * 更加优化的算法，不采用递归
     * @param n
     * @return
     */
    public boolean isPowerOfThree_02(int n) {


        return false;
    }

    public static void main(String[] args) {
        IsPowerOfThree isPowerOfThree = new IsPowerOfThree();

        System.out.println(isPowerOfThree.isPowerOfThree_01(30));

        System.out.println(0%3);
    }
}
