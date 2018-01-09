package lintCode;

public class Fibonacci {
    /*
     * @param n: an integer
     * @return: an ineger f(n)
     * 0, 1, 1, 2, 3, 5, 8, 13, 21, 34 ...
     * 下标从1开始
     * 采用while 循环的方式
     */
    public static int fibonacci(int n) {
        // write your code here
        if (n == 1){
            return 0;
        }
        if (n == 2){
            return 1;
        }
        int first =0;
        int second =1;
        while (n>=3){
            int temp =second;
            second = first +second;
            first =temp;
            n--;
        }
        return second;

    }

    /**
     * 采用递归计算，如果n的值过大的话，会有相当多重复计算的部分
     * 时间复杂度很高，而采用循环的时间复杂度为O(n)
     * @param n
     * @return
     */
    public static int fibonacci2(int n) {
        if (n == 1){
            return 0;
        } if (n == 2){
            return 1;
        }
        int result = fibonacci(n-1) + fibonacci(n-2);


        return result;
    }

    public static void main(String[] args) {
        System.out.println(fibonacci(10));
        System.out.println("----------------");
        System.out.println(fibonacci2(10));

    }
}
