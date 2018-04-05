package LeetCodeChina.PrimaryAlgorithm.Tree;

import LeetCodeChina.PrimaryAlgorithm.List.ListNode;

/**
 * 对称二叉树

 * 给定一个二叉树，检查它是否是它自己的镜像（即，围绕它的中心对称）。

 * 例如，这个二叉树 [1,2,2,3,4,4,3] 是对称的。
 */
public class IsSymmetric {

    /**
     * 递归实现
     * @param root
     * @return
     */
    public boolean isSymmetric_01(TreeNode root) {
        //校验输入
        if (root == null)
            return true;

        return twoTreeSymmetric(root.left,root.right);
    }

    /**
     * 判断两棵树是否是对称的
     * @param p
     * @param q
     * @return
     */
    private boolean  twoTreeSymmetric(TreeNode p,TreeNode q){
        if (p == null && q==null)
            return true;

        //此条件不能放到上一个条件之前
        if (p == null || q == null){
            return false;
        }
        boolean flag = false;
        if (p.val == q.val){
          flag =  twoTreeSymmetric(p.left,q.right) && twoTreeSymmetric(p.right,q.left);
        }
        return flag;
    }

    public static void main(String[] args) {
        IsSymmetric isSymmetric = new IsSymmetric();
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.right = new TreeNode(1);

        System.out.println(isSymmetric.isSymmetric_01(root));
    }
}
