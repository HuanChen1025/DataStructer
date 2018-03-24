package SwordOffer;

class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }

}

public class HasSubtree {

    public static  boolean hasSubtree(TreeNode tree1,TreeNode tree2){
        boolean result =false;
        //找两颗树相同的结点值
        if (tree1 != null && tree2 != null){
            if (tree1.val == tree2.val){
                result = DoesTree1HaveTree2(tree1,tree2);
            }
            //如果返回为 false，继续找左右子树
            if (! result){
                result =DoesTree1HaveTree2(tree1.left,tree2);
            }
            if (! result){
                result = DoesTree1HaveTree2(tree1.right,tree2);
            }

        }
        return result;
    }

    private static  boolean DoesTree1HaveTree2(TreeNode tree1,TreeNode tree2){
        //此处必须先判断 tree2 是否为空，为空返回 true，
        // 然后再去判断 tree1 是否为空， tree 如果为空，返回为 false
        if (tree2 == null)
            return true;
        if (tree1 == null)
            return false;
        if (tree1.val != tree2.val)
            return false;

        return DoesTree1HaveTree2(tree1.left,tree2.left) && DoesTree1HaveTree2(tree1.right,tree2.right);
    }
}
