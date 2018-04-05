package LeetCodeChina.PrimaryAlgorithm.dp;

/**
 * 打家劫舍
 *
 * 你是一个专业的强盗，计划抢劫沿街的房屋。每间房都藏有一定的现金，阻止你抢劫他们的唯一的制约因素就是相邻的房屋有保安系统连接，
 * 如果两间相邻的房屋在同一晚上被闯入，它会自动联系警方。
 *
 * 给定一个代表每个房屋的金额的非负整数列表，确定你可以在没有提醒警方的情况下抢劫的最高金额。
 */
public class Rob {

    /**
     * 需要自己实现，算法不难，主要在于理解这里面的规律
     * @param nums
     * @return
     */
    public int rob(int[] nums) {
        int curMax = 0, curPrePreMax = 0;
        for (int cur : nums) {
            int temp = curMax;
            curMax = Math.max(curMax, curPrePreMax + cur);
            curPrePreMax = temp;
        }
        return curMax;
    }

    public static void main(String[] args) {
        Rob rob = new Rob();
        int[] nums ={3, 2, 4, 7, 5, 6};
        System.out.println(rob.rob(nums));
    }
}
