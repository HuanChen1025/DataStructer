package lintCode;

public class BinaryTreeMaximumNode {
    /*
     * @param root: the root of tree
     * @return: the max node
     * 错误，忽略了子树比较为空的情况，并且将根结点忽略了
     * 正确的应该是将左右子树的返回结果在与根结点进行比较
     * 得出的最大结点值才正确
     */
    public TreeNode maxNode(TreeNode root) {
        if (root == null){
            return null;
        }
        TreeNode leftMax = maxNode(root.left);
        TreeNode rightMax = maxNode(root.right);
       // return max(leftMax,rightMax);
        return max(root,max(leftMax,rightMax)) ;
    }

    public static TreeNode max(TreeNode a ,TreeNode b){
        if (a.val > b.val){
            return a;
        }
        else {
            return b;
        }
        }
}
