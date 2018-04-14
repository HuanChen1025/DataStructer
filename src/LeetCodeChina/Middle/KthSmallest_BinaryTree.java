package LeetCodeChina.Middle;

import java.util.ArrayList;
import java.util.List;

/**
 * 230. 二叉搜索树中第K小的元素
 *
 * 给定一个二叉搜索树，编写一个函数kthSmallest来查找其中第k个最小的元素。
 */
public class KthSmallest_BinaryTree {
    /**
     * 前序遍历后直接找
     * @param root
     * @param k
     * @return
     */

    List<Integer> list = new ArrayList<>();
    int index = 0;
    public int kthSmallest(TreeNode root, int k) {
        if (root==null || k<=0){
            return 0;
        }
        preOrder(root);

        return list.get(k-1);
    }

    private void preOrder(TreeNode root){
        if (root == null)
            return;
        if (root.left != null)
            preOrder(root.left);
        //值
        list.add(root.val);
        if (root.right!= null)
            preOrder(root.right);

    }

    /**
     * 更好的方法是在边递归就边找到 第 k 个值
     * @param root
     * @param k
     * @return
     */
    public int kthSmallest_01(TreeNode root, int k) {

        return -1;
    }


}
