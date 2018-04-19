package LeetCodeChina.Easy;

import lintCode.Str;

import java.util.*;

/**
 * 819. Most Common Word
 * 返回不在 banned 中，出现次数最多的字符。
 *
 * 对于只有一个字符串的不能AC，比如："bob"
 */
public class MostCommonWord {
    public String mostCommonWord(String paragraph, String[] banned) {


        //全部转化为小写字符
        paragraph = paragraph.toLowerCase();

        char[] chars = paragraph.toCharArray();

        //正则表达式切分：检测出只要字符，不要空格和标点符号

        HashMap<String,Integer> map = new HashMap<>();

        StringBuilder sb = new StringBuilder();

        for (int i=0;i<chars.length;i++){

            //如果不为空，不为',',不为'.',
            if (chars[i]!=' ' && chars[i] != ',' && chars[i] != '.'){
                sb.append(chars[i]);
            }
            else {

                if (sb.length()>0){
                    if (map.containsKey(sb.toString())){
                        map.put(sb.toString(),map.get(sb.toString())+1);
                        sb = new StringBuilder();
                    }
                    else {
                        map.put(sb.toString(),1);
                        sb = new StringBuilder();
                    }
                }
                else {
                    sb = new StringBuilder();
                }
            }
        }

        //根据 map 的结果，将数值区分开
        System.out.println();

        //去除map 中在 banned 中的字符

        for (String str :
                banned) {
            if (map.containsKey(str)) {
                map.remove(str);
            }
        }


        int value =0;
        String res ="";
        for (String str :
                map.keySet()) {
            if (map.get(str)>value){
                value = map.get(str);
                res = str;
            }
        }

        return res;
    }

    /**
     * 使用正则表达式
     * @param paragraph
     * @param banned
     * @return
     */
    public String mostCommonWord_01(String paragraph, String[] banned) {
        //将 banned 数组转换为 Set
        Set<String> ban = new HashSet<>(Arrays.asList(banned));

        Map<String,Integer> count = new HashMap<>();

        // \\pP去除标点符号
        String[] words = paragraph.replaceAll("\\pP","").toLowerCase().split(" ");

        String res = "";

        int max = 0;

        for (String str : words){
            if (!ban.contains(str)){
                count.put(str,count.getOrDefault(str,0)+1);
                if (count.get(str)>max){
                    res = str;
                    max = count.get(str);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        MostCommonWord mostCommonWord = new MostCommonWord();
        String str = "Bob";
        String[] banner = {""};
        System.out.println(mostCommonWord.mostCommonWord_01(str,banner));
    }
}
