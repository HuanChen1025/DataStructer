package LeetCodeChina.Easy;

/**
 * 采用动态规划的方式吗，在构造函数阶段就开始计算，会更加快速
 */
public class NumArray {


    int[] dp ;

//    /**
//     * 构造函数
//     * @param nums
//     */
//    public NumArray(int[] nums) {
//        arrays = nums;
//    }
//
//    public int sumRange(int i, int j) {
//        if (i>j || j>=arrays.length)
//            return 0;
//        int sum = 0;
//        while (i<=j){
//            sum+=arrays[i];
//            i++;
//        }
//
//        return sum;
//    }


    /**
     * 这道题让我们检索一个数组的某个区间的所有数字之和，
     * 题目中给了两条条件，首先数组内容不会变化，其次有很多的区间和检索。
     * 那么我们用传统的遍历相加来求每次区间和检索，十分的不高效，而且无法通过OJ。
     * 所以这道题的难点就在于是否能想到来用建立累计直方图的思想来建立一个累计和的数组dp，
     * 其中dp[i]表示[0, i]区间的数字之和，
     * 那么[i,j]就可以表示为dp[j]-dp[i-1]，这里要注意一下当i=0时，直接返回dp[j]即可，参见代码如下：
     * @param nums
     */
    public NumArray(int[] nums) {
       dp = nums;

       for (int i=1;i<nums.length;i++)
           dp[i] +=dp[i-1];

   }

    public int sumRange(int i, int j) {
        if (i>j || j>=dp.length)
           return 0;

        //如果 i 为 0 ，直接返回 dp[j] .因为包含两个端点，所以另外一个是 dp[i-1].
        return  i==0 ? dp[j] : dp[j]-dp[i-1];
    }

    public static void main(String[] args) {
        int [] nums = {-2, 0, 3, -5, 2, -1};
        NumArray obj = new NumArray(nums);
        int param_1 = obj.sumRange(0,5);
        System.out.println(param_1);
    }
}
