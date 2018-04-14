package LeetCodeChina.MiddleAlgorithm.dp;

import com.sun.org.apache.regexp.internal.RE;

/**
 * 跳跃游戏
 *
 * 给定一个非负整数数组，您最初位于数组的第一个索引处。

 * 数组中的每个元素表示您在该位置的最大跳跃长度。

 * 确定是否能够到达最后一个索引。
 *
 * A = [2,3,1,1,4]，返回 true。

 * A = [3,2,1,1,4]，返回 false。进入死循环
 *
 */
public class CanJump {


    /**
     * @param nums
     * @return
     */
    public boolean canJump_01(int[] nums) {
        //校验输入
        if (nums.length == 0 || nums == null)
            return false;

        //当前所指向的索引
        int index =0;

        //判断循环数是否大于了数组长度，如果大于，则说明进入；了死循环，返回false
        int circlIndex =0;

        //必须考虑到死循环
        while (index<nums.length && circlIndex<nums.length){
            int temp = nums[index];

            index += temp;

            //判断索引值
            if (index==nums.length-1)
                return true;
            else if (index>=nums.length)
                return false;

            circlIndex++;
        }
        return false;
    }

    /**
     * 动态规划，看不太懂啊
     *
     * @param A
     * @return
     */
    public boolean canJump_02(int[] A) {


        return false;
    }

    /**
     * 贪心算法
     *
     * 看不懂
     * @param A
     * @return
     */
    public boolean canJump_03(int[] A) {
        int currMaxStep = A[0];  //当前能够跳跃的最大步数
        int step = 0;
        for (int i = 1; i < A.length; ++i) {
            if (i > currMaxStep) return false;
            currMaxStep = Math.max(i+A[i], currMaxStep);
            if (currMaxStep >= A.length-1) return true;
        }
        return currMaxStep >= A.length-1;
    }


    public static void main(String[] args) {
        int[] nums ={2,3,1,1,4};
        CanJump canJump = new CanJump();
        System.out.println(canJump.canJump_03(nums));


    }
}
