package LeetCodeChina.String;

import java.util.HashMap;
import java.util.Map;

public class _205_IsomorphicStrings
{

    /**
     * 需要保证 put 到 map 中的是两种不同的类型，如果是同一种类型，如果相同，会被后 put 的覆盖掉
     * @param s
     * @param t
     * @return
     */
    public static boolean isIsomorphic_01(String s, String t) {
        if (s == null || t == null)
            return false;
        if (s.length() != t.length())
            return false;

        //必须将输入比较的两个字符转换成不同的Object，再输入到 hashmap 中
        String [] str = new String[t.length()];
        for (int i=0;i<t.length();i++){
            str[i] =  String.valueOf(t.charAt(i));

        }
        Map map = new HashMap<>();

        for (Integer i=0;i<s.length();i++){
            if (map.put(s.charAt(i),i)!= map.put(str[i],i))
                return false;
        }
        return true;
    }

    /**
     * 其他方法
     * @param s
     * @param t
     * @return
     */
    public static boolean isIsomorphic_02(String s, String t) {


        return false;
    }

        public static void main(String[] args) {
        System.out.println(isIsomorphic_01("ab","aa"));

    }
}
