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
     * �ݹ飺https://segmentfault.com/a/1190000005567093
     * ��֤��
     * 1�� ��������������n

     * 2�� ���Բ��� �� ��ǰ���� ( ���������� ��
     * @param result
     * @param paren
     * @param left
     * @param right
     */
    public static void helper(List<String> result ,String paren,int left,int right){
        //���ĳһ��Ϊ0�����ؽ����������
        if (left == 0 && right ==0){
            result.add(paren);
            return;
        }
        //�ݹ�
        if (left>0){
            helper(result,paren+"(",left-1,right);
        }
        //�ݹ�
        if (right>0 && left<right){
            helper(result,paren+")",left,right-1);
        }
    }


    /**
     * ���ݷ�
     * @param result
     * @param str
     * @param open
     * @param close
     * @param max
     */
    private static void backtracking(List<String> result,String str,int open,int close,int max){
        //���Ϸ������������ؽ��
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
