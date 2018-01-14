package lintCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MajorityNumber {
    /**
     * 这道题是自己写出来的哦，时间复杂度较低，空间复杂度没达标
     * @param nums: a list of integers
     * @return: find a  majority number
     */
    public static int majorityNumber(List<Integer> nums) {
        // write your code here
        //拟采用hashMap来做
        HashMap<Integer,Integer> results = new HashMap<>(); //采用<K,V>的形式计数每个k出现的次数
        List<Integer> numbers = new ArrayList<>();          //用于不重复k的结果结果
        for (int i=0;i<nums.size();i++){
            if (results.containsKey(nums.get(i))){
                //获取hashmap中指定值，而不是获取某个i的值.这样获取会越界results.get(i).intValue()
                //改为 int tempNum = results.get(nums.get(i)).intValue()+1; 后hashmap 表现正常
                int tempNum = results.get(nums.get(i)).intValue()+1;
                results.put(nums.get(i),tempNum);
            }
            else {
                results.put(nums.get(i),1);
                numbers.add(nums.get(i)); //保存不重复的key值
            }
        }
        //遍历HashMap的value值
        for (int i = 0;i < results.size();i++){
            //此处采用results.get(i).intValue() 中的索引i会超出results的界限，出现空指针异常
            //不是越界，而是get() 中的参数应该是hashmap 中的key值
            //如何才能获取到不重复的key值呢。采用nums.get(i)是不行的，他和hashmap的长度不一致
            if (results.get(numbers.get(i)).intValue() > nums.size()/2){
                return numbers.get(i);
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(1);
        list.add(1);
        list.add(1);
        list.add(1);
        list.add(2);
        list.add(2);
        list.add(3);
        System.out.println(majorityNumber(list));
    }
}
/**
 * 本题值得注意的地方：
 * hashmap 中get(i) 方法中i是key 的值，而不是类似与数组和List 中的下标值，这点值得注意
 *
 */
