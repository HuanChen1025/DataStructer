package LeetCodeChina.Arrays;

import java.lang.reflect.Array;
import java.util.Arrays;

public class _16_3SumClosest {
    //暴力法
    public static int threeSumClosest(int[] nums, int target) {
        if (nums == null || nums.length == 0)
            return 0;
        int result = nums[0] + nums[1] + nums[nums.length-1]; //result的初始值
        Arrays.sort(nums);

        for (int i = 0;i<nums.length-2;i++){ //从索引 0 开始，循环遍历
            int start = i+1; int end = nums.length-1;
            while (start<end){
                int sum = nums[i] + nums[start] + nums[end];
                if (sum>target){
                    end--;
                }
                else {
                    start++;
                }
                if (Math.abs(sum-target) < Math.abs(result-target)){
                    result = sum; //找出最小值
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums =null;
        System.out.println(threeSumClosest(nums,1));
    }
}
