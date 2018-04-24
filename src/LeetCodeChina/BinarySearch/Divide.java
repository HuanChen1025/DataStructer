package LeetCodeChina.BinarySearch;

/**
 * 29. 两数相除
 */
public class Divide {

    /**
     * 除法的最朴素算法：
     * 当  被除数>除数  一直拿被除数减去除数，能减去除数的次数为两数相除的结果。
     *
     * 那么有一个做法就是通过左移操作减少减法的次数，但事实上循环的次数并没有减少。
     * 左移操作一次相当于乘以2，那么左移N次就相当于乘以2^N。
     * 我们每次减去2^(N) * 除数，再将上述count 每次加上 1<<2^N次方，就能大大缩减做减法的次数。
     *
     * 左移操作也解决了题目要求不能使用乘法的限制。
     * 这个N就可以通过内循环左移比较来判断。
     *
     * AC 不通过
     *
     * @param dividend
     * @param divisor
     * @return
     */
    public int divide(int dividend, int divisor) {
        int flag =1;

        //记录结果符号
        if (dividend <0)
            flag = -flag;
        if (divisor<0)
            flag = -flag;

        //取绝对值，并要防止溢出
        double num1 = Math.abs((double) dividend);
        double num2 = Math.abs((double) divisor);

        //两种特殊情况

        if (num1<num2){
            return 0;
        }

        if (divisor == 0)
            return Integer.MAX_VALUE;


        double result = 0;  //结果保存在这里

        while (num1 >= num2){
            double temp = num2;
            int count =0;
            while (temp<=num1){
               temp = (int)temp<<1;
               count++;
            }
            result = result +(double)(1<<(count-1));//转换成 double 防止溢出

            num1 = num1 - ((int)num2 << (count - 1));//被除数每次减去 2^(count-1)*除数
        }

        if (flag == 1 && result >Integer.MAX_VALUE)
            return Integer.MAX_VALUE;

        if (flag == -1 && result>Integer.MAX_VALUE)
            return Integer.MIN_VALUE;


        return (int)result*flag;
    }

    public static void main(String[] args) {
        Divide obj = new Divide();
        //-2147483648
        //-1
        System.out.println(Integer.MIN_VALUE);
        System.out.println(obj.divide(-2147483648,-1));

    }
}
