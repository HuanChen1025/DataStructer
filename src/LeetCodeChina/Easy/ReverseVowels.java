package LeetCodeChina.Easy;

import java.util.HashMap;
import java.util.HashSet;

/**
 * 345. 反转字符串中的元音字母
 */
public class ReverseVowels {

    /**
     * 编写一个函数，以字符串作为输入，反转该字符串中的元音字母。
     *
     * 双指针
     * @param s
     * @return
     */
    public String reverseVowels_01(String s) {
        //校验输入
        if (s == null || s.length() == 0)
            return s;

        //将字符串转化为数组
        char[] chars = s.toCharArray();

        //创建 hashset,用于判别
        HashSet<Character> set = new HashSet<>();
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');
        set.add('A');
        set.add('E');
        set.add('I');
        set.add('O');
        set.add('U');

        int start = 0;
        int end =chars.length-1;

        while (start < end){
            //如果前后相等，交换
            if (set.contains(chars[start]) && set.contains(chars[end])){
                char temp = chars[end];
                chars[end] = chars[start];
                chars[start] = temp;
                start++;
                end--;
            }
            else {
                if (!set.contains(chars[start])){
                    start++;
                }
                else {
                    end--;
                }
            }
        }

        return String.valueOf(chars);
    }

    public static void main(String[] args) {
        ReverseVowels reverseVowels = new ReverseVowels();
        System.out.println(reverseVowels.reverseVowels_01("leEO"));

    }
}
