package LeetCodeChina.Arrays;

import java.sql.Array;
import java.util.Arrays;
import java.util.Collections;

public class _9PalindromeNumber {
    /**
     * 算法可以AC，但是不够优化，beats 31%
     * @param x
     * @return
     */
    public static boolean isPalindrome_01(int x) {
        if (x<0)
            return false;
        char [] chars = String.valueOf(x).toCharArray();
        int start = 0;
        int end = chars.length-1;
        while (start<end){
            if (chars[start] != chars[end]){
                return false;
            }
            else {
                start++;
                end--;
            }
        }

        return true;
    }

    /**
     * 反转传入的参数 x
     * 效率更差，only beats 8.5%
     * @param x
     * @return
     */
    public static boolean isPalindrome_02(int x) {
        if (x<0)
            return false;
        StringBuilder reverse = new StringBuilder(String.valueOf(x));
        if (x == Long.valueOf(reverse.reverse().toString()))
            return true;
        return false;
    }

    /**
     * 采取求余的方式 beats 31.5%
     * @param x
     * @return
     */
    public static boolean isPalindrome_03(int x) {
        if (x<0 || (x!=0 && x%10 ==0)) return false;    //增加初始判断的附加条件后，可以提升一些效率
        int temp=x;long res=0;

        while (temp!=0){
            res = res*10 + temp%10;
            temp /= 10;
        }
        return x == (int)res;
    }



    public static void main(String[] args) {
        System.out.println(isPalindrome_03(1212));
    }
}
