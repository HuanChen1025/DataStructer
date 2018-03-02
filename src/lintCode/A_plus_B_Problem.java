package lintCode;

public class A_plus_B_Problem {
    /**
     * @param a: An integer
     * @param b: An integer
     * @return: The sum of a and b
     */
    public static int aplusb(int a, int b) {
        // write your code here
        while (b !=0){
            int _a = a^b;
            int _b = (a & b) <<1; //涉及优先级问题，需要在求&的位置加上括号
            a = _a;
            b = _b;
        }
        return a;
    }

    public static void main(String[] args) {
        System.out.println(aplusb(200,3));
    }

}
