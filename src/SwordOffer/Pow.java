package SwordOffer;

public class Pow {

    /**
     * 不全面，不高效，问题多
     * @param base
     * @param exponent
     * @return
     */
    public static  double pow(double base, int exponent){
        double res = 1;

        //指数为负数的情况，求倒数
        //当exponent 为负数时，会出现分母为 0
        if (exponent <0){
            exponent = -exponent;
            for (int i = 0;i<exponent;i++){
                res *= base;
            }
            return 1/res;
        }

        //指数为正数的情况
        for (int i = 0;i<exponent;i++){
           res *= base;
        }
        return res;
    }


    /**
     * 没有包含负数的情况
     * 此处用到了一个公式，将指数除以2
     * 采用位运算和与运算已经是最高效的方法了
     * C 语言中的输入为unsigned，java 中应该如何处理呢？
     * @param base
     * @param exponent
     * @return
     */
    public static  double pow_01(double base, int exponent){
        if (base == 0)
            return 1;
        if (exponent == 1)
            return base;
        //用位运算代替乘除法
        double result = pow_01(base,exponent>>1);
        result *=result;
        //用与运算判断是否为奇数
        if ((exponent & 0x1) == 1){
            result *=base;

        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(pow_01(3,-1));
    }
}
