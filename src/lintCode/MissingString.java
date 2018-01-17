package lintCode;

import java.util.*;

public class MissingString {


    /**
     * 采用HashTable
     * @param : a given string
     * @param : another given string
     * @return: An array of missing string
     */
    public List<String> missingString(String str1, String str2) {
        // Write your code here
        List<String> res = new ArrayList<>();
        if (str1.length() > str2.length()){
            String temp = str1;     //将较长的字符串传给str2
            str1 = str2;
            str2 = temp;
        }
        String [] arr1 = str1.split(" ");   //较短的字符串
        String [] arr2 = str2.split(" ");   //较长的字符串
        Set<String> set = new HashSet<>();          //HashSet 不能重复出现，去重

        for (String str : arr1){
            set.add(str);   //没有重复的字符
        }
        for (String str : arr2){
            //如果set 中的字符没有在arr2 中出现，添加到res 中去
            if (!set.contains(str)){
                res.add(str);
            }
        }
        return res;
    }
}
