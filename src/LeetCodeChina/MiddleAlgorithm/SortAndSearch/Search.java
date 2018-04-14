package LeetCodeChina.MiddleAlgorithm.SortAndSearch;

/**
 * 搜索旋转排序数组
 */
public class Search {

    /**
     * 关键在于如何利用旋转排序这个条件
     *
     * 搜索可以使用二分查找
     *
     * @param nums
     * @param target
     * @return
     */
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0)
            return -1;

        int numsLen = nums.length;

        int breakPint = 0; //分割点

        for (int i=0;i<numsLen;i++){
            if (nums[i]-nums[i+1]>0){
                breakPint = i;
                break;
            }
        }

        int left = binarySearch(nums,0,breakPint,target);

        int right = binarySearch(nums,breakPint+1,numsLen-1,target);

        if (left==-1 && right==-1)
            return -1;

        if (left!=right){
            if (left==-1)
                return right;
            else
                return left;
        }

        return -1;
    }

    private int binarySearch(int[] nums,int start,int end,int target){
        if (nums == null || nums.length == 0)
            return -1;

        int middle =(start+end)/2;

        while (start<end){
            if (nums[middle] == target){
                return middle;
            }else if (nums[middle]>target){
                end = middle-1;
            }
            else if (nums[middle]<target){
                start = middle+1;
            }
        }
        return -1;
    }


    /**
     * 数组本来是排序的，采用二分查找
     *
     * 不懂哦
     *
     * 分析：二分查找，主要是确定单调递增的那一段区间
     *
     * 采用二分查找的算法是最快的，需要自己实现
     * @param A
     * @param target
     * @return
     */
    public int search_01(int[] A, int target) {
        if (A == null || A.length == 0) {
            return -1;
        }

        int start = 0;
        int end = A.length - 1;
        int mid;

        while (start + 1 < end) {
            mid = (end + start) / 2;
            if (A[mid] == target) {
                return mid;
            }
            if (A[start] < A[mid]) { // 左边升序
                // situation 1, red line
                if (A[start] <= target && target <= A[mid]) {
                    end = mid;
                } else {
                    start = mid;
                }
            } else { // 右边升序
                // situation 2, green line
                if (A[mid] <= target && target <= A[end]) {
                    start = mid;
                } else {
                    end = mid;
                }
            }
        } // while

        if (A[start] == target) {
            return start;
        }
        if (A[end] == target) {
            return end;
        }
        return -1;
    }


    public static void main(String[] args) {

        int[] nums ={4,2};

        Search search = new Search();

        System.out.println(search.search(nums,2));



    }
}
