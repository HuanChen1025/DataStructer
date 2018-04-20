package LeetCodeChina.Array;

/**
 * 485. 最大连续1的个数
 */
public class FindMaxConsecutiveOnes {
    /**
     * [1] 无法 AC
     * @param nums
     * @return
     */
    public int findMaxConsecutiveOnes(int[] nums) {
        if (nums.length == 0 || nums == null)
            return 0;

        int res = 0;

        int temCount = 0;

        for (int i=0;i<nums.length;i++){
            if (nums[i] == 1)
                temCount++;
            else if (nums[i] == 0){
//                if (temCount>res)
//                    res=temCount;
                res = Math.max(res,temCount);
                temCount=0;
            }
        }

        //为了防止类似[1]无法AC，在返回处再次判断 temCount 和 res 的大小
        //return temCount>res?temCount:res;
        return Math.max(res,temCount);
    }
}
