package LeetCodeChina.PrimaryAlgorithm.Tree;

/**
 *   二叉树的最大深度
 *
 * 给定一个二叉树，找出其最大深度。
 *
 * 二叉树的深度为根节点到最远叶节点的最长路径上的节点数。
 */
public class MaxDepth {

    public int maxDepth(TreeNode root) {
        //校验输入是否为空
        if (root == null)
            return 0;

        int leftDepth = 0;
        int rightDepth = 0;
        //左子树的最大深度
        if (root.left != null){
             leftDepth = maxDepth(root.left);
        }

        //右子树的最大深度
        if (root.right != null){
             rightDepth = maxDepth(root.right);

        }
        return leftDepth>rightDepth?leftDepth+1:rightDepth+1;
    }

    public static void main(String[] args) {
        MaxDepth main = new MaxDepth();
        TreeNode root = new TreeNode(3);
        System.out.println(main.maxDepth(root));

    }
}
