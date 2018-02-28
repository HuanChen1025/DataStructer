package lintCode;

public class Hex_Conversion {
    /**
     * @param n: a decimal number
     * @param k: a Integer represent base-k
     * @return: a base-k number
     */
    public static String hexConversion(int n, int k) {
        // write your code here
        int remainder; //定义一个变量存储余数
        int sum = 0;
        int b = 1;
        while(n != 0){
            remainder = n % k; //对目标数字求余
            n /= k; //对目标数字求商
            sum = sum + remainder  * b;
            b *= 10; //改变位数

        }

        return "" +sum +"";
    }

    public static void main(String[] args) {
        System.out.println(hexConversion(30,15));

    }


}
