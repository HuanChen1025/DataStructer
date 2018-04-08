package LeetCodeChina.MiddleAlgorithm.TreeAndGraph;

import LeetCodeChina.PrimaryAlgorithm.Tree.TreeNode;

import java.util.*;

/**
 *   二叉树的锯齿形层次遍历
 *
 *   给定一个二叉树，返回其节点值的锯齿形层次遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
 * 例如：
 * 给定二叉树 [3,9,20,null,null,15,7],
 */
public class ZigzagLevelOrder {

    /**
     * 首先这是一个二叉树的层次遍历
     *
     * 然后根据层次的奇偶，选择是先进左子树还是右子树
     *
     * 采用队列来存储结点
     *
     * 该方法不行，在层次遍历的基础上无法实现 z 遍历
     *
     * 实现了层次遍历
     *
     * @param root
     * @return
     */
    public List<List<Integer>> zigzagLevelOrder_01(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();

        Queue<TreeNode> queue = new ArrayDeque<>(); //队列，用于保存结点
        //校验输入
        if (root == null)
            return result;

        boolean flag = true;
        int count = 1;
        int levelCount = 0;
        //将根节点添加到队列中
        queue.add(root);

        //只要队列不为空
        while (!queue.isEmpty()){

            List<Integer> levelResult = new ArrayList<>();
            while (count>0){
                TreeNode current = queue.poll();
                levelResult.add(current.val);
                    if (current.left!= null){
                        queue.offer(current.left);//添加到队列
                        levelCount++;
                    }
                    if (current.right!=null){
                        queue.offer(current.right);
                        levelCount++;
                    }
                count--;
            }
            result.add(levelResult);
            count = levelCount; //这一层的结点
            levelCount=0;   //记录下下一层的结点

        }

        return result;
    }


    /**
     * 二叉树的锯齿形层次遍历
     *
     * 在层次遍历法的基础上每一层输出结果间隔反转
     *
     * Collections.reverse(levelResult);
     * @param root
     * @return
     */
    public List<List<Integer>> zigzagLevelOrder_02(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();

        Queue<TreeNode> queue = new ArrayDeque<>(); //队列，用于保存结点
        //校验输入
        if (root == null)
            return result;

        boolean flag = false;
        int count = 1;
        int levelCount = 0;
        //将根节点添加到队列中
        queue.add(root);

        //只要队列不为空
        while (!queue.isEmpty()){
            List<Integer> levelResult = new ArrayList<>();
            while (count>0){
                TreeNode current = queue.poll();
                levelResult.add(current.val);
                if (current.left!= null){
                    queue.offer(current.left);//添加到队列
                    levelCount++;
                }
                if (current.right!=null){
                    queue.offer(current.right);
                    levelCount++;
                }
                count--;
            }
            if (flag == true){
                Collections.reverse(levelResult);
                result.add(levelResult);
                flag = false;
            }else {
                result.add(levelResult);
                flag = true;
            }

            count = levelCount; //这一层的结点
            levelCount=0;   //记录下下一层的结点

        }
        return result;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        ZigzagLevelOrder zigzagLevelOrder = new ZigzagLevelOrder();
        zigzagLevelOrder.zigzagLevelOrder_02(root);
        System.out.println();
    }
}
