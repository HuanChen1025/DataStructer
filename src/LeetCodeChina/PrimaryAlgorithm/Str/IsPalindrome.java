package LeetCodeChina.PrimaryAlgorithm.Str;

/**
 * 验证回文字符串
 *
 * 给定一个字符串，确定它是否是回文，只考虑字母数字字符和忽略大小写。
 *
 *
 */
public class IsPalindrome {

    /**
     * 该算法时间复杂度稍高,因为在 while 循环里面有了两个for 循环，
     * 尝试替换掉这两个for循环
     * @param s
     * @return
     */
    public boolean isPalindrome_01(String s) {
        //校验输入
        if (s == null )
            return false;

        //将大写字母全部转为小写字母
        s = s.toLowerCase();

        int pHead = 0;
        int pEnd = s.length()-1;

        while (pHead<pEnd){
            for (int i=pHead;pHead<pEnd;) {
                //验证起始字符串是否合格
                if (!validation(s.charAt(pHead))) {
                    pHead++;
                }else {
                    break;
                }
            }

            for (int j=pEnd;pHead<pEnd;){
                if (!validation(s.charAt(pEnd))){
                    pEnd--;
                }else {
                    break;
                }
             }

             //得到两个正常的不为符号的数字
            if (s.charAt(pHead) != s.charAt(pEnd))
                return false;
            pHead++;
            pEnd--;
        }
        return true;
    }

    /**
     * 更快的算法
     * @param s
     * @return
     */
    public boolean isPalindrome_02(String s) {
        //校验输入
        if (s == null )
            return false;

        //将大写字母全部转为小写字母
        s = s.toLowerCase();

        int pHead = 0;
        int pEnd = s.length()-1;

        while (pHead < pEnd){
            if (validation(s.charAt(pHead))&&validation(s.charAt(pEnd))){
                //同时判断，避免采用for循环，节省时间
                if (s.charAt(pHead) == s.charAt(pEnd)){
                    pHead++;
                    pEnd--;
                }else {
                    return false;
                }
            }
            else if (!validation(s.charAt(pHead))){
                pHead++;
            }
            else if (!validation(s.charAt(pEnd))){
                pEnd--;
            }
        }
        return true;
    }


    private boolean validation(char str){
       // if (((s.charAt(pHead) >= 'a' && s.charAt(pHead) <= 'z') || (s.charAt(pHead) >= '0' && s.charAt(pHead) <= '9')))

        if ((str>='a' && str<='z') || (str>='0' && str<='9')){
            return true;

        }
        return false;
    }

    public static void main(String[] args) {
        IsPalindrome isPalindrome = new IsPalindrome();
        String s ="race a car";
        System.out.println(isPalindrome.isPalindrome_02(s));
    }
}
