package SwordOffer;

/**
 * 统计从 1 到 n 中 1 出现的次数
 */
public class NumberOf1Between1AndN {

    /**
     * 一个数字一个数字的计算，时间复杂度介于 n 和 n2 之间
     * 时间复杂度太高，不通过AC
     * @param n
     * @return
     */
    public static int numberOf1(int n){
        if (n<=0){
            return 0;
        }
        int count = 0;
        while (n>0){
            if (n%10 == 1)
                count++;
            n = n/10;
        }
        return count;
    }

    /**
     * 第二种方法是对 1 找规律，做递归，把时间复杂度降低到 O(n) 以下
     *
     *
     */

    public static void main(String[] args) {
        int number = 0;
        int n =10;
        for (int i=0;i<=n;i++){
            number += numberOf1(i);
        }
        System.out.println(number);
    }

}
