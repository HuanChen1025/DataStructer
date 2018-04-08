package LeetCodeChina.MiddleAlgorithm.Backtracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * 电话号码的字母组合
 *
 * 给定一个数字字符串，返回数字所有可能表示的字母组合。

 * 下面给出数字到字母的映射（和电话号码一样）。
 *
 * 输入：数字字符串 "23"
 *
 * 输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 */
public class LetterCombinations {

    /**
     * 问题1：输入数字 1 如何处理：只要有1 出现，返回空；同理，0 也是这样处理
     *
     * 放弃，时间复杂度太高，都要到O（N3)了
     * @param digits
     * @return
     */
    public List<String> letterCombinations_01(String digits) {
        //校验输入
        if (digits == null)
            return new ArrayList<>();

        int length = digits.length();

        for (int i=0;i<length;i++){
            //如果数字不在 2—9 这个范围内，返回为空
            if (digits.charAt(i)<='1' || digits.charAt(i)>'9')
                return new ArrayList<>();
        }
        HashMap<Integer,String> map = new HashMap<>();
        map.put(2,"abc");
        map.put(3,"def");
        map.put(4,"ghi");
        map.put(5,"jkl");
        map.put(6,"mno");
        map.put(7,"pqrs");
        map.put(8,"tuv");
        map.put(9,"wxyz");

        String str = map.get(Integer.valueOf(digits.charAt(0)));

        List<String> result = new ArrayList<>();

        //添加第一个
        for (int i=0;i<str.length();i++){
            result.add(String.valueOf(str.charAt(i)));
        }
        //从第二个数字开始添加
        for (int i=1;i<length;i++){
            String string = map.get(Integer.valueOf(digits.charAt(i)));

           for (int j=0;j<result.size();j++){
              // result.get(i)
           }
        }
        return null;
    }

    /**
     *
     * @param digits
     * @return
     */
    public List<String> letterCombinations_02(String digits) {
        //校验输入
        if (digits == null || digits.length() == 0)
            return new ArrayList<>();

        int length = digits.length();

        //如果数字不在 2—9 这个范围内，返回为空
        for (int i=0;i<length;i++){
            if (digits.charAt(i)<='1' || digits.charAt(i)>'9')
                return new ArrayList<>();
        }

        HashMap<Character,String> map = new HashMap<>();
        map.put('2',"abc");
        map.put('3',"def");
        map.put('4',"ghi");
        map.put('5',"jkl");
        map.put('6',"mno");
        map.put('7',"pqrs");
        map.put('8',"tuv");
        map.put('9',"wxyz");

        //此处这个队列采用 LinkedList 是最优的
        LinkedList<String> queue = new LinkedList<>();
        List<String> result = new ArrayList<>();
        queue.add("");  //先往 queue 中添加一个元素，保证 digit 中第一个元素的添加

        for (int i=0;i<length;i++){

            int size = queue.size();

            //获取数字对应的字母
            String str = map.get(digits.charAt(i));

            //这里采用的是获取的 queue 的 size，而不是实时的 queue szie ，
            // 所以在循环中queue中元素的添加不会影响到这里条件判断
            for (;size>0;size--){
                String s = queue.pollFirst();//移除队列的头元素
                for (int j=0;j<str.length();j++){
                    String temp =s + str.charAt(j);
                    queue.offer(temp);
                }
            }
        }

        result.addAll(queue);

        return result;
    }

    public static void main(String[] args) {

        LetterCombinations letterCombinations = new LetterCombinations();

        System.out.println(letterCombinations.letterCombinations_02("23"));

    }
}
