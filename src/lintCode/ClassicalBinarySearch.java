package lintCode;

public class ClassicalBinarySearch {

    /**
     * Find any position of a target number in a sorted array.
     * Return -1 if target does not exist.
     * @param nums: An integer array sorted in ascending order
     * @param target: An integer
     * @return an integer
     *
     * 在没有查找到的情况下，指针移位要在中间的基础上加一或者减一
     * 否则容易发生死循环
     * 比如在1—7的数组中查找8，就会陷入死循环
     */
    public static int findPosition(int[] nums, int target) {
        // Write your code here
        if (nums.length==0 || nums ==null){
            return  -1;
        }
        int start = 0;
        int end = nums.length -1;
        int point = (start + end)/2;
        while (target != nums[point]){

            if (target > nums[point]){
                //point 点不符合，开始指针移动到point的下一个点
                start = point+1;
            }
            if (target < nums[point]){
                end = point-1;
            }
            if (start >= end){
                return -1;
            }
            point = (start + end)/2;    //重新计算指针

        }
        return point;
    }

    public static void main(String[] args) {
        int [] arrays = {1, 2, 2, 4, 5, 5};
        System.out.println(findPosition(arrays,2));

    }
}
