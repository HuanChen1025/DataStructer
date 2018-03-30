package SwordOffer;

public class TreeDepth {

    /**
     * 递归求二叉树深度
     * @param pRoot
     * @return
     */
    public static int treeDepth(TreeNode pRoot){
        if (pRoot == null)
            return 0;

        int nLeft =0;
        int nRight=0;

        if (pRoot.left != null){
             nLeft = treeDepth(pRoot.left);
        }
        if (pRoot.right != null){
             nRight = treeDepth(pRoot.right);
        }
        return (nLeft>nRight)?(nLeft+1):(nRight+1);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(0);
        root.left=new TreeNode(1);
        root.right = new TreeNode(2);
        System.out.println(treeDepth(root));
    }
}
