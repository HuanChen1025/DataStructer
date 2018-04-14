package LeetCodeChina.Middle;

import java.util.ArrayList;
import java.util.List;

public class CountSubstrings {

    /**
     * 暴力解法，双重for循环
     *
     *
     * 128 / 130 个通过测试用例
     * 状态：超出时间限制
     * @param s
     * @return
     */
    public int countSubstrings(String s) {
        if (s.length() == 0 || s == null)
            return 0;

        int res = 0;
        List<String> result = new ArrayList<>();

        for (int i=0;i<=s.length()-1;i++){
            for (int j=i+1;j<=s.length();j++){
                if (IsCountSubstrings(s.substring(i,j))== true){
                    res++;
                    result.add(s.substring(i,j));
                }
            }
        }
        return res;
    }

    private boolean IsCountSubstrings(String str){
        char [] chars = str.toCharArray();

        int start = 0;
        int end = chars.length-1;

        while (start<=end){
            if (chars[start] == chars[end]){
                start++;
                end--;
            }
            else
                return false;
        }
        return true;
    }

    /**
     * 改良方法，动态规划
     *
     * 写不出来，看不懂
     * @param s
     * @return
     */
    public int countSubstrings_01(String s) {


        return -1;
    }

    public static void main(String[] args) {
//        CountSubstrings countSubstrings = new CountSubstrings();
//        String s = "a";
//        System.out.println(countSubstrings.countSubstrings(s));

        System.out.println(Boolean.valueOf("True"));

    }
}
