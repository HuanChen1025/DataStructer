package LeetCodeChina.PrimaryAlgorithm.Str;

public class StrStr {

    /**
     *   实现strStr()
     *
     * 返回蕴含在 haystack 中的 needle 的第一个字符的索引，
     * 如果 needle 不是 haystack 的一部分则返回 -1 。
     *
     * 输入: haystack = "hello", needle = "ll"
     * 输出: 2
     *
     * 逻辑失败，通不过太多的特例，实在修改不下去了
     * @param haystack
     * @param needle
     * @return
     */
    public int strStr(String haystack, String needle) {
        //校验输入
        if (haystack == null || needle == null || haystack.length()<needle.length())
            return -1;
        if (haystack.length() ==0 || needle.length() ==0)
            return 0;

        boolean isContains = false;

        int i=0,j=0;
        while (i<haystack.length()){
            while (j<needle.length()){
                if (i>=haystack.length())
                    return -1;
                if (j>=needle.length())
                    break;

                if (haystack.charAt(i) != needle.charAt(j)){
                    isContains = false;
                    i++;
                    break;
                }else {
                    isContains = true;
                    i++;
                    j++;
                }
            }
            if (j>=needle.length())
                break;
        }
        return isContains ? (i-j):-1;
    }

    public static void main(String[] args) {
        StrStr strStr = new StrStr();
        //"mississippi"
        //"issipi"
        System.out.println(strStr.strStr("mississippi","issipi"));


    }
}
