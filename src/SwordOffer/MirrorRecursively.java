package SwordOffer;

public class MirrorRecursively {

    public static  void  mirrorRecursively(TreeNode pNode){
        if (pNode == null)
            return;
        if (pNode.left == null && pNode.right == null)
            return;
        TreeNode temp = pNode.left;
        pNode.left = pNode.right;
        pNode.right = temp;

        //交换不为空的左结点
        if (pNode.left != null){
            mirrorRecursively(pNode.left);
        }

        //交换不为空的右节点
        if (pNode.right != null){
            mirrorRecursively(pNode.right);
        }
    }
}
