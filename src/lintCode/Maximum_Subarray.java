package lintCode;

public class Maximum_Subarray {
    /**
     * @param nums: A list of integers
     * @return: A integer indicate the sum of max subarray
     */
    public static int maxSubArray(int[] nums) {
        // write your code here
        int max_ending = nums[0];
        int so_far = nums[0];
        for (int i=1;i<nums.length;i++){
            max_ending = Math.max(nums[i], nums[i] + max_ending);
            so_far = Math.max(so_far,max_ending);
        }
        return so_far;
    }

    public static void main(String[] args) {
        int [] input = {-2,2,-3,4,-1,2,1,-5,3};
        System.out.println(maxSubArray(input));
    }
}
