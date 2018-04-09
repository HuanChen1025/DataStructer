package LeetCodeChina.MiddleAlgorithm.SortAndSearch;

/**
 * 搜索范围
 *
 * 给定一个已经升序排序的整形数组，找出给定目标值的开始位置和结束位置。

 * 你的算法时间复杂度必须是 O(log n) 级别。

 * 如果在数组中找不到目标，返回 [-1, -1]。

 * 例如:
 * 给出 [5, 7, 7, 8, 8, 10] 和目标值 8，
 * 返回 [3, 4]。
 */
public class SearchRange {
    /**
     * 剑指Offer 中有说过这道题
     *
     * 凡是见到这种排好序的，首先想到的必然是二分查找
     *
     * 既然要求O(log n)那必然又是binary search变种。
     * 要找到target在数组中的左右边界，必然先得要在数组中找到一个target。
     * 一种条件反射的思路是binary search找到target，即A[mid] = target，然后从mid开始向左右扫描来发现左右边界。
     * 但显然这种算法不是O(log n)的，比如当所有元素都一样，并且等于target时，算法退化为O(n)。
     *
     * 所以这里当A[mid] = target时，我们必须继续用二分法来查找左右边界。
     *
     * 来源：http://bangbingsyb.blogspot.jp/2014/11/leetcode-search-for-range.html
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] searchRange(int[] nums, int target) {
        int [] result = {1,-1};
        //校验输入
        if (nums.length == 0 || nums == null)
            return result;

        result[0] = leftSearch(nums,target);
        result[1] = rightSearch(nums,target);

        return result;
    }

    /**
     * 向左搜索
     * @param nums
     * @param target
     * @return
     */
    private int leftSearch(int[] nums,int target){
        int start = 0;
        int end = nums.length-1;
        int middle = (start+end)/2;

        while (start<=end){
            if (nums[middle] == target){
                end = middle-1;
            }
            else if (nums[middle]>target){
                end = middle-1;
            }
            else if (nums[middle]<target){
                start = middle+1;
            }
            middle = (start+end)/2;
        }

        if (start>=0 && start<nums.length && nums[start]==target)
            return start;
        return -1;
    }

    /**
     * 右边搜索边境
     * @param nums
     * @param target
     * @return
     */
    private int rightSearch(int[] nums,int target){
        int start = 0;
        int end = nums.length-1;
        int middle = (start+end)/2;

        while (start<=end){
            if (nums[middle] == target){
                start = middle+1;
            }
            else if (nums[middle]>target){
                end = middle-1;
            }
            else if (nums[middle]<target){
                start = middle+1;
            }
            middle = (start+end)/2;
        }

        if (end>=0 && end<nums.length && nums[end]==target)
            return end;
        return -1;
    }

    public static void main(String[] args) {
        int[] nums ={5, 7, 7, 8, 8, 10};
        SearchRange searchRange = new SearchRange();
        System.out.println(searchRange.searchRange(nums,8));

    }

}
