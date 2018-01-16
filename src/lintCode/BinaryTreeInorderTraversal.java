package lintCode;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeInorderTraversal {

    /**
     * 第一种方法，采用递归做，但是计算效率较低，
     * 采用一个全局的List来存储中序遍历的结果
     * 分治或者递归遍历
     * @param root: A Tree
     * @return: Inorder in ArrayList which contains node values.
     */
    static  List<Integer> list = new ArrayList<>();
    public static List<Integer> inorderTraversal(TreeNode root) {
        // write your code
        if (root ==null){
            return null;
        }
        inorderTraversal(root.left);
        list.add(root.val);
        inorderTraversal(root.right);

        return list;
    }



    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.right =new TreeNode(2);
        root.right.left = new TreeNode(3);
        System.out.println(inorderTraversal(root).toString());
    }
}
