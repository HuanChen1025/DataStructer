package SwordOffer;

public class IsSymmetrical {
    boolean isSymmetrical(TreeNode pRoot)
    {
        if (pRoot == null)
            return true;

        return helper(pRoot,pRoot);
    }

    private boolean helper(TreeNode left,TreeNode right){
        if (left == null && right == null)
            return true;

        if (left == null || right == null)
            return false;

        //如果结点的值不想等，也返回false
        if (left.val != right.val)
            return false;

        return helper(left.right,right.left) && helper(left.left,right.right);

    }
}
