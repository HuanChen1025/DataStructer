package lintCode;

public class Reverse_3_digit_Integer {
    /**
     * 将三位整数反转，不考虑int数字的溢出情况
     * @param number: A 3-digit number.
     * @return: Reversed number.
     */
    public static int reverseInteger(int number) {
        // write your code here
        int remainder;
        int result =0;
        while (number != 0){
            remainder = number%10; //获取余数
            number = number/10;    //获取除10后的商
            result = result * 10 +remainder;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(reverseInteger(901));

    }
}
