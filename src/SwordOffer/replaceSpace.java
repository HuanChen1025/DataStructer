package SwordOffer;

public class replaceSpace {
    /**
     * 请实现一个函数，将一个字符串中的空格替换成“%20”。
     * 例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
     * @param str
     * @return
     */
    public static String replaceSpace(StringBuffer str) {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i=0;i<str.length();i++){
            if (str.charAt(i) == ' '){
                stringBuffer.append("%20");
            }
            else {
                stringBuffer.append(str.charAt(i));
            }
        }
        return stringBuffer.toString();
    }

    /**
     * 在原字符串上进行替换，不采用额外的存储空间
     * 采用从后向前的扫描方式
     * @param str
     * @return
     */
    public static String replaceSpace_01(char[]  str){
        int totalLength = 0;    //替换后字符串总长度
        int strLength = str.length;   //原字符串长度
        //计算出替换完毕之后的字符串总的长度
        for (int i =0;i<str.length;i++){
            if (str[i]==' '){
                totalLength +=3;
            }else {
                totalLength +=1;
            }
        }
        char [] newStr = new char[totalLength];
        System.out.println(totalLength);
        System.out.println(strLength);
        for (int i=strLength-1,j=totalLength-1;i < j;){
            //指针越界，因为str 的长度是固定的，

            if (str[i]==' '){
                //在末尾添加%20
                newStr[j--] = '0';
                newStr[j--] = '2';
                newStr[j--] = '%';
            }
            else {
                //依次将字符串中的单个字符往后面移动
                newStr[j] = str[i];
                j--;
                i--;
            }

        }
        return str.toString();
    }

    public static void main(String[] args) {
        StringBuffer stringBuffer = new StringBuffer("there is an");
        char[] str = {'1',' ','d'};
       System.out.println(replaceSpace_01(str));


    }
}
