package LeetCodeChina.Arrays;

import java.util.Arrays;
import java.util.HashMap;

/**
 * 219. Contains Duplicate II
 */
public class _219ContainsDuplicate {

    /**
     * 方法1：hashMap：采用空间换时间,不能采用 hashMap
     * 方法2：双重 for 循环，超出时间限制
     * @param nums
     * @param k
     * @return
     */
    public boolean containsNearbyDuplicate_01(int[] nums, int k) {
        if (nums.length == 0 || nums == null)
            return false;

        //双重 for 循环
        for (int i=0;i<nums.length;i++){
            for (int j=i+1;j<nums.length;j++){
                if (nums[i] == nums[j] && Math.abs(i-j) <= k){
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 首先进行排序(需要求索引差值，所以不能排序)
     * 采用 hashMap 实现
     * @param nums
     * @param k
     * @return
     */
    public boolean containsNearbyDuplicate_02(int[] nums, int k) {
        if (nums.length == 0 || nums == null)
            return false;

        HashMap<Integer,Integer> map = new HashMap<>();

        for (int i=0;i<nums.length;i++){
            //如果没有包含，将其put进去
            if (!map.containsKey(nums[i])){
                map.put(nums[i],i);
            }
            else {
                if (Math.abs(i-map.get(nums[i]))<=k)
                    return true;
                else {
                    map.put(nums[i],i);//更新索引
                }
            }
        }
        return false;
    }

    /**
     * 采用 hashmap put 方法返回值的特性
     * 如果采用 put 方法写入已有该值的哈希表中，则返回该值的旧 value
     *
     * Generally people forget that map.put() can return  the old value
     * @param nums
     * @param k
     * @return
     */
    public boolean containsNearbyDuplicate_03(int[] nums, int k) {
        if (nums.length == 0 || nums == null)
            return false;

        HashMap<Integer,Integer> map = new HashMap<>();

        for (int i=0;i<nums.length;i++){
            Integer old = map.put(nums[i],i);//此处如果 map 中包含了 num[i],则写入新值，返回旧值，否者返回 null
            if (old != null && i-old <=k )
                return true;
        }
        return false;
    }
    }
