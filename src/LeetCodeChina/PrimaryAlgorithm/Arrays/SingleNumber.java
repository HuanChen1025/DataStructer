package LeetCodeChina.PrimaryAlgorithm.Arrays;

/**
 * 只出现一次的数字
 * 给定一个整数数组，除了某个元素外其余元素均出现两次。请找出这个只出现一次的元素。
 */
public class SingleNumber {
    /**
     * 采用 异或运算，两个相同的数异或结果为 0，
     * 最后剩下的就是我们需要的数字
     * 本题巧妙之处在于只有一个不同的数字，其他均是出现两次
     * 有一个小问题：
     * 1）如果恰巧出现一次的字符是 0 ，如何区分？
     * @param nums
     * @return
     */
    public int singleNumber(int[] nums) {
        if (nums == null || nums.length ==0)
            return 0;
        int result=0;
        //对数组求异或
        for (int i=0;i<nums.length;i++){
            result ^=nums[i];
        }
        return result;
    }

    public static void main(String[] args) {
        SingleNumber singleNumber = new SingleNumber();
        int[] nums ={2,2,3,3};
        System.out.println(singleNumber.singleNumber(nums));

    }
}
