package SwordOffer;

/**
 * 用最简单的代码判断一个数是否是2的整数倍
 */
public class IntegePowerOf2 {

    public static boolean integePowerOf2(int x){
        if (x>=0){
            x = (x-1) & x;
            if (x == 0){
                return true;
            }
        }
        /**
         * 对负数部分的做不了，有错误
         */
        return false;
    }

    public static void main(String[] args) {
        System.out.println(integePowerOf2(16));

    }

}
