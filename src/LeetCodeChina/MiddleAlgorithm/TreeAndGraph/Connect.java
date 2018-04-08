package LeetCodeChina.MiddleAlgorithm.TreeAndGraph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

class TreeLinkNode {
      int val;
      TreeLinkNode left, right, next;
      TreeLinkNode(int x) { val = x; }
  }

public class Connect {

    /**
     * 我觉得这是一个层次遍历的问题
     *
     * 时间复杂度为O(N),空间复杂度也为O(N)
     *
     * @param root
     */
    public void connect(TreeLinkNode root) {
        if (root == null)
            return;

        Queue<TreeLinkNode> queue = new ArrayDeque<>(); //队列，用于保存结点

        int count = 1;
        int levelCount = 0;
        //将根节点添加到队列中
        queue.add(root);
        root.next = null;//根节点的 next 结点为 null

        //只要队列不为空
        while (!queue.isEmpty()){

            TreeLinkNode nextNode = null;
            while (count>0){
                TreeLinkNode currentNode = queue.poll();
                 if (count == 1){
                       nextNode = null;   //如果是该层的最后一个结点，就会把它指向下一层的第一个结点.所以如果count == 1，则是该层最后一个结点
                 }else
                     nextNode = queue.peek();   //不是该层的最后一个结点

                currentNode.next = nextNode;
                if (currentNode.left != null){
                    queue.offer(currentNode.left);//添加到队列
                    levelCount++;
                }
                if (currentNode.right!=null){
                    queue.offer(currentNode.right);
                    levelCount++;
                }
                count--;
            }
            count = levelCount; //这一层的结点
            levelCount=0;   //记录下下一层的结点
        }

    }

    /**
     * 有更快的方法：采用递归来实现，
     * @param root
     */
    public void connect_01(TreeLinkNode root) {


        return;
    }

    public static void main(String[] args) {
        TreeLinkNode root = new TreeLinkNode(1);
        root.left = new TreeLinkNode(2);
        root.right = new TreeLinkNode(3);
        root.left.left = new TreeLinkNode(4);
        root.left.right = new TreeLinkNode(5);
        root.right.left = new TreeLinkNode(6);
        root.right.right = new TreeLinkNode(7);
        Connect connect = new Connect();
        connect.connect(root);

        System.out.println();



    }
}
