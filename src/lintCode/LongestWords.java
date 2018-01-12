package lintCode;

import java.util.ArrayList;
import java.util.List;

public class LongestWords {
    /*
     * @param dictionary: an array of strings
     * @return: an arraylist of strings
     *
     * 首先通过一个for循环找出字符数组中最长的length
     * 在通过一个for循环筛选出符合要求的字符，并添加到结果集中
     */
    public List<String> longestWords(String[] dictionary) {
        // write your code here
        int maxLen =0;
        List<String> result = new ArrayList<>();
        for (int i = 0;i<dictionary.length;i++){
           if (dictionary[i].length()>maxLen){
               maxLen =dictionary[i].length();
           }
        }
        for (int i=0;i<dictionary.length;i++){
            if (dictionary[i].length()==maxLen){
                result.add(dictionary[i]);
            }
        }
        return result;
    }
}
