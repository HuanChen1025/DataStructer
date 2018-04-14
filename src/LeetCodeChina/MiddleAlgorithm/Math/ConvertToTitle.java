package LeetCodeChina.MiddleAlgorithm.Math;

/**
 * 168. Excel Sheet Column Title
 *
 * Given a positive integer, return its corresponding column title as appear in an Excel sheet.

 * For example:
 *
 *   1 -> A
     2 -> B
     3 -> C
     ...
     26 -> Z
     27 -> AA
     28 -> AB
 */
public class ConvertToTitle {

    /**
     * 26进制转换
     *
     * 被打扰，需要重写写
     * @param n
     * @return
     */
    public String convertToTitle(int n) {
        String answer="";
        //分为 temp 为 0 或者不为 0 两种情况
        while( n > 0){
            int temp= n % 26;
            if(temp==0){
                answer="Z" + answer;
                n=n/26-1;
            }else{
                answer=new String(Character.toChars('A'+temp-1)) + answer;
                n/=26;
            }
        }
        return answer;
    }


    public static void main(String[] args) {
        ConvertToTitle convertToTitle = new ConvertToTitle();
        System.out.println(convertToTitle.convertToTitle(27));


    }
}
