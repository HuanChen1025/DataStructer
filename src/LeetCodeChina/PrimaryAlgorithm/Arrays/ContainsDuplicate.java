package LeetCodeChina.PrimaryAlgorithm.Arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

/**
 * 存在重复
 * 给定一个整数数组，判断是否存在重复元素。
 * 如果任何值在数组中出现至少两次，函数应该返回 true。如果每个元素都不相同，则返回 false。
 */
public class ContainsDuplicate {

    /**
     * 第一种方法，采用 hashtable ，但是空间复杂度增高 O（n），时间复杂度为O(n)
     * 该算法的排名仅仅达到 34.5%，需要优化，找到一种空间复杂度小的办法
     * @param nums
     * @return
     */
    public boolean containsDuplicate_01(int[] nums) {
        //输入校验，不符合返回 false
        if (nums == null || nums.length == 0)
            return false;

        HashMap<Integer,Integer> result = new HashMap<>();

        for (int i=0;i<nums.length;i++){
            if (!result.containsKey(nums[i]))
                result.put(nums[i],1);
            else if (result.containsKey(nums[i])){
                return true;
            }
        }

        return false;
    }

    /**
     * 第二种方法，采用 HashSet
     * 循环遍历将元素添加到 set 中，然后比较两者的size
     * @param nums
     * @return
     */
    public boolean containsDuplicate_02(int[] nums) {
        //输入校验，不符合返回 false
        if (nums == null || nums.length == 0)
            return false;

        HashSet<Integer> set = new HashSet<>();

        for (int i :
                nums) {
            set.add(i);
            //在 foreach 下 ，此处的 i 表示数组中的元素，循环遍历
        }

        return set.size() == nums.length ?false:true;
    }

    /**
     * 采用先排序，后遍历的方式实现
     * @param nums
     * @return
     */
    public boolean containsDuplicate_03(int[] nums) {
        //输入校验，不符合返回 false
        if (nums == null || nums.length == 0)
            return false;

        Arrays.sort(nums);

        //遍历数组
        for (int i=1;i<nums.length;i++){
            if (nums[i] == nums[i-1])
                return true;
        }
        return false;
    }
    public static void main(String[] args) {
        ContainsDuplicate containsDuplicate = new ContainsDuplicate();
        int [] nums ={1,1,1,1};
        System.out.println(containsDuplicate.containsDuplicate_03(nums));

    }
}
