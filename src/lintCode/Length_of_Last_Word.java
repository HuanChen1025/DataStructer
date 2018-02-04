package lintCode;

public class Length_of_Last_Word {

    /**
     * @param s: A string
     * @return: the length of last word
     */
    public static int lengthOfLastWord(String s) {
        // write your code here
        if (s == null || s ==" "){
            return -1;
        }
        String[] d = s.split(" ");
        return d[d.length-1].length();
    }

    public static void main(String[] args) {
        String str ="Hello World";
        System.out.println( lengthOfLastWord(str));
    }
}
