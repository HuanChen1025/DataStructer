package LeetCodeChina.PrimaryAlgorithm.Other;

import java.util.HashMap;

/**
 * 缺失数字
 *
 * 给出一个包含 0, 1, 2, ..., n 中 n 个数的序列，找出 0 .. n 中没有出现在序列中的那个数。
 */
public class MissingNumber {

    /**
     * 目前想法：采用两次O(N)实现
     *
     * 行不通
     * @param nums
     * @return
     */
    public int missingNumber_01(int[] nums) {
        if (nums.length==0 || nums==null)
            return 0;

        return -1;
    }

    /**
     * 交换数组中的两个数
     * @param nums
     * @param i
     * @param j
     */
    private void swap(int[] nums,int i,int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }


    /**
     * 牺牲空间换时间
     *
     * 性能差到爆炸
     *
     * 采用hashmap
     * @param nums
     * @return
     */
    public int missingNumber_02(int[] nums) {
        if (nums.length==0 || nums==null)
            return 0;

        HashMap<Integer,Integer> map = new HashMap<>();

        for (int i=0;i<nums.length;i++){
            map.put(nums[i],nums[i]);
        }

        for (int i=0;i<nums.length+1;i++){
            if (!map.containsKey(i))
                return i;
        }

        return 0;
    }

    /**
     * 要利用 0 — n 这个性质，在线性时间内，使用O（1)的空间
     * @param nums
     * @return
     */
    public int missingNumber_03(int[] nums) {



        return 0;
    }


    public static void main(String[] args) {
        MissingNumber missingNumber = new MissingNumber();
        int[] nums ={9,6,4,2,3,5,7,0,1};

        System.out.println(missingNumber.missingNumber_02(nums));

    }
}
