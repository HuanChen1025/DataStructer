package LeetCodeChina.Easy;

/**
 * 367. 有效的完全平方数
 * 给定一个正整数 num，编写一个函数，如果 num 是一个完全平方数，则返回 True，否则返回 False。

 * 注意：不要使用任何内置的库函数，如  sqrt。
 */
public class IsPerfectSquare {

    public boolean isPerfectSquare(int num) {
        if (num<0)
            return false;

        int start = 0;
        int end = num;

        int middle = (start+end)/2;

        while (start<=end){
            // int  Sum = middle<<1; //采用移位算法也很快
            if (Math.pow(middle,2)>num){
                end = middle-1;
            }
            else  if (Math.pow(middle,2)<num){
                start =middle+1;
            }
           else {
                return true;
            }
            middle = (start+end)/2;
        }
        return false;
    }

    public static void main(String[] args) {
        IsPerfectSquare isPerfectSquare = new IsPerfectSquare();

        System.out.println( isPerfectSquare.isPerfectSquare(11));
    }
}
