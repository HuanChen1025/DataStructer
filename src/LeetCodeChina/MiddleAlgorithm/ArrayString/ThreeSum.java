package LeetCodeChina.MiddleAlgorithm.ArrayString;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 *  三数之和
 *
 *  给定一个包含 n 个整数的数组 S，是否存在属于 S 的三个元素 a，b，c 使得 a + b + c = 0 ？找出所有不重复的三个元素组合使三个数的和为零。

 * 注意：结果不能包括重复的三个数的组合。
 */
public class ThreeSum {

    /**
     * 不会做
     *
     * 可以完成，但是空间和时间复杂度都会超出限制
     *
     * 暴力法
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum_01(int[] nums) {

        List<List<Integer>> res = new ArrayList<>();


        if (nums.length<2)
            return res;
        HashSet<List<Integer>> set = new HashSet<>();


        for (int i=0;i<nums.length-2;i++){
            for (int j=i+1;j<nums.length-1;j++){
                for (int k=j+1;k<nums.length;k++){
                    List<Integer> temp = new ArrayList<>();
                    if (nums[i]+nums[j]+nums[k]==0){
                        int [] arrays = {nums[i],nums[j],nums[k]};

                        Arrays.sort(arrays);
                        temp.add(arrays[0]);
                        temp.add(arrays[1]);
                        temp.add(arrays[2]);
                        set.add(temp);
                    }
                }
            }
        }

        for (List<Integer> list :
                set) {
            res.add(list);
        }

        return res;
    }


    /**
     * 时空效率更高的方法
     *
     * 先对数组进行排序
     *
     * 错误
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum_02(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();

        if (nums == null || nums.length<3)
            return res;

        //对数组排序
        Arrays.sort(nums);

        HashSet<List<Integer>> set = new HashSet<>();

        int i=0;int last = nums.length-1;

        while (i<last){
            int a= nums[i];int j=i+1;int k =last;
            while (j<k){
                int b = nums[j];int c = nums[k];
                int sum = a + b +c;

                if (sum == 0){
                    List<Integer> temp = new ArrayList<>();
                    temp.add(a);
                    temp.add(b);
                    temp.add(c);
                    set.add(temp);
                }
                if (sum>=0 ) //注意不能含有相同的索引，遇到相同的数，跳过
                    while (nums[k] == c && j < k) --k;
                if (sum<=0 )
                    while (nums[j] == b && j < k ) ++j;

            }
            while (nums[i] == a && i < last) ++i;
        }

        for (List<Integer> list :
                set) {
            res.add(list);
        }

        return res;
    }


    public static void main(String[] args) {
        ThreeSum threeSum = new ThreeSum();
        int[] s = {-1, 0, 1, 2, -1, -4};
        System.out.println(threeSum.threeSum_02(s));

    }
}
