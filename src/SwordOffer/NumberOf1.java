package SwordOffer;

/**
 * 输入一个数，计算这个数中二进制形式 1 的个数
 */
public class NumberOf1 {

    /**
     * 输入为负数时死循环，会将结果循环为0XFFFFFFFF
     * @param x
     * @return
     */
    public static int numberOf1_1(int x){
        int res =0;
        //因为负数是有符号数，高位始终为1，循环过程中高位的1会向低位传递
        while (x >= 0){
            if ((x & 1) == 1){
                res +=1;
            }
            x = x >> 1; //x向右移动一位
        }
        return res;
    }

    /**
     * 该解法的优势是可以在输入为负数的情况下依然输出正确答案，避免死循环。
     * @param x
     * @return
     */
    public static int numberOf1_2(int x){
        int res = 0;
        int flag = 1;
        while (flag != 0){
            //此处，采用向左移位的方式对比
            if ((x & flag) != 0){
                res +=1;
            }
            flag = flag <<1;
        }
        return res;
    }

    /**
     * 最优解
     * 一个整数减去1，在和原来的整数做与运算，
     * 会把该整数最右边一个1变位0，这样有几个1，就循环几次
     * @param x
     * @return
     */
    public static int numberOf1_3(int x){
        int res = 0;
        //如果不为0，就循环
     while (x != 0){
         ++res;
         x = (x-1) & x;
     }
        return res;
    }


    public static void main(String[] args) {
        System.out.println(numberOf1_1(-2));
    }
}
