package LeetCodeChina.Tree;

/**
 * 将一个排序的数组转化为二叉搜索树
 * 首先找出中间的值，然后分别对两边使用递归
 */
public class _108ConvertArrayToBST {
    /**
     * https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/discuss/128430/Java-Solution-beats-100-Short-and-Explained
     * @param nums
     * @return
     */
    public static TreeNode sortedArrayToBST_01(int[] nums) {
        return arrayToBST(nums,0,nums.length-1);
    }

    private static TreeNode arrayToBST(int nums[],int s,int e){
        if (s>e) return null;   //如果头指针大于尾指针，返回 null
        int mid =s+(e-s)/2;
        TreeNode node = new TreeNode(nums[mid]);

        node.left = arrayToBST(nums,s,mid-1);
        node.right = arrayToBST(nums,mid+1,e);

        return node;
    }

    public static void main(String[] args) {
        int[] nums ={-10,-3,0,5,9};
        TreeNode root = sortedArrayToBST_01(nums);
        System.out.println();
    }
}
