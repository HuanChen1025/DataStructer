package LeetCodeChina.PrimaryAlgorithm.dp;

/**
 * 给定一个序列（至少含有 1 个数），从该序列中寻找一个连续的子序列，使得子序列的和最大。

 * 例如，给定序列 [-2,1,-3,4,-1,2,1,-5,4]，
 * 连续子序列 [4,-1,2,1] 的和最大，为 6。
 */
public class MaxSubArray {

    /**
     * 做的不好，需要多思考
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {

        if (nums == null || nums.length ==0)
            return 0;

        int max = nums[0];
        int current = nums[0];
        for (int i=1;i<nums.length;i++){
            //考虑到第一个为负数，其后为正数
            if (current<0)
                current=0;
            current += nums[i];
            if (current>max)
                max=current;
        }
        return max;
    }

    public static void main(String[] args) {
        int [] nums = {-2,-3,-1};
        MaxSubArray maxSubArray = new MaxSubArray();
        System.out.println(maxSubArray.maxSubArray(nums));
    }
}
