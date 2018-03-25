package SwordOffer;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class OrderPrintBinaaryNode {

    /**
     * 按层遍历二叉树
     * 采用 LinkedList 模拟实现一个队列，用于存储二叉树的结点
     * @param treeNode
     */
    public static ArrayList<Integer> orderPrintBinaaryNode(TreeNode treeNode){
        //采用 offer 和 poll 方法
        Queue<TreeNode> queue = new LinkedList<>();
        ArrayList<Integer> result = new ArrayList<>();
        //判断输入是否为空
        if (treeNode == null){
            return result;
        }
        queue.offer(treeNode);
      while (queue.size()>0){
          TreeNode  pNode = queue.poll();   //返回第一个元素，并在队列中删除
          result.add(pNode.val);
          if (pNode.left != null)
              queue.offer(pNode.left);
          if (pNode.right != null)
              queue.offer(pNode.right);
      }
      return result;
    }
}
