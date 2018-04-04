package LeetCodeChina.PrimaryAlgorithm.Str;

public class IsAnagram {

    /**
     * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的一个字母异位词。
     * 例如，
     *  s = "anagram"，t = "nagaram"，返回 true
     *  s = "rat"，t = "car"，返回 false
     *
     *  尽可能的减少时间和空间复杂度
     *  空间、时间复杂度均为O(N)
     * @param s
     * @param t
     * @return
     */
    public boolean isAnagram_01(String s, String t) {

        if (s == null || t == null)
            return false;

        //使用一个长度为 256 的哈希表
        int [] firstStrMap  = new int[256];
        int [] secondStrMap = new int[256];

        for (int i=0;i<s.length();i++)
            firstStrMap[s.charAt(i)] +=1;

        for (int i=0;i<t.length();i++){
            secondStrMap[t.charAt(i)] +=1;
        }

        for (int i=0;i<firstStrMap.length;i++){
            if (firstStrMap[i]!=secondStrMap[i])
                return false;
        }
        return true;
    }

    /**
     * 更快的算法在于创建一个一个 26 位的数组，减少空间开销和指令操作
     * @param s
     * @param t
     * @return
     */
    public boolean isAnagram_02(String s, String t) {

        return false;
    }

    public static void main(String[] args) {
        //s = "anagram"，t = "nagaram"
        String s = "anagram";
        String t = "nagamam";

        IsAnagram isAnagram = new IsAnagram();

        System.out.println(isAnagram.isAnagram_01(s,t));

    }
}
