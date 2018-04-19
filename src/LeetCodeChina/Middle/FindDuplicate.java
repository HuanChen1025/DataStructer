package LeetCodeChina.Middle;

import java.util.Arrays;
import java.util.HashSet;

/**
 * 287. 寻找重复数
 */
public class FindDuplicate {
    /**
     * 暴力法
     * 采用 hashmap ，但是以空间换时间,时间复杂度不符合要求
     *
     * 不能改变数组
     * https://segmentfault.com/a/1190000003817671
     * @param nums
     * @return
     */
    public int findDuplicate_01(int[] nums) {
        if (nums.length == 0 || nums == null)
            return 0;

        HashSet<Integer> set = new HashSet<>();

        for (int number:nums) {
            if (set.contains(number)){
                return number;
            }
            else {
                set.add(number);
            }
        }
        return 0;
    }

    /**
     * 大前提：1-n  ，n+1 个数字，只有一个重复，必然完整的包含了 1-n个数字
     *
     * 和我理解的不一样：[2,2,2,2,2]也包含在这里面
     *
     * 数字都在1-n之间，但并不是都需要出现
     *
     * 该方法废了。我想的也太简单了
     * @param nums
     * @return
     */
    public int findDuplicate_02(int[] nums) {
        if (nums.length == 0 || nums == null)
            return 0;

        int n = nums.length;

        int sum =0;

        for (int i=0;i<n;i++){
            sum +=nums[i];
        }
        return sum - (n-1)*(n)/2;
    }

    /**
     * 采用双指针，但是时间复杂度为平方，暴力法求解
     * https://blog.csdn.net/jmspan/article/details/51158516-
     * @param nums
     * @return
     */
    public int findDuplicate_03(int[] nums) {
        int high = nums.length-1;
        int low = 0;

        while (high>=low){
            int middle = low +(high-low)/2;
            int count = 0;
            for (int i=0;i<nums.length;i++){
                if (nums[i]<=middle){
                    count++;
                }
            }
            //如果满足，说明 1-middle 之间有重复数字
            if (count>middle)
                high = middle-1;
            else
                low=middle+1;
        }

        return low;
    }

    public static void main(String[] args) {
        FindDuplicate obj = new FindDuplicate();
        int [] nums ={2,2,2,2,2};
        System.out.println(obj.findDuplicate_03(nums));

    }
}
