package LeetCodeChina.Easy;

/**
 * 35. 搜索插入位置
 * 给定一个排序数组和一个目标值，如果在数组中找到目标值则返回索引。如果没有，返回到它将会被按顺序插入的位置。

 * 你可以假设在数组中无重复元素。
 */
public class SearchInsert {
    public int searchInsert(int[] nums, int target) {
        if (nums == null || nums.length == 0)
            return 0;   //此处的 0  和实际返回的 0 如何区分

        if (target<nums[0])
            return 0;
        if (target>nums[nums.length-1])
            return nums.length;

        int start = 0;
        int end = nums.length-1;

        while (start<=end){
            int middle =(start + end)/2;

            //匹配，返回索引
            if (nums[middle] == target){
                return middle;
            }

            else if (nums[middle] > target){
                end = middle-1;
            }

            else if (nums[middle] < target){
                start = middle +1;
            }
        }
        //如果没找到，返回 start 位置
        return start;
    }

    public static void main(String[] args) {
        int [] nums ={1,3,5,6};
        SearchInsert searchInsert = new SearchInsert();
        int x=  searchInsert.searchInsert(nums,4);
        System.out.println();
    }
}
