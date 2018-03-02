package lintCode;

public class Valid_Perfect_Square {
    /**
     * @param num: a positive integer
     * @return: if num is a perfect square else False
     *  Example
        For example:
        Given num = 16
        Returns True
     */
    public static boolean isPerfectSquare(int num) {
        // write your code
        if(num == 1){
            return true;
        }
        long x = num/2;
        long t = x * x; //改为long类型，防止num值过大时计算溢出
        while (t > num){
            x = x/2;
            t = x*x;
        }
        for (long i = x; i <= 2*x ;++i){
            if ( i*i == num ) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(isPerfectSquare(1000000));
    }
}
