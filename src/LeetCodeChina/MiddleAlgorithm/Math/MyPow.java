package LeetCodeChina.MiddleAlgorithm.Math;

/**
 * 实现 pow(x, n)。
 */
public class MyPow {
    /**
     * 最直接的方法，暴力求解
     *
     * 超出时间限制，无法AC
     * @param x
     * @param n
     * @return
     */
    public double myPow(double x, int n) {
        double result = 1;

        if (n==0)
            return result;

        if (n>0){
            while (n>0){
                result *= x;
                n--;
            }
        }
        else {
            n = -n;
            while (n>0){
                result *= x;
                n--;
            }
            result = 1/result;
        }
        return result;
    }

    public static void main(String[] args) {

    }
}
