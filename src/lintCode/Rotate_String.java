package lintCode;

public class Rotate_String {
    /**
     * @param str: An array of char
     * @param offset: An integer
     * @return: nothing
     */
    public static void rotateString(char[] str, int offset) {
        // write your code here
        if (str == null || str.length ==0) {
            return ;
        }
         offset = offset % str.length; //这一步相当关键，避免减少不必要的翻转
        for (int i = 0;i<offset;i++){
            char temp = str[str.length-1];
            for (int j =str.length-1; j>0;j--){
                str[j]=str[j-1];
            }
            str[0] = temp;
        }

    }

    public static void main(String[] args) {
        char[] str ={'a','b','c','d'};
       // System.out.println(rotateString(str,2));
    }
}
