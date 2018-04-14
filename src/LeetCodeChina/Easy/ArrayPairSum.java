package LeetCodeChina.Easy;

import java.util.Arrays;

public class ArrayPairSum {
    public int arrayPairSum(int[] nums) {
        if (nums == null || nums.length ==0)
            return 0;

        Arrays.sort(nums);

        int sum = 0;

        for (int i=0;i<nums.length;i++){
            sum +=nums[i];
            i++;
        }

        return sum;
    }

    public static void main(String[] args) {
        ArrayPairSum arrayPairSum = new ArrayPairSum();
        int[] nums = {-8,9,21,23};
        System.out.println(arrayPairSum.arrayPairSum(nums));
    }
}
