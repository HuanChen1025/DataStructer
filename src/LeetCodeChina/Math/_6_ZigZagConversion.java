package LeetCodeChina.Math;

public class _6_ZigZagConversion {
    public static String convert(String s, int numRows) {
        if (numRows <=0)
            return "";
        if (s == null || s.equals(""))
            return s;
        if (numRows == 1 || numRows>=s.length())
            return s;
        StringBuffer sb = new StringBuffer();
        for (int i=0;i<numRows;i++){
            //首行
            if (i==0){
                for (int j=0;j<s.length();){
                    sb.append(s.charAt(j));
                    //下一个索引,如何找出下一个索引位置
                    j = j+ 2*numRows-2;
                }
            }
            //中间行
            if (i>0 && i<numRows-1){
                int start =i;
                sb.append(s.charAt(start));
                //难点在于如何判断列的奇偶
                for (int j=1;start<s.length();j++){
                    //中间行
                    if (j%2 == 1){
                        //在字符串中位置为奇数时
                        start = start +2 *(numRows-i-1);
                    }
                    else {
                        //偶数
                        start = start +2*i;
                    }
                   if (start<s.length()){
                       sb.append(s.charAt(start));
                   }
                }
            }
            //尾行
            if (i==numRows-1){
                for (int j= numRows-1;j<s.length();){
                    sb.append(s.charAt(j));
                    j = j+2*numRows-2;
                }
            }
        }
        return sb.toString();
    }

    public static String convert1(String s, int nRows) {
        if (nRows <=0)
            return "";
        if (nRows == 1 || nRows>=s.length())
            return s;

        StringBuffer sb = new StringBuffer();

        int len = s.length();

        for (int i=0;i<len && i<nRows ;++i){
            int start = i;
            sb.append(s.charAt(start)); //每一行的开始位置
            //遍历每一行，找出每行的字符
            for (int j=1;start<len;++j){
                //第一行和最后一行
                if (i == 0 || i==nRows -1){
                    start = start + 2*nRows -2;
                }
                else {
                  //中间行
                    if (j%2 == 1){
                        //在字符串中位置为奇数时
                        start = start +2 *(nRows-i-1);
                    }
                    else {
                        //偶数
                        start = start +2*i;
                    }
                }
                //边界判断
                if (start<len)
                    sb.append(s.charAt(start)); //每行的后序元素
            }
        }
        return sb.toString();

    }














        public static void main(String[] args) {
        String str = "ABCDEFGHIJKLM";
        System.out.println(convert(str,5));
    }
}
