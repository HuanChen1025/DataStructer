package lintCode;

import java.util.ArrayList;
import java.util.List;

class TreeNode {
      public int val;
      public TreeNode left, right;
    public TreeNode(int val) {
        this.val = val;
        this.left = this.right = null;
    }
  }

public class BinaryTreePostorderTraversal {
    /*
     * @param root: A Tree
     * @return: Postorder in ArrayList which contains node values.
     */
    public List<Integer> postorderTraversal(TreeNode root) {
        // write your code here
        if (root == null){
            return null;
        }
         List<Integer> result = new ArrayList<>();
         postorderTraversal(root.left);
         postorderTraversal(root.right);
        result.add(root.val);
        Math.sqrt(4);
        return result;
    }
}
