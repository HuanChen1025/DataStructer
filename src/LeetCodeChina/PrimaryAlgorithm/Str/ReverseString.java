package LeetCodeChina.PrimaryAlgorithm.Str;

/**
 * 请编写一个函数，其功能是将输入的字符串反转过来。
 * 输入：s = "hello"
 * 返回："olleh"
 */
public class ReverseString {
    public String reverseString_01(String s) {
        if (s == null)
            return null;
        int pHead = 0;
        int pEnd = s.length()-1;
        char[] str = s.toCharArray();

        while (pHead<pEnd){
            char temp = str[pHead];
            str[pHead] = str[pEnd];
            str[pEnd] = temp;
            pHead++;
            pEnd--;
        }
        return String.valueOf(str);
    }

    /**
     * 字符串反向遍历，采用 StringBuffer 保存遍历结果
     *
     * @param s
     * @return
     */
    public String reverseString_02(String s) {


        return null;
    }


        public static void main(String[] args) {
        ReverseString reverseString = new ReverseString();

        System.out.println( reverseString.reverseString_01("hello"));

    }
}
