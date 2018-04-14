package LeetCodeChina.Middle;

/**
 * 392. 判断子序列
 *
 * 给定字符串 s 和 t ，判断 s 是否为 t 的子序列。
 *
 * 示例 1:
 * s = "abc", t = "ahbgdc"
 *
 * t 字符串有重复，二分查找会出现问题

 * 返回 true.
 */
public class IsSubsequence {

    /**
     * 双指针
     *
     * 不是最优的方法，可以AC
     *
     * 为何为贪心：
     * 【问题分解+无后效性】分解的子问题之间应该具有一定的独立性（无后效性），
     * 两个指针标识的位置意味着将问题分解成了新的源串和目标串，
     * 后面的子问题中不需要考虑之前的子问题的内容，即后面的子问题不需看到之前的问题。
     * @param s
     * @param t
     * @return
     */
    public boolean isSubsequence_01(String s, String t) {
        if (s == null && t == null)
            return true;

        if (t.length() == 0 && s.length() != 0)
            return false;

        if (s.length() == 0 )
            return true;

        int sIndex = s.length();
        int tIndex = t.length();

        for (int i=0,j=0;i<sIndex && j<tIndex;){
            if (s.charAt(i) == t.charAt(j)){
                i++;
                j++;
            }
            else {
                j++;
            }

            if (i == sIndex)
                return true;
        }
        return false;
    }


    public static void main(String[] args) {
        IsSubsequence isSubsequence = new IsSubsequence();
        System.out.println(isSubsequence.isSubsequence_01("","hbgdc"));
    }
}
