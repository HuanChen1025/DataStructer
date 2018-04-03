package LeetCodeChina.PrimaryAlgorithm.Arrays;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 两个数组的交集 II
 * 给定两个数组，写一个方法来计算它们的交集。
 * 例如:
 * 给定 nums1 = [1, 2, 2, 1], nums2 = [2, 2], 返回 [2, 2].
 */
public class IntersectOfTwoArrays {

    /**
     * 首先对两个数组排序，然后采用双链表合并的方法求出相同的元素
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] intersect(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null )
            return  null;
        if (nums1.length == 0 || nums2.length ==0)
            return nums1.length == 0 ? nums1:nums2;
        //对这两个数组排序
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        ArrayList<Integer> resultList = new ArrayList<>();

        //循环遍历两个数组
        for (int i=0,j=0;i<nums1.length&&j<nums2.length;){
            if (nums1[i]>nums2[j]){
                j++;
            }
            else if (nums1[i]<nums2[j]){
                i++;
            }
            else {
                resultList.add(nums1[i]);
                i++;
                j++;
            }
        }
        //返回结果
        int [] resultArray = new int[resultList.size()];
      for (int i=0;i<resultList.size();i++){
          resultArray[i]=resultList.get(i);
      }
        return resultArray;
    }
}
