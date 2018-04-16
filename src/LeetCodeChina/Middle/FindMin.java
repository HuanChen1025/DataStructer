package LeetCodeChina.Middle;

/**
 * 153. 寻找旋转排序数组中的最小值
 *
 * 分析：二分查找，因为没有重复的，于是很好判断最小点在哪。
 */
public class FindMin {
    /**
     * 当中间值大于右边的时候，最小值一定在中间值和右边之间，
     * 当中间值小于右边的时候，将右指针左移到middle
     * @param nums
     * @return
     */
    public int findMin(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;

        int start =0;
        int end = nums.length-1;
        if (nums[start]<nums[end])
            return nums[start];
        int middle=0;
        while (start<end){
             middle = start +(end-start)/2; //需要保证不能 int 相加出现溢出

            //让中位数和右边的数字比较
            if (nums[middle]>nums[end]){
                start = middle+1;
            }
            //如果 end = middle-1 的话，不能通过 {3,1,2}
            else if (nums[middle]<nums[end]){
                end = middle;
            }
        }

            return nums[start];
    }

    public static void main(String[] args) {
        FindMin findMin = new FindMin();
        int[] nums ={3,1,2};
        System.out.println(findMin.findMin(nums));

    }
}
