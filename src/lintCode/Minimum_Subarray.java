package lintCode;

import java.util.List;

public class Minimum_Subarray {
    /**
     * @param nums: a list of integers
     * @return: A integer indicate the sum of minimum subarray
     * Given an array of integers, find the subarray with smallest sum.
       Return the sum of the subarray.
       For [1, -1, -2, 1], return -3.
     */
    public int minSubArray(List<Integer> nums) {
        // write your code here
        int min_ending_here = nums.get(0);  //获取最小子数组的结束位置
        int min_so_far = nums.get(0); //当前的值

        for (int i=1;i<nums.size();i++){
            min_ending_here = Math.min(nums.get(i),nums.get(i)+min_ending_here); //比较
            min_so_far = Math.min(min_so_far,min_ending_here);      //比较
        }
        //不理解 for 循环中的内容
        return min_so_far;
    }
}
