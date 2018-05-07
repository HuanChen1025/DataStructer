package SwordOffer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class _5_7_printLevel {
    ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();

        if (pRoot == null)
            return res;

        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(pRoot);

        while (!queue.isEmpty()){
            int index = queue.size();
            ArrayList<Integer> level = new ArrayList<>();
            while (index>0){
                TreeNode temp = queue.poll();
                level.add(temp.val);
                if (temp.left!= null){
                    queue.add(temp.left);
                }
                if (temp.right!= null){
                    queue.add(temp.right);
                }
                index--;
            }
            res.add(level);
        }
        return res;
    }
}
