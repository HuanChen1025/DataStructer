package SwordOffer;

public class StrToInt {
    public static void main(String[] args) {
        //String string = null;
        System.out.println(StrToInt("-4444444444444"));

    }
    /**
     * 将一个字符串转换为整数
     * 测试用例：
     * 1）空字符串或者null
     * 2）只输入正负号
     * 3）输入非数字
     * 4）溢出
     * @param string
     * @return
     */
    public static int StrToInt(String string){
        //对空指针判断。必须考虑到用户的特殊输入,输入为空或者空白字符串
        if (string.length() == 0 && string == null){
            return 0;
        }
        //考虑用户只输入了符号，无数字
        if (string.length()==1 &&(string.charAt(0)=='+'||string.charAt(0)=='-'))
            return 0;
        long  number = 0;   //用于保存结果
        int isMinus = 1;    //正负数标志
        int length = string.length();
        for (int i =0; i < length ; i++){
            //前面为+号
            if (string.charAt(i) == '+')
                i++;
            //前面为-号
            if (string.charAt(i) == '-'){
                i++;
                isMinus = -1;
            }
            //判断输入的字符串是否为合法字符串
            if (string.charAt(i)>'0' && string.charAt(i)<'9'){
                number = number * 10 + isMinus *(string.charAt(i) - '0') ;
            }
            else {
                number = 0;
                break;
            }
            if (isMinus == -1 && number<0x80000000){
                System.out.println("下溢出");
                return 0;
            }

            if (isMinus == 1 && number>0x7FFFFFFF){
                System.out.println("上溢出");
                return 0;
            }
        }
        return (int)number;
    }
}
