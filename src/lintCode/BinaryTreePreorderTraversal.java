package lintCode;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePreorderTraversal {

    /**
     * 第一种方法，采用递归实现。之后需要考虑其他方法实现，采用堆栈的方式实现树的三中遍历
     * @param root: A Tree
     * @return: Preorder in ArrayList which contains node values.
     */
    private List<Integer> list = new ArrayList<>();
    public List<Integer> preorderTraversal(TreeNode root) {
        // write your code here
        if (root == null){
            return null;
        }
        list.add(root.val);
        preorderTraversal(root.left);
        preorderTraversal(root.right);

        return list;
    }
}
