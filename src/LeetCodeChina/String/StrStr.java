package LeetCodeChina.String;

/**
 * 28. 实现strStr()
 */
public class StrStr {
    /**
     * 采用双指针，其实也算暴力法的改版
     *
     * 失败
     * @param haystack
     * @param needle
     * @return
     */
    public int strStr(String haystack, String needle) {
        //如何考虑字符串为 null 的情况

        if (haystack == null || needle == null)
            return -1;

        if (needle.length() == 0)
            return 0;

        int hayIndex = 0;
        int needleIndex = 0;
        int res =0;


        while (hayIndex < haystack.length() && needleIndex<needle.length()){
            if (haystack.charAt(hayIndex) != needle.charAt(needleIndex)){
                hayIndex++;
                needleIndex =0;
                res=0;
            }
            else {
                res++;
                hayIndex++;
                needleIndex++;
            }
        }

        if (needleIndex == needle.length())
            return res-1;
        else
            return -1;
    }

    /**
     * 双指针，找到第一个匹配点，然后依次比较，返回的 j 的长度和 needle 的长度相等则说明找到
     * @param haystack
     * @param needle
     * @return
     */
    public int strStr_01(String haystack, String needle) {
        int m = haystack.length();
        int n = needle.length();
        //如果存在包含关系，最大的可能就是循环 m-n 次，haystack 中最后几个字符就是needle
        for (int i=0;i<=m-n;i++){
            int j;
            for (j=0;j<n;j++){
                if (haystack.toCharArray()[i+j] != needle.toCharArray()[j]){
                    break;
                }
            }
            if (j==n)
                return i;
        }
        return -1;
    }



    /**
     * 采用 substring 和 equals 方法
     * @param haystack
     * @param needle
     * @return
     */
    public int strStr_02(String haystack, String needle) {

        return -1;
    }
        public static void main(String[] args) {
        StrStr obj = new StrStr();
        //"mississippi"
        //"issipi"
        System.out.println(obj.strStr_01("mississippi","ississ"));

    }
}
