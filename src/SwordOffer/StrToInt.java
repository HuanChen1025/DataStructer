package SwordOffer;

public class StrToInt {
    public static void main(String[] args) {
        //String string = null;
        System.out.println(StrToInt(""));

    }
    /**
     * 将一个字符串转换为整数
     * @param string
     * @return
     */
    public static int StrToInt(String string){
        //对空指针判断。必须考虑到用户的特殊输入
        if (string.length() == 0 && string == null){
            return -1;
        }
        int number = 0;
        int length = string.length();
        for (int i =0; i < length ; i++){
            number = number * 10 + string.charAt(i) - '0';
        }
        return number;
    }
}
