package LeetCodeChina.MiddleAlgorithm.dp;

public class LengthOfLIS {

    /**
     * 我觉得和最大子数组和是一样的，试一试
     *
     * 这个不要求连续，不好使啊
     *
     * 太难
     * @param nums
     * @return
     */
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length ==0)
            return 0;



        return 0;
    }


    public static void main(String[] args) {
        int [] nums = {10, 9, 2, 5, 3, 7, 101, 18};
        LengthOfLIS lengthOfLIS = new LengthOfLIS();
        System.out.println(lengthOfLIS.lengthOfLIS(nums));

    }
}
