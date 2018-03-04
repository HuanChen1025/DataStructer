package lintCode;

public class Reverse_Array {
    /**
     * Reverse the given array nums inplace.
     * @param nums: a integer array
     * @return: nothing
     * 直接数组元素对换
     */
    public void reverseArray(int[] nums) {
        // write your code here
        if (nums.length==0 || nums == null)
            return;
        for (int start =0,end=nums.length-1;start<end;start++,end--){
            int temp = nums[end];
            nums[end] = nums[start];
            nums[start]= temp;
        }


    }
}
