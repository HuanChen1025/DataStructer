package lintCode;

import java.util.ArrayList;
import java.util.Arrays;

public class Intersection_of_Two_Arrays_II {
    /**
     * @param nums1: an integer array
     * @param nums2: an integer array
     * @return: an integer array
     * Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2, 2].
     * 暴力法求解，出现问题，无法AC
     */
    public int[] intersection(int[] nums1, int[] nums2) {
        // write your code here
        //如何知道保存结果的数组初始化为多少呢？
        ArrayList<Integer> array = new ArrayList();

        for (int i =0;i<nums1.length;i++){
            for (int j=0;j<nums2.length;j++){
                if (nums1[i]==nums2[j]){
                    array.add(nums1[i]);
                    break;
                }
            }
        }
        int[] nums3 = new int[array.size()];
        for(int i =0;i<array.size();i++){
            nums3[i] = array.get(i);
        }

        return  nums3;
    }


    public int[] intersection2(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        ArrayList<Integer> result = new ArrayList();
        for (int i =0,j=0;i<nums1.length && j<nums2.length;){
        if (nums1[i] == nums2[j]){
            result.add(nums1[i]);
            i++;
            j++;
        }
        else if (nums1[i] < nums2[j]){
            i++;
        }
        else {
            j++;
        }

        }
        int[] nums3 = new int[result.size()];
        for(int i =0;i<result.size();i++){
            nums3[i] = result.get(i);
        }


        return nums3;
    }
}
