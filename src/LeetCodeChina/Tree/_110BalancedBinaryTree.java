package LeetCodeChina.Tree;

/**
 * 判断一颗二叉树是否是平衡二叉树
 */
public class _110BalancedBinaryTree {
    /**
     * 在遍历树的每个结点的时候，调用函数TreeDepth得到它的左右子树的深度。
     * 如果每个结点的左右子树的深度相差都不超过1，按照定义它就是一棵平衡的二叉树。
     *
     * 可以判断是否为平衡二叉树，但是在获取二叉树深度时存在大量的重复计算，
     *
     * 需要重复遍历多次结点
     * @param root
     * @return
     */
    public boolean isBalanced_01(TreeNode root) {
        if (root == null)
            return true;

        int left = getTreeDepth(root.left);
        int right = getTreeDepth(root.right);

        int diff = left-right;

        if (diff>1 || diff<-1)
            return false;

        return isBalanced_01(root.left) && isBalanced_01(root.right);
    }

    /**
     * 获取树的高度
     * 1）如果只有根结点，深度为1
     * 2）如果只有左子树，那么树的深度就应该是左子树加1.右子树同理
     * 3）如果左右子树都有，那么返回较大的一个加1
     * @param root
     * @return
     */
    private int getTreeDepth(TreeNode root){
        if (root == null)
            return 0;

        int left = getTreeDepth(root.left);
        int right = getTreeDepth(root.right);

        return left>=right ? left+1:right+1;
    }

    /**
     * 结点只需遍历一次
     * @param root
     * @return
     */
    public boolean isBalanced_02(TreeNode root) {
        return balabcedHelper(root) != -1;
    }

    /**
     * 为了避免重复遍历，采用后序遍历的方式
     * @param root
     * @return
     */
    private int balabcedHelper(TreeNode root){
        if (root == null)
            return 0;
        //后续遍历
        int left = balabcedHelper(root.left);
        if (left==-1) return -1;

        int right = balabcedHelper(root.right);
        if (right == -1) return -1;

        //如果差值大于1，返回-1，否者找出较大深度加上一并返回
        return Math.abs(left-right)>1?-1:Math.max(left,right)+1;
    }




}
