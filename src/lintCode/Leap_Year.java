package lintCode;

public class Leap_Year {
    /**
     * @param n: a number represent year
     * @return: whether year n is a leap year.
     */
    public static boolean isLeapYear(int n) {
        // write your code here
        if (n%100 != 0 || n%400 ==0){
            if ( n%4 ==0){
                return true;
            }

        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(isLeapYear(2000));
    }
}
