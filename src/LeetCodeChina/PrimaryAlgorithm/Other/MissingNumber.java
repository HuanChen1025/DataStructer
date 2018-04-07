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
     *
     *采用 XOR   异或求取
     * @param nums
     * @return
     */
    public int missingNumber_03(int[] nums) {
        if (nums==null || nums.length==0)
            return 0;

        int result =0;int i;
        for (i=0;i<nums.length;i++){
            result = result^i^nums[i];
        }

        return result^i;
    }


    /**
     * 要利用 0 — n 这个性质，通过对 0 — n求和，再减去数组中的元素，剩下的即位要查询的
     * @param nums
     * @return
     */
    public int missingNumber_04(int[] nums) {
        if (nums==null || nums.length==0)
            return 0;

        int n = nums.length;

        //对 0 — n求和,此处采用 long 是防止int相加产生溢出
        long sum = (n+0)*(n+1)/2;

        long result = 0;

        for (int i=0;i<nums.length;i++){
            sum = sum - (long)nums[i];
        }
        return (int)sum;
    }


    public static void main(String[] args) {
        MissingNumber missingNumber = new MissingNumber();
        int[] nums ={9,6,4,2,3,5,7,0,1};

        System.out.println(missingNumber.missingNumber_04(nums));

    }
}
