package LeetCodeChina.Easy;

/**
 * 541. 反转字符串 II
 * 给定一个字符串和一个整数 k，你需要对从字符串开头算起的每个 2k 个字符的前k个字符进行反转。
 * 如果剩余少于 k 个字符，则将剩余的所有全部反转。如果有小于 2k 但大于或等于 k 个字符，
 * 则反转前 k 个字符，并将剩余的字符保持原样。
 */
public class ReverseStr {

    public String reverseStr(String s, int k) {
        //校验输入
        if (s == null || s.length() == 0)
            return null;

        if (k<=0){
            return s;
        }

        int strLen = s.length();

        char[] chars = s.toCharArray();

        //剩余元素个数
        int remainder = strLen%(2*k);

        //循环的次数
        int times = strLen/(2*k);

        //翻转 times 次
        int start = 0;
        int end =k-1;
        while (times>0){
            reverse(chars,start,end);
            times--;
                start +=2*k;
                end +=2*k;
        }

        if (remainder>=k){
            reverse(chars,start,start+k-1);
        }
        else {
            reverse(chars,start,strLen-1);
        }

        return  String.valueOf(chars);
    }

    /**
     * 反转 char 数组中的元素
     * @param chars
     * @param start
     * @param end
     */
    private void reverse(char[] chars ,int start,int end){
        if (chars.length == 0 || chars == null)
            return;
        while (start < end){
            char temp = chars[end];
            chars[end] = chars[start];
            chars[start] = temp;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        ReverseStr reverseStr = new ReverseStr();
        System.out.println(reverseStr.reverseStr("accc",2));
    }
}
