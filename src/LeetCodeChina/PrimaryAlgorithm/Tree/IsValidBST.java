package LeetCodeChina.PrimaryAlgorithm.Tree;

/**
 *   验证二叉搜索树
 *
 *   给定一个二叉树，判断其是否是一个有效的二叉搜索树。
 */
public class IsValidBST {

    /**
     * 做不出来
     * @param root
     * @return
     */
    public boolean isValidBST_01(TreeNode root) {
        //校验输入是否为空
        if (root == null)
            return true;




        return true;
    }

    public static void main(String[] args) {
        IsValidBST isValidBST = new IsValidBST();
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        System.out.println(isValidBST.isValidBST_01(root));

    }
}
