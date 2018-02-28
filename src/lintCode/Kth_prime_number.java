package lintCode;

public class Kth_prime_number {

    /**
     * 判断n是否为质数
     * @param n
     * @return
     */
    public int isPrime(int n){
        for (int i=2;i<=Math.sqrt(n);i++){
            if (n%i == 0){
                return 0;
            }
        }
        return 1;
    }

    /**
     * @param k: the number
     * @return: the rank of the number
     */
    public int kthPrime(int k) {
        // write your code here
      if (k<=0){
          return -1;
      }
        int  n=1;
       while (k>2){
           if ( isPrime(k)==1)  //如果递减判断为质数，则将质数的数量加1处理
               n++;
           k--;
       }
        return n;
    }

    public static void main(String[] args) {
        Kth_prime_number kth_prime_number = new Kth_prime_number();

        System.out.println( kth_prime_number.kthPrime(1));

    }

}
