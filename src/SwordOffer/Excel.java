package SwordOffer;

public class Excel {

    /**
     * 计算 EXCEL 的列号编码
     * @param x
     * @return
     */
    public static String printExcelCol(int x){
        if (x <= 0){
            System.out.println("输入错误");
            return "error";
        }
        StringBuffer stringBuffer = new StringBuffer();

        if (x >0 ){
            int temp1 = x/26;
            //求除法，计算有多少个A
            while (temp1 > 0){
                stringBuffer.append("A");
                temp1--;
            }
            int temp = x %26;
            //计算最后一位，
            if (temp !=0){
                int str = 'A'+temp;
                char str1 = (char)str;
                stringBuffer.append( String.valueOf(str1));
            }

        }
        return stringBuffer.toString();

    }

    public static void main(String[] args) {

        System.out.println(printExcelCol(-78));

    }
}
