package SwordOffer;

import lintCode.Str;

public class LeftRotateString {

    public String leftRotateString(String str,int n) {
        //注意要考虑到字符串的长度小于输入翻转数字 n 的长度
        if (str == null || str == "" || str.length()<n){
            return "";
        }

        StringBuffer resultString = new StringBuffer();

        /**
         * public String substring(int beginIndex,int endIndex)
         * 返回一个新字符串，它是此字符串的一个子字符串。该子字符串从指定的 beginIndex 处开始，
         * 直到索引 endIndex - 1 处的字符。因此，该子字符串的长度为 endIndex-beginIndex。
         * beginIndex - 起始索引（包括）。
           endIndex - 结束索引（不包括）。
         */
       String firstString =  str.substring(0,n);
       String secondString = str.substring(n,str.length());

       //翻转前面的字符串
       resultString.append(reverseStr(firstString));

       //翻转后面的字符串
       resultString.append(reverseStr(secondString));

       //翻转整个字符串
       return  reverseStr(resultString.toString());
    }

    /**
     * 翻转字符串
     * 采用头指针和尾指针的方式翻转字符串，
     * 不仅效率高，还能节省辅助空间
     * @param str
     * @return
     */
    private String reverseStr(String str){

        char[] tempString = str.toCharArray();

        int pBegin = 0;
        int pEnd = str.length()-1;

        while (pBegin<pEnd){
            char temp = tempString[pEnd];
            tempString[pEnd] = tempString[pBegin];
            tempString[pBegin] = temp;
            pBegin++;pEnd--;
        }
        return String.valueOf(tempString);
    }

    public static void main(String[] args) {
        LeftRotateString leftRotateString = new LeftRotateString();

        System.out.println( leftRotateString.leftRotateString("abcdefg",2));
    }


}
