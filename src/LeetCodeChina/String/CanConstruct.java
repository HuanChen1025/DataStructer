package LeetCodeChina.String;

/**
 * 383. 赎金信
 */
public class CanConstruct {

    /**
     * 自建 哈希表
     *
     * 不只是由 magazine 中的字母组成，还应该考虑到个数
     * @param ransomNote
     * @param magazine
     * @return
     */
    public boolean canConstruct(String ransomNote, String magazine) {
        //校验输入

        //全部由小写字母组成，自建哈希表

        int[] map1 = new int[26];   //存储 magazine 字符出现频次
        int[] map2 = new int[26];   //存储 ransomNote 字符出现频次

        for(int i=0;i<magazine.length();i++){
            map1[magazine.charAt(i)-'a'] +=1;
        }

        for (int i=0;i<ransomNote.length();i++){
            map2[ransomNote.charAt(i)-'a'] +=1;
        }

        for (int i=0;i<map1.length;i++){
            if (map1[i]<map2[i])
                return false;
        }

        return true;
    }

    /**
     * 采用一个哈希表，其中一个加，一个减，出现负数则说明无法组成
     * @param ransomNote
     * @param magazine
     * @return
     */
    public boolean canConstruct_01(String ransomNote, String magazine) {
        //自建哈希表
        int[] map = new int[26];   //存储 magazine 字符出现频次

        for (char c:magazine.toCharArray()
             ) {
            map[c-'a'] +=1;
        }

        for (char c:ransomNote.toCharArray()
             ) {
            map[c-'a'] -=1;
            //如果小于 0，两种情况：1）小于magazine该字符的数量，2)在magazine没有这个字符
            if (map[c-'a']<0)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        CanConstruct obj = new CanConstruct();
        System.out.println(obj.canConstruct_01("aa","ab"));
    }
}
