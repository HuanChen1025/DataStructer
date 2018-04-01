package SwordOffer;

/**
 * 输入一个英文句子，
 * 翻转句子中单词的顺序
 * 但单词内字符的顺序不变
 * 考虑只有一个单词的情况，就是说没有空格字符
 * 又臭又长，还不能完全 AC
 */
public class ReverseSentence {

    public static String ReverseSentence(String str) {
        //输入不规范，返回为空字符串
        if (str == null || str.length() == 0){
            return "";
        }

        char[] str2char = str.toCharArray();

        //首先将整个数组翻转
        reverseOneWord(str2char,0,str.length()-1);

        int pBegin = 0;
        int pEnd = 0;
        boolean isOneWord = true;

        while (pEnd<=str.length()-1){

            if (pBegin ==  ' ' && pEnd==' '){
                pBegin++;
                pEnd++;
            }
            //如果没有找到空格,尾指针都加 1
            else if (str2char[pEnd] == ' ' || pEnd==str2char.length-1){
                //翻转该单词
                reverseOneWord(str2char,pBegin,--pEnd);
                pBegin = ++pEnd;//头指针和尾指针均跳过空格，指向下一个单词
                pBegin = ++pEnd;
                isOneWord = false;

            }else {
                pEnd++;
            }
        }
        if (isOneWord == true){
            reverseOneWord(str2char,0,str.length()-1);
        }
        return  String.valueOf(str2char);
    }

    /**
     * 翻转一个指定长度的 char[] 数组
     * @return
     */
    private static void reverseOneWord(char[] chars,int begin,int end){
        while (begin<end){
            char temp = chars[begin];
            chars[begin] = chars[end];
            chars[end] = temp;
            begin++;
            end--;
        }
    }


    /**
     * 来自牛客的答案
     * 首先去掉头部和尾部的空白字符串
     * 创建一个 StringBuffer 用于保存结果
     * @param str
     * @return
     */
    public static String ReverseSentence_01(String str) {
        // trim() 方法返回字符串的副本，忽略前导空白和尾部空白
        String trim = str.trim();
        //采用StringBuffer拼接字符串，会减少对象的创建
        StringBuffer  a = new StringBuffer("");
        if("".equals(str.trim())){
            return str;
        }
        String[] split = str.split(" ");
        //从后往前遍历
        for (int i = split.length-1; i >=0; i--) {
            a.append(split[i]).append(" ");
        }
        return a.toString().trim();
    }

    public static void main(String[] args) {
        String str = "World! Hello";

        ReverseSentence_01(str);

    }
}
