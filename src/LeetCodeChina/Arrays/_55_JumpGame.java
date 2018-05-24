package LeetCodeChina.Arrays;

public class _55_JumpGame {


    /**
     * 如果只是判断能否跳到终点，我们只要在遍历数组的过程中，
     * 更新每个点能跳到最远的范围就行了，如果最后这个范围大于等于终点，就是可以跳到
     *
     * 以下为贪心算法寻找可以到达的上届
     * @param nums
     * @return
     */
    public static boolean canJump(int[] nums) {
        if (nums == null || nums.length ==0)
            return true;
        int len = nums.length;

        int reach =0, i=0;

        for ( i=0;i<=reach && i<len;i++){
            //贪心算法，更新能够到达的最远点，
            reach = Math.max(reach,nums[i]+i);
        }
        return i == len;
    }

    public static boolean canJump_01(int[] nums) {

        if (nums == null || nums.length == 0)
            return true;
        int reach = 0,i=0;
        for ( i=0;i<nums.length && i<=reach;i++){
            reach = Math.max(reach,nums[i]+i);
        }
        return i==nums.length;
    }

    public static boolean canJump_02(int [] nums) {
        if (nums == null || nums.length <= 1) {
            return true;
        }
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            max = Math.max(max, i + nums[i]);//当前能够到达的最大位置，以及当前点+能跳出的最大距离，两者比较
            if (max < i + 1) {
                return false;
            }

            if (max >= nums.length - 1) {
                //可以跳到最远位置
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int [] nums ={2,3,1,1,4};
        System.out.println(canJump_02(nums));
    }
}
