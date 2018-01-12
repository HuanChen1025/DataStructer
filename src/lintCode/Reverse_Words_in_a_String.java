package lintCode;

public class Reverse_Words_in_a_String {
    /**
     * Given an input string,
     * reverse the string word by word.
     * For example,
     * Given s = "the sky is blue",
     * return "blue is sky the".
     *
     * 采用String 的split() 方法将字符串分割是字符数组，再逆序遍历
     * @param s: A string
     * @return: A string
     */
    public String reverseWords(String s) {
        // write your code here
        String [] aa = s.split("\\ ");
        String result ="";
        for (int i =aa.length-1;i>=0;i--){
        result += aa[i] +" ";
        }
        return result;
    }

    public static void main(String[] args) {
        Reverse_Words_in_a_String reverse_words_in_a_string = new Reverse_Words_in_a_String();
        String result = reverse_words_in_a_string.reverseWords("the sky is blue");
        System.out.println(result);

    }
}
