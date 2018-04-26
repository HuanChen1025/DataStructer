package LeetCodeChina.TwoList;

/**
 * 713. Subarray Product Less Than K
 * eg: [10, 5, 2, 6], k = 100
 */
public class NumSubarrayProductLessThanK {

    /**
     * https://blog.csdn.net/Koala_Tree/article/details/78497275?locationNum=9&fps=1
     * https://www.cnblogs.com/grandyang/p/7753959.html 解答非常赞
     * @param nums
     * @param k
     * @return
     */
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (nums.length == 0 || k<=1)
            return 0;

        int n = nums.length; //数组长度

        long p = 1l;    //保存中间结果，防止溢出

        int left=0,total =0;

        for (int j=0;j<n;j++){
            p *= nums[j];
            while (p>= k){
                p /= nums[left];
                left++;
            }
            total += (j-left+1); //滑动窗口的大小就是当前子数组的大小
        }

        return total;
    }

    public static void main(String[] args) {
        NumSubarrayProductLessThanK obj = new NumSubarrayProductLessThanK();

        //[10,9,10,4,3,8,3,3,6,2,10,10,9,3]
        //19
        int [] nums ={10,9,10,4,3,8,3,3,6,2,10,10,9,3};
        System.out.println(obj.numSubarrayProductLessThanK(nums,19));

    }

}
