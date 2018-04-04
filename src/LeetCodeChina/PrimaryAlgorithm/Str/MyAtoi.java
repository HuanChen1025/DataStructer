package LeetCodeChina.PrimaryAlgorithm.Str;

import javax.swing.table.TableRowSorter;

/**
 * 字符串转整数
 */
public class MyAtoi {

    /**
     * 1）考虑到大数
     * 2）输入为空
     * 3）正负数
     * 4）溢出
     * 5）是否是合法的字符串
     * 6)返回为空的0如何与真实的 0 区分
     * 7)输入只有正负号
     *
     * 太多特殊情况，考虑不全
     * @param str
     * @return
     */
    public int myAtoi_01(String str) {
        //输入校验，此处返回有待考虑
        if (str == null)
            return 0;

        if (str.length() == 1 && (str.charAt(0) =='-'|| str.charAt(0)=='+'))
            return 0;

        boolean  isNegetive = false;

        int symbolCount = 0;

        long result = 0;

        for (int i=0;i<str.length();){
            //此处考虑的是，如果是正号，前面是无符号的
            if (str.charAt(i)=='+'){
                i++;
                isNegetive = false;
                symbolCount++;
            }
            if (str.charAt(i)=='-'){
                isNegetive = true;
                i++;
                symbolCount++;
            }
            //如果有多个符号，返回 0
            if (symbolCount>1){
                return 0;
            }
            if (str.charAt(i)>='0'&& str.charAt(i)<='9'){
                result = result*10 + (str.charAt(i)-48);
                i++;
                //溢出后，考虑输出为0
                if (result>0x7FFFFFFF || result< 0x80000000)
                    return 0;
            }
            //输入为连续空白字符串
            else if (str.charAt(i)==' '){
                i++;
            }
            //输入无效字符，返回 0
            else {
                return isNegetive? -(int)result:(int)result;
            }
        }
        return isNegetive? -(int)result:(int)result;
    }

    public static void main(String[] args) {
        MyAtoi myAtoi = new MyAtoi();
        System.out.println(myAtoi.myAtoi_01("   +0 123"));

    }
}
