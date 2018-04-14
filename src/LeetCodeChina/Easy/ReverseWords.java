package LeetCodeChina.Easy;

/**
 * 557. 反转字符串中的单词 III
 *
 * 给定一个字符串，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。
 *
 * 输入: "Let's take LeetCode contest"
 * 输出: "s'teL ekat edoCteeL tsetnoc"
 */
public class ReverseWords {

    public String reverseWords(String s) {
        if (s.length() == 0 ||s == null)
            return "";

        String[] str = s.split(" ");

        StringBuffer res = new StringBuffer("");

        for (int i=0;i<str.length;i++){
            if (i<str.length-1)
                res.append(reverseString(str[i])).append(" ");
            else
                res.append(reverseString(str[i]));
        }

        return res.toString();
    }

    /**
     * 翻转 str 数组中的第 i 个字符串
     * @param str
     */
    private String reverseString(String str){

        int start = 0;
        int end = str.length()-1;
        char[] characters = str.toCharArray();

        while (start<end){
            char temp = characters[start];
            characters[start] = characters[end];
            characters[end] = temp;
            start++;
            end--;
        }

    return  String.valueOf(characters);
    }

    public static void main(String[] args) {
        String s = "Let's";
        ReverseWords reverseWords = new ReverseWords();
        System.out.println(reverseWords.reverseWords(s));
    }
}
