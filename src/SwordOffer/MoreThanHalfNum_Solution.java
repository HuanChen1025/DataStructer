package SwordOffer;

import java.util.HashMap;

/**
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 * 一定会有一个数字出现次数超过数组长度一般，所以将数组长度为 1 的情况直接返回。
 */
public class MoreThanHalfNum_Solution {

    /**
     * 采用 HashMap 实现,以空间换时间，实现 O(n) 算法
     * @param array
     * @return
     */
    public int MoreThanHalfNum_Solution(int [] array) {
        if (array == null || array.length == 0){
            return 0;
        }
        if (array.length == 1){
            return array[0];
        }
        HashMap<Integer,Integer> res = new HashMap<>();
        for (int i=0;i<array.length;i++){
            if (! res.containsKey(array[i])){
                res.put(array[i],1);
            }else {
                int value =  res.get(array[i])+1;
                if (value>array.length/2){
                    return array[i];
                }
                res.put(array[i],value);
            }
        }
        return 0;
    }

    /**
     * 采用数组计数的方式实现
     * @param array
     * @return
     */
    public int MoreThanHalfNum_Solution_01(int [] array) {
        if (array.length == 0 || array == null)
            return 0;
        int times = 1;
        int result = array[0];
        for (int i =1;i<array.length;i++){
            if (times == 0){
                result = array[i];
                times = 1;
            }else if (result == array[i]){
                times++;
            }else
                times--;
        }
        if (!checkMoreThanHalf(array,result))
            return 0;
        return result;
    }

    /**
     * 检查是否输出的结果没有达到超过数组一般的要求，如果没有达到，返回 false，最终输出 0
     * @param array
     * @param result
     * @return
     */
    private boolean checkMoreThanHalf(int[] array,int result){
        int times = 0;
        for (int i=0;i<array.length;i++){
            if (array[i] == result){
                times++;
            }
            }
            boolean isMoreThanHalf = true;
            if (times*2 <= array.length)
                isMoreThanHalf = false;
        return isMoreThanHalf;

    }


    public static void main(String[] args) {
        MoreThanHalfNum_Solution test = new MoreThanHalfNum_Solution();
        int [] array = {2};
        System.out.println(test.MoreThanHalfNum_Solution(array));
    }
}
