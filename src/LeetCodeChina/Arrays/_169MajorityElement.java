package LeetCodeChina.Arrays;

import java.util.HashMap;

public class _169MajorityElement {
    /**
     * 采用空间换时间，时间性能很差
     *
     * 执行时间：29ms
     * @param nums
     * @return
     */
    public int majorityElement_01(int[] nums) {

        if (nums == null || nums.length ==0){
            return 0;
        }

        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i=0;i<nums.length;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
            if (map.get(nums[i]) > nums.length/2){
                return nums[i];
            }
        }


        return 0;
    }

    /**
     * 排序之后采用二分查找
     * @param nums
     * @return
     */
    public int majorityElement_02(int[] nums) {
        if (nums == null || nums.length ==0){
            return 0;
        }




        return 0;
    }

    }
