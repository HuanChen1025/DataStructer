package LeetCodeChina.PrimaryAlgorithm.Arrays;

import java.util.Arrays;
import java.util.HashMap;

/**
 * 给定一个整数数列，找出其中和为特定值的那两个数。
 * 你可以假设每个输入都只会有一种答案，同样的元素不能被重用。
 * 首先对数组排序，然后从两端往中间查找
 * 能够保证快速查找到相等的两个数，但是对于位置的获取就比较麻烦了
 */
public class TwoSum {
    public int[] twoSum_01(int[] nums, int target) {
        if (nums == null || nums.length == 0)
            return null;
        int[] result = new int[2];  //保存结果
        int [] tempNums = nums.clone();
        //排序
        Arrays.sort(nums);

        //两端查找，快速找出和为 target 的两个数
        for (int left =0,right=nums.length-1;left<right;){
            if (nums[left]+nums[right]>target){
                right--;
            }
            else if (nums[left]+nums[right]<target){
                left++;
            }
            else if (nums[left]+nums[right]==target){
                result[0] = nums[left];
                result[1] = nums[right];
                break;
            }
        }
        //查找第一个数的实际位置
        for (int i=0;i<nums.length;i++){
            if (tempNums[i] == result[0]){
                result[0] =i;
                break;
            }
        }

        //查找第二个数的实际位置,防止所给数组中出现重复数字
        for (int i=0;i<nums.length;i++){
            if (tempNums[i] ==result[1] && i!=result[0]){
                result[1] = i;
                break;
            }
        }

        return result;
    }

    /**
     * 采用 hashTable 实现
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum_02(int[] nums, int target) {
        if (nums == null || nums.length == 0)
            return null;

        HashMap<Integer,Integer> tempTable = new HashMap<>();
        int[] result = new int[2];

        for (int i=0;i<nums.length;i++){
            if (!tempTable.containsKey(target-nums[i])){
                tempTable.put(nums[i],i);
            }
            else {
                result[0] = tempTable.get(target-nums[i]);
                result[1] =i;
                break;
            }
        }
        return result;
    }

        public static void main(String[] args) {
        TwoSum twoSum = new TwoSum();
        int[] nums ={3};
         int [] results = twoSum.twoSum_01(nums,6);
        System.out.println(results[0]);
        System.out.println(results[1]);

    }
}
