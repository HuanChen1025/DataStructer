package lintCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class BinaryTreeLevelOrderTraversal {
    /*
     * @param root: A Tree
     * @return: Level order a list of lists of integer
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        // write your code here
        if (root == null){
            return null;
        }
        List<List<Integer>> result = new ArrayList<>();
        LinkedList<TreeNode> queue = new LinkedList<>(); //维护一个队列
        queue.add(root); //将根节点添加到队列中
        int curNum = 0;
        int lastNum =1;
        ArrayList<Integer> list = new ArrayList<>();
        while (! queue.isEmpty()){ //队列不为空，循环继续
            TreeNode cur = queue.poll();    //获取并移除此列表的头（第一个元素）
            lastNum--;
            list.add(cur.val);
            if (cur.left!=null){
                queue.add(cur.left);
                curNum++;
            }
            if (cur.right!=null){
                queue.add(cur.right);
                curNum++;
            }
            if (lastNum ==0){
                lastNum = curNum;
                curNum = 0;
                result.add(list);
                list = new ArrayList<>();
            }

        }


        return result;
    }




}
