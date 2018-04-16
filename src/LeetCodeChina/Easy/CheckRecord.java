package LeetCodeChina.Easy;

import com.sun.org.apache.xpath.internal.operations.Lte;

/**
 * 551. 学生出勤纪录 I
 */
public class CheckRecord {

    /**
     * 如果一个学生的出勤纪录中不超过一个'A'(缺勤)并且不超过两个连续的'L'(迟到),
     * 那么这个学生会被奖赏。
     * @param s
     * @return
     */
    public boolean checkRecord_01(String s) {
        if (s.length() == 0 || s==null)
            return true;

        char[] chars =s.toCharArray();
        int  Anum = 0;
        int  Lnum = 0;

        for (int i=0;i<chars.length;){
            if (chars[i] == 'A'){
                Anum++;
                Lnum=0;
                i++;
            }
            //迟到的次数，如何保证验证连续的 L 呢
            else if (chars[i] == 'L'){
                Lnum++;
                i++;
            }
            else{
                i++;
                Lnum =0;
            }
            if (Lnum>2 || Anum>1){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        CheckRecord checkRecord = new CheckRecord();
        System.out.println(checkRecord.checkRecord_01("LLALL"));

    }
}
