package LeetCodeChina.PrimaryAlgorithm.Str;

/**
 * 给定一个范围为 32 位 int 的整数，将其颠倒。
 * 输入: 123
 * 输出:  321
 */
public class Reverse {
    public int reverse(int x) {
        boolean isNegative = false;
        if (x<0){
            isNegative = true;
           x = Math.abs(x);       //求取绝对值
        }
        //注意：这里要采用 long 来存储结果，才能判断颠倒的结果是否溢出
        long result =0;
        while (x!=0){
            int temp = x%10;
            x /=10;
            result =  result*10 + temp;
            if (result>0x7FFFFFFF || result<0x80000000)
                return 0;
        }
        return isNegative?(int)-result:(int)result;
    }

    public static void main(String[] args) {
        Reverse reverse = new Reverse();
        System.out.println(reverse.reverse(1534236469));
    }
}
