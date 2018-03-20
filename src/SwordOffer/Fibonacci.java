package SwordOffer;

public class Fibonacci {
    public static void main(String[] args) {
        System.out.println();

    }

    public static int fibonacci(int n){
        if (n<=0){
            return -1;
        }

       if (n == 1 || n == 2){
           return 1;
       }
       int first = 1;
       int second = 1;
        while (n > 3){
            int temp = second;
            second = first + second;
            first = temp;
            n--;
        }

        return second;
    }
}
