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

    public static void main(String[] args) {
        System.out.println(pow(0,-2));
    }
}
