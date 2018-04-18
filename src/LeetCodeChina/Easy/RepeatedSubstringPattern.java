package LeetCodeChina.Easy;

/**
 * 459. 重复的子字符串
 *
 * 给定一个非空的字符串，判断它是否可以由它的一个子串重复多次构成。
 *
 * 给定的字符串只含有小写英文字母，并且长度不超过10000。
 */
public class RepeatedSubstringPattern {

    /**
     * 双指针
     *
     * 失败，针对  //"abaababaab" 这种情况无解
     *
     * @param s
     * @return
     */
    public boolean repeatedSubstringPattern(String s) {
        //校验输入
        if (s.length() <= 1 || s == null)
            return false;

        //将字符串转换为数组
        char[] chars = s.toCharArray();

        int pHead = 0;
        int pTail = 1;

        while (pTail < s.length()){
            if (chars[pHead] == chars[pTail])
                break;
            pTail++;
        }
        //pTail 的大小就是重复数组的长度

       // int repeatLen = pTail;

        //检查元素个数
        if (s.length()%pTail!=0){
            return false;
        }

        for (int i=0;i<s.length() && pTail<s.length();i++,pTail++){
            if (chars[i]!= chars[pTail])
                return false;
        }
        return true;
    }

    /**
     * 采用二分查找
     * @param s
     * @return
     */
    public boolean repeatedSubstringPattern_01(String s) {
        //校验输入
        if (s.length() <= 1 || s == null)
            return false;
        int len = s.length();
        for(int i=1;i<=len/2;i++) {//最大长度
            if(len%i == 0) {
                String tem = s.substring(0, i);//子串
                StringBuffer sb = new StringBuffer();
                for(int j=0;j<len/i;j++) {
                    sb = sb.append(tem);//生成相同长度
                }
                if(sb.toString().equals(s))//验证
                    return true;
            }
        }
        return false;
    }




    public static void main(String[] args) {

        RepeatedSubstringPattern repeatedSubstringPattern = new RepeatedSubstringPattern();
        System.out.println(repeatedSubstringPattern.repeatedSubstringPattern_01("abaababaab"));
    }
}
