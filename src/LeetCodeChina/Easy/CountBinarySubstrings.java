package LeetCodeChina.Easy;

/**
 *
 * 696. 计数二进制子串
 */
public class CountBinarySubstrings {

    public int countBinarySubstrings(String s) {
        int prevRunLen = 0;
        int curRunLen = 1;
        int res = 0;

        char[] str = s.toCharArray();

        for (int i=1;i<s.length();i++){
            if (str[i] == str[i-1]){
                curRunLen++;
            }
            else {
                prevRunLen = curRunLen;
                curRunLen =1;
            }
            if (prevRunLen>=curRunLen)
                res++;
        }
        return res;
    }

    public static void main(String[] args) {
        CountBinarySubstrings obj = new CountBinarySubstrings();
        System.out.println(obj.countBinarySubstrings("00110011"));
    }
}
