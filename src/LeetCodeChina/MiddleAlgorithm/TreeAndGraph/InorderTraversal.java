package LeetCodeChina.MiddleAlgorithm.TreeAndGraph;

import LeetCodeChina.PrimaryAlgorithm.Tree.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 中序遍历二叉树:中序遍历二叉树的步骤是左根右
 *
 * 最容易的思路是采用递归的思路:
 *
 * 对左子结点调用递归函数，根节点访问值，右子节点再调用递归函数
 *
 * 给定一个二叉树，返回其中序遍历。
 *
 */
public class InorderTraversal {
    //返回结果集
    List<Integer> results = new ArrayList<>();
    public List<Integer> inorderTraversal(TreeNode root) {

        //如果为空，返回空的集合，此处不能返回 null
        if (root == null)
            return new ArrayList<>();

        //左子节点递归
        if (root.left != null){
            inorderTraversal(root.left);
        }

        //根节点添加值
        results.add(root.val);

        //右子节点调用值
        if (root.right != null){
            inorderTraversal(root.right);
        }

        return results;
    }

    /**
     * 递归不是性能最优的，涉及到递归点处的保护
     *
     * 采用循环
     *
     * 需要用栈来做，思路是从根节点开始，先将根节点压入栈，
     *
     * 然后再将其所有左子结点压入栈，然后取出栈顶节点，保存节点值，
     *
     * 再将当前指针移到其右子节点上，若存在右子节点，则在下次循环时又可将其所有左子结点压入栈中。
     *
     * 这样就保证了访问顺序为左-根-右，
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal_01(TreeNode root) {
        //如果为空，返回空的集合，此处不能返回 null
        if (root == null)
            return new ArrayList<>();

        //返回结果集
        List<Integer> results = new ArrayList<>();

        //堆，用于保存结点
        Stack<TreeNode> stack = new Stack<>();

        //临时结点，代替 root，不能改变原树
        TreeNode p = root;

        while (p!=null || !stack.empty()){
            //把根节点的所有左结点压入到堆栈中
            while (p!=null){
                stack.push(p);
                p=p.left;
            }
            p = stack.peek();   //返回堆栈的顶，不弹出
            stack.pop();
            results.add(p.val);
            p=p.right;
        }
        return results;
    }


        public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(8);
        InorderTraversal inorderTraversal = new InorderTraversal();
        List<Integer> res = new ArrayList<>();

        res = inorderTraversal.inorderTraversal_01(root);

        for (int i :
                res) {
            System.out.println(i);
        }

    }
}
