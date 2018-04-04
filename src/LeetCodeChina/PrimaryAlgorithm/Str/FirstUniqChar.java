package LeetCodeChina.PrimaryAlgorithm.Str;

import java.util.HashMap;

/**
 * 字符串中的第一个唯一字符
 *
 * 给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。
 *
 * 如果不存在，则返回 -1。
 */
public class FirstUniqChar {

    /**
     * 采用自己构建的哈希表
     * @param s
     * @return
     */
    public int firstUniqChar_01(String s) {
        if (s == null)
            return -1;


        //使用一个长度为 256 的哈希表
        int [] hashMap = new int[256];

        //初始化
        for (int i=0;i<hashMap.length;i++){
            hashMap[i] =0;
        }

        //将字符的出现次数存储到哈希表中
        for (int i=0;i<s.length();i++){
            hashMap[s.charAt(i)] +=1;
        }

        //找到第一个只出现一次的字符
        for (int i=0;i<s.length();i++){
            if (hashMap[s.charAt(i)]== 1)
                return i;
        }
        return -1;
    }


    /**
     * 有一种更快速的方法，采用字符串索引的特性
     * @param s
     * @return
     */
    public int firstUniqChar_02(String s) {

        return -1;
    }

    public static void main(String[] args) {
        FirstUniqChar firstUniqChar = new FirstUniqChar();
        String s = "sshc";
        System.out.println(firstUniqChar.firstUniqChar_01(s));

    }
}
