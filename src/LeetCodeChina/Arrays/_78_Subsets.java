package LeetCodeChina.Arrays;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _78_Subsets {
    /**
     * Input: nums = [1,2,3]
     * 第一种方法，位元算，如果3个字符，用 000 中的1表示选中，0 表示未选中
     * https://blog.csdn.net/u012501459/article/details/46777141
     * @param nums
     * @return
     */
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();

        if (nums == null || nums.length == 0)
            return res;

        Arrays.sort(nums);
        int length = nums.length;
        int subsetLen = (int)Math.pow(2,length);

        //这里的处理逻辑不会写，由C++ 改为java ，始终写不对
        
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3};
        System.out.println(subsets(nums));

    }
}
