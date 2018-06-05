package LeetCodeChina.StockAndHeap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 *
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 * For example, given n = 3, a solution set is:
 */
public class _22_GenerateParentheses {

    public static List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        String paren ="";
       // helper(result,paren,n,n);
        backtracking(result,paren,0,0,n);
        return result;
    }

    /**
     * 递归：https://segmentfault.com/a/1190000005567093
     * 保证：
     * 1） 插入数量不超过n

     * 2） 可以插入 ） 的前提是 ( 的数量大于 ）
     * @param result
     * @param paren
     * @param left
     * @param right
     */
    public static void helper(List<String> result ,String paren,int left,int right){
        //如果某一方为0，返回结果给调用者
        if (left == 0 && right ==0){
            result.add(paren);
            return;
        }
        //递归
        if (left>0){
            helper(result,paren+"(",left-1,right);
        }
        //递归
        if (right>0 && left<right){
            helper(result,paren+")",left,right-1);
        }
    }


    /**
     * 回溯法
     * @param result
     * @param str
     * @param open
     * @param close
     * @param max
     */
    private static void backtracking(List<String> result,String str,int open,int close,int max){
        //符合返回条件，返回结果
        if (str.length() == max*2){
            result.add(str);
            return;
        }

        if (open<max){
            backtracking(result,str+"(",open+1,close,max);
        }

        if (close<open){
            backtracking(result,str+")",open,close+1,max);
        }
    }

    public static void main(String[] args) {
        System.out.println(generateParenthesis(3));
    }
}
