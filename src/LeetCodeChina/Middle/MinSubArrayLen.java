package LeetCodeChina.Middle;

/**
 * 209. 大于给定和最短子数组
 */
public class MinSubArrayLen {

    /**
     * 采用双指针
     *
     * @param s
     * @param nums
     * @return
     */
    public int minSubArrayLen_01(int s, int[] nums) {
        if (nums.length == 0 || nums == null)
            return 0;

        int slow = 0;
        int fast = 0;

        int sum = 0;

        int res =Integer.MAX_VALUE;

        while (fast<nums.length){
            sum = sum(nums,slow,fast);
            if (sum<s){
                fast++;
            }
            else if (sum>s){//要是第一个就大于s呢，

                int temp = fast-slow+1;
                //取最小值
                if (temp<res)
                    res=temp;
                slow++;
            }
            else {
                int temp = fast-slow+1;
                //取最小值
                if (temp<res)
                    res=temp;
                fast++;
            }
        }
        if (res == Integer.MAX_VALUE)
            res =0;
        return res;
    }

    private int sum(int[]nums,int start,int end){
        if (nums.length == 0 || start>end)
            return 0;
        int sum =0;
        for (int i=start;i<=end;i++){
            sum +=nums[i];
        }
        return sum;
    }

    public static void main(String[] args) {
        MinSubArrayLen obj = new MinSubArrayLen();
        //11
        //[1,2,3,4,5]
        int[] nums ={1,2,3,4,5};
        System.out.println(obj.minSubArrayLen_01(11,nums));
    }
}
