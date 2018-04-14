package LeetCodeChina.Easy;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * 349. 两个数组的交集
 * 给定两个数组，写一个函数来计算它们的交集。

 * 例子:

 * 给定 num1= [1, 2, 2, 1], nums2 = [2, 2], 返回 [2].
 *
 * 采用了集合类，暴力法求解，改进方法为二分查找
 *
 * 算法的时间复杂度O(n),但是空间复杂度有点高
 */
public class Intersection {

    public int[] intersection(int[] nums1, int[] nums2) {
        int[] result = {};
        HashSet<Integer> res = new HashSet<>();
        if (nums1.length == 0 || nums1 == null || nums2.length == 0 || nums2 == null)
            return result;

        HashSet<Integer> set = new HashSet<>();

        for (int value :
                nums1) {
            set.add(value);
        }

        for (int value :
                nums2) {
            if (set.contains(value))
                res.add(value);
        }

        result = new int[res.size()];

        int i=0;


        for (int value:
             res) {
            result[i] = value;
            i++;
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums1 ={1,2};
        int[] nums2 ={1,1};
        Intersection intersection = new Intersection();
        intersection.intersection(nums1,nums2);

    }
}
