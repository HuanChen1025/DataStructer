package lintCode;

public class HashFunction {
    /*
     * @param key: A string you should hash
     * @param HASH_SIZE: An integer
     * @return: An integer
     */
    public static int hashCode(char[] key, int HASH_SIZE) {
        // write your code here
        if (key ==null && HASH_SIZE ==0){
            return 0;
        }
        double  sum = 0;

       for (int i=0;i<key.length;i++){
           sum += (int)key[i] * Math.pow(33,key.length-1);
       }
        System.out.println(sum);

        return (int)sum%HASH_SIZE;
    }

    /**
     * 这道题的方法没有看懂，按照之前的方法是通过不了其他测试的，
     * 但对这个方法也是完全迷茫的，不对为什么没有实现POW（）函数
     * @param key
     * @param HASH_SIZE
     * @return
     */
    public static int hashCode_01(char[] key, int HASH_SIZE) {
        long sum = (int)key[0];//sum * 33可能会超出int范围
        for(int i = 1; i < key.length; i++) {
            sum = sum * 33 % HASH_SIZE + (int)key[i];//即使求余，否则超出long范围
        }
        return (int)(sum % HASH_SIZE);


    }

    public static void main(String[] args) {
        char[] key = {'a','b','c','d'};
        System.out.println(hashCode_01(key,1000));
    }
}
