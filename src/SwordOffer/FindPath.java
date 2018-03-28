package SwordOffer;



import java.util.ArrayDeque;
import java.util.ArrayList;

/**
 * 程序有点乱，需要重写
 */
public class FindPath {

    //将保存结果的结合设置成全局的变量，方便在函数中添加结果
    ArrayList<ArrayList<Integer>> resultAllPath = new ArrayList<>();

    public  ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        if (root == null)
            return resultAllPath;
        ArrayDeque<Integer> path = new ArrayDeque<>();   //保存路径的栈
        int currentSum = 0;
        FindOnePath(root,target,path,currentSum);
        return resultAllPath;
    }

    private void FindOnePath(TreeNode root,int expectedSum,ArrayDeque<Integer> path,int currentSum){
        currentSum +=root.val;
        path.offer(root.val);   //将结点添加到栈
        //如果为叶节点，并且路径上结点的和等于输入的值
        //打印这条路径
        ArrayList<Integer> onePath = new ArrayList<>();
        boolean isLeaf = root.left == null && root.right == null;
        if (currentSum == expectedSum && isLeaf == true){
            ArrayDeque<Integer> pathCopy =path.clone();
            int pathLength = path.size();
            while (pathLength>0){
                onePath.add(pathCopy.remove());
                pathLength--;
            }
            resultAllPath.add(onePath);
        }
        //如果不是叶节点，遍历它的子节点
        if (root.left != null)
            FindOnePath(root.left,expectedSum,path,currentSum);
        if (root.right != null)
            FindOnePath(root.right,expectedSum,path,currentSum);
        //在返回子节点前，在路径上删除当前结点
        path.pollLast();    //在回到父节点以前，删除当前结点
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(12);
       // ArrayList<ArrayList<Integer>> result =  FindPath(root,22);
    }
}
