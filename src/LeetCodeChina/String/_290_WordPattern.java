package LeetCodeChina.String;

import java.util.HashMap;
import java.util.Map;

/**
 * word pattern
 */
public class _290_WordPattern {

    /**
     * word pattern
     *
     * hashmap
     *
     * 并且考虑利用 hashmap put 的一个特性
     *
     * pattern = "abba", str = "dog cat cat dog" should return true.
     *
     * 这种情况无法AC：
     *   String pattern ="abba";
        String str = "dog dog dog dog";
     * @param pattern
     * @param str
     * @return
     */
    public static boolean wordPattern_01(String pattern, String str) {
        if (pattern == null || str == null)
            return false;
        char[] patternCHar = pattern.toCharArray();
        String[] strChar = str.split(" "); //拆分为空格字符分割的String 数组

        HashMap<Character,Integer> map = new HashMap<>();

        for (int i=0;i<patternCHar.length;i++){
            if (!map.containsKey(patternCHar[i])){
                map.put(patternCHar[i],i);
            }
            else {
                int j = map.put(patternCHar[i],i); //返回为旧的 value值

                //比较在 pattern 中相等的字符串，是否在 str 中也相等
                //存在问题是：如果str 中的值全部相等，无法区分。
                if (!strChar[i].equals(strChar[j]))
                    return false;
            }
        }
        return true;
    }


    /**
     * leetcode 大佬的解法
     * @param pattern
     * @param str
     * @return
     */
    public static boolean wordPattern_02(String pattern, String str) {
        if (pattern == null || str == null)
            return false;
        String [] words = str.split(" ");
        if (pattern.length() != words.length)
            return false;

        //此处类似与Map<Object,Object>
        Map map = new HashMap();

        //此处的循环处必须要时Integer 才可以通过全部测试用例
        //因为在 map 中存储的是Integer ，此处并没有自动装箱，只能使用对象类型
        for (Integer i=0;i<words.length;i++){
//            Object key1 =map.put(pattern.charAt(i),i);
//            Object key2 = map.put(words[i],i);
            if (map.put(pattern.charAt(i),i)!= map.put(words[i],i))
                return false;
        }
        return true;
    }

        public static void main(String[] args) {
        String pattern ="cccc";
        String str = "c c c c";
        System.out.println(wordPattern_02(pattern,str));

    }
}
