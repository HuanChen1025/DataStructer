package LeetCodeChina.PrimaryAlgorithm.Tree;

import LeetCodeChina.PrimaryAlgorithm.List.ListNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrder {

    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null)
            return new ArrayList<>();

        //创建一个队列,用于存放二叉树的结点
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);  //添加root 结点到队列中


        List<List<Integer>> result = new ArrayList<>();

        //如何才能让
        int mark = 1;   //当前循环次数，表示这一层有多少个元素
        int index =0;   //记录下一层有多少个元素
        while (queue.size() != 0){
            //缓存数据应该在这里创建，每次创建，而不能使用创建一次来执行clear()的方法
            List<Integer> orderResult = new ArrayList<>();
            while (mark>0){
                root = queue.poll(); //弹出一个元素
                orderResult.add(root.val);

                if (root.left != null){
                    queue.offer(root.left);
                    index++;
                }

                if (root.right != null){
                    queue.offer(root.right);
                    index++;
                }
                mark--;
            }
            //将每一层的结果添加到结果数组中
            result.add(orderResult);
            //orderResult.clear();
            //将下一层的元素个数给 mark，并将 index 清空
            mark=index;
            index=0;
        }
        return result;
    }

    public static void main(String[] args) {
        LevelOrder levelOrder = new LevelOrder();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        List<List<Integer>> results = levelOrder.levelOrder(root);

    }
}
