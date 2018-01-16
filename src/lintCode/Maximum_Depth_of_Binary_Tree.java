package lintCode;

public class Maximum_Depth_of_Binary_Tree {

    /**
     * 递归解法，先
     * @param root: The root of binary tree.
     * @return: An integer.
     */
    public int maxDepth(TreeNode root) {
        // write your code here
        if (root == null){
            return 0;
        }
        return Math.max(maxDepth(root.left),maxDepth(root.right))+1;
    }

    public static void main(String[] args) {

    }

    /**
     * 迭代解法
     * 返回层次
     * 别人的：http://www.code123.cc/docs/leetcode-notes/binary_tree/maximum_depth_of_binary_tree.html
     */
}
