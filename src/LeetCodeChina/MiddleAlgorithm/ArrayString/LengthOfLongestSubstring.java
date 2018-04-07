package LeetCodeChina.MiddleAlgorithm.ArrayString;

import java.util.HashMap;

/**
 * 无重复字符的最长子串
 *
 * 给定一个字符串，找出不含有重复字符的 最长子串 的长度。

 * 示例：

 * 给定 "abcabcbb" ，没有重复字符的最长子串是 "abc" ，那么长度就是3。

 * 给定 "bbbbb" ，最长的子串就是 "b" ，长度是1。

 * 给定 "pwwkew" ，最长子串是 "wke" ，长度是3。请注意答案必须是一个子串，"pwke" 是 子序列 而不是子串。
 */
public class LengthOfLongestSubstring {

    /**
     * "aab" 这种情况输出错误
     * 输出不正确
     *
     * 没有AC
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring_01(String s) {
        if (s == null)
            return 0;

        int maxLen = 0;

        int [] charArrays = new int[256];

        boolean noCopy = true;

        for (int i=0;i<s.length();i++){

            if (charArrays[s.charAt(i)] == 0){
                charArrays[s.charAt(i)] =1;
            }else { //如果表中已经有了，清零，并记录当前最大长度
                noCopy =false;
                int currentMax = getCharArraysLen(charArrays,s.substring(0,i));
                charArrays[s.charAt(i)] =1;
                String  str = s.substring(0,i);
                if (currentMax>maxLen)
                    maxLen = currentMax;
            }
        }
        return  noCopy? s.length():maxLen;
    }

    private int getCharArraysLen(int[] nums,String index){
        int count =0;
        for (int i=0;i<index.length();i++){
            if (nums[index.charAt(i)] ==1)
                count++;
            //统计1的个数，并将数组清零
            nums[index.charAt(i)] =0;
        }
        return count;
    }


    /**
     * 建立map存储字符和位置，一旦遇到重复的字符，就会跳回到第一次出现重复字符的下个字符开始重新计数。
     *
     * O(n)时间，但是使用hashmap的性能消耗大
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring_02(String s) {
        if (s == null || s.length()==0)
            return 0;

        HashMap<Character,Integer> map = new HashMap<>();

        int resultLength = 0;
        int currentLength = 0;

        for (int i=0;i<s.length();i++){
            if (map.containsKey(s.charAt(i))){
                i = map.get(s.charAt(i));//将 i 置位左指针重复的位置
                map.clear();//清除map中的所有元素
                currentLength=0;
                continue;   //继续执行for循环
            }
            currentLength++;
            map.put(s.charAt(i),i);
            resultLength = Math.max(resultLength,currentLength);

        }
        return resultLength;
    }


    /**
     * 利用字符串特性，改进哈希表性能
     *
     * "dvdf" 无法通过AC
     *
     * 没有错误，但是超出时间限制
     *
     * 将数组置零改为重新生成数组，不使用for循环
     *
     * 简化的 hashmap
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring_03(String s) {
        if (s == null || s.length()==0)
            return 0;

        int[] map = new int[256];

        int resultLength = 0;
        int currentLength = 0;

        for (int i=0;i<s.length();){
            //如果包含重复元素
            if (map[s.charAt(i)]>=1){
                i= map[s.charAt(i)]; //更新 i 的位置
                map = new int[256]; //清除数组中所有元素
                currentLength=0;    //当前最大长度置零
                continue;
            }
            currentLength++;
            map[s.charAt(i)]=i+1;   //此处将数组的索引值加一，便于判断是否出现过
            resultLength = Math.max(resultLength,currentLength);
            i++;    //此处执行i++;
        }
        return resultLength;
    }



    /**
     * 不太理解这个方法
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring_04(String s) {
        if (s == null || s.length() == 0) return 0;
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int res = 0;
        int len = 0;
        int start = 0;
        for(int i = 0; i < s.length(); i++){
            if(map.containsKey(s.charAt(i)) && map.get(s.charAt(i)) >= start){
                start = map.get(s.charAt(i)) + 1;
            }
            len = i - start + 1;
            map.put(s.charAt(i),i);
            res = Math.max(res,len);
        }
        return res;
    }


        public static void main(String[] args) {
        LengthOfLongestSubstring obj = new LengthOfLongestSubstring();
        System.out.println(obj.lengthOfLongestSubstring_03("dvdf"));
    }


}
