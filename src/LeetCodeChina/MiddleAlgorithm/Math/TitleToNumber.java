package LeetCodeChina.MiddleAlgorithm.Math;

public class TitleToNumber {

    /**
     * 与 Excel表列名称 问题类似。

     * 给定一个Excel表格中的列名称，返回其相应的列序号。

     *
     * 将 A - Z 转化为 26进制
     *
     *   A -> 1
         B -> 2
         C -> 3
         ...
         Z -> 26
         AA -> 27
         AB -> 28
     * @param s
     * @return
     */
    public int titleToNumber(String s) {
        int len = s.length();

        int sum =0;

        for (int i=0;i<s.length();i++){
            if (s.charAt(i)>='A'&&s.charAt(i)<='Z'){
                sum  +=  (s.charAt(i)-'A'+1)*((int)Math.pow(26,len-i-1));
            }
            else {
                return 0;
            }
        }

        return sum;
    }

    public static void main(String[] args) {
        TitleToNumber titleToNumber = new TitleToNumber();
        System.out.println(titleToNumber.titleToNumber("AB2"));

    }
}
