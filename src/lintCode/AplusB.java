package lintCode;

public class AplusB {
    /**
     * @param a: An integer
     * @param b: An integer
     * @return: The sum of a and b
     * 下面考虑二进制数的情况（5＝101，17＝10001）：
       仍然分3步：
        1. 忽略进位，对应各位数字相加，得到10100；
        2. 记录进位，本例中只有最后一位相加时产生进位1，进位值为10（二进制）；
        3. 按照第1步中的方法将进位值与第1步结果相加，得到最终结果10110，正好是十进制数22的二进制表示。
     *
     */
    public static int aplusb(int a, int b) {
        // write your code here
        while (b != 0){
            int temp = a & b;   //找进位，然后左移即可
            a = a^b;    //除了进位位置其他位置的和，进位位置为0
            b = temp <<1;   //
        }
        return a;
    }

    public static void main(String[] args) {
        System.out.println(aplusb(3,100000));

    }
}
