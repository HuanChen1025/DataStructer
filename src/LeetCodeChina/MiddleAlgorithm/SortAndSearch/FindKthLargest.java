package LeetCodeChina.MiddleAlgorithm.SortAndSearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 数组中的第K个最大元素
 *
 * 在未排序的数组中找到第 k 个最大的元素。请注意，它是数组有序排列后的第 k 个最大元素，而不是第 k 个不同元素。

 * 例如，
 * 给出 [3,2,1,5,6,4] 和 k = 2，返回 5。
 */
public class FindKthLargest {


    /**
     * //采用最大堆来做是比较合适的，但是涉及到API，完全重写很麻烦
     *
     * 第一个方法
     *
     * @param nums
     * @param k
     * @return
     */
    public int findKthLargest(int[] nums, int k) {
        //检验输入
        if (nums == null || nums.length == 0 || k<=0 || k>nums.length)
            return -1;

        List<Integer> list = new ArrayList<>();

        for (int i=0;i<nums.length;i++){
            list.add(nums[i]);
        }

        Collections.sort(list);

        Collections.reverse(list);

        return list.get(k-1);
    }

    /**
     * 采用了 java 自带的排序算法，代码比较精简
     * @param nums
     * @param k
     * @return
     */
    public int findKthLargest_02(int[] nums, int k) {
        //检验输入
        if (nums == null || nums.length == 0 || k<=0 || k>nums.length)
            return -1;

        Arrays.sort(nums);
        return nums[nums.length-k];
    }


    public static void main(String[] args) {
        FindKthLargest findKthLargest = new FindKthLargest();
        int[] nums = {3,2,1,5,6,4};
        System.out.println(findKthLargest.findKthLargest(nums,2));
    }
}
