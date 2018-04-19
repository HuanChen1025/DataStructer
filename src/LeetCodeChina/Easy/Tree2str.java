package LeetCodeChina.Easy;

import LeetCodeChina.PrimaryAlgorithm.Tree.TreeNode;

/**
 * https://blog.csdn.net/obrcnh/article/details/77996276
 *  Leetcode 606. 由二叉树构建字符串
 */
public class Tree2str {

    StringBuilder res = new StringBuilder();

    /**
     * 采用先序遍历的方法，在遍历的时候注意判断左右子节点是否为空
     * @param t
     * @return
     */
    public String tree2str(TreeNode t) {
        if (t == null)
            return "";

        res.append(t.val);

        if (t.left!=null){
            res.append('(');
            tree2str(t.left);
            res.append(')');
        }
        else if (t.right!=null){
            res.append("()");
        }

        if (t.right!=null){
            res.append('(');
            tree2str(t.right);
            res.append(')');
        }

        return res.toString();
    }

    public static void main(String[] args) {
        Tree2str obj = new Tree2str();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        System.out.println(obj.tree2str(root));

    }
}
