package LeetCodeChina.Easy;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class FindWords {
    public String[] findWords(String[] words) {
        List<String> resTemp = new ArrayList<>();
        if (words== null || words.length == 0)
            return null;
        //把键盘上的每一行字母作为一个字符串数组的元素表示出来。（只处理26个字母）
        String[] strs = {"QWERTYUIOP","ASDFGHJKL","ZXCVBNM"};

        HashSet<Character> first = new HashSet<>();
        HashSet<Character> second = new HashSet<>();
        HashSet<Character> three = new HashSet<>();

        for (int i=0;i<strs[0].length();i++)
            first.add(strs[0].charAt(i));

        for (int i=0;i<strs[1].length();i++)
            first.add(strs[1].charAt(i));

        for (int i=0;i<strs[1].length();i++)
            first.add(strs[1].charAt(i));


        return null;
    }
}
