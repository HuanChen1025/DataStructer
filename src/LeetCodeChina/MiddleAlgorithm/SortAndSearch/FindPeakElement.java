package LeetCodeChina.MiddleAlgorithm.SortAndSearch;

/**
 * 寻找峰值
 *
 * 峰值元素是指其值大于左右相邻值的元素。

 * 给定一个输入数组，其中 num[i] ≠ num[i+1]，找到峰值元素并返回其索引。

 * 数组可能包含多个峰值，在这种情况下，返回到任何一个峰值所在位置都可以。

 * 你可以想象得到  num[-1] = num[n] = -∞。

 * 例如，在数组 [1, 2, 3, 1]中 3 是峰值元素您的函数应该返回索引号2。
 */
public class FindPeakElement {

    /**
     * 有更优的实现解，本方法不是最优
     * @param nums
     * @return
     */
    public int findPeakElement(int[] nums) {
        if (nums.length == 0 || nums == null)
            return -1;


        for (int i=0;i<nums.length;i++){
            int currentValue =nums[i];
            int preIndex = i-1;
            int preValue =0;
            int nextIndex =i+1;
            int nextValue =0;

            if (preIndex<0)
                preValue=Integer.MIN_VALUE;
            else
                preValue = nums[preIndex];

            if (nextIndex>=nums.length)
                nextValue = Integer.MIN_VALUE;
            else
                nextValue = nums[nextIndex];

            if (currentValue>preValue && currentValue>nextValue)
                return i;
        }
        return 0;
    }

    public static void main(String[] args) {
        int[] nums ={-2147483648};
        FindPeakElement findPeakElement = new FindPeakElement();
        System.out.println(findPeakElement.findPeakElement(nums));

    }
}
