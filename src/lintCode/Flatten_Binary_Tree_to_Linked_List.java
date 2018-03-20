package lintCode;

public class Flatten_Binary_Tree_to_Linked_List {
    /**
     * @param root: a TreeNode, the root of the binary tree
     * @return:
     * 递归解法
     * 这道题要求把二叉树展开成链表，根据展开后形成的链表的顺序分析出是使用先序遍历，
     * 那么只要是数的遍历就有递归和非递归的两种方法来求解，这里我们也用两种方法来求解。
     * 首先来看递归版本的，思路是先利用DFS的思路找到最左子节点，然后回到其父节点，
     * 把其父节点和右子节点断开，将原左子结点连上父节点的右子节点上，然后再把原右子节点
     * 连到新右子节点的右子节点上，然后再回到上一父节点做相同操作。
     *
     * ？？？ 勉强理解，不会写
     */
    public void flatten(TreeNode root) {
        // write your code here
        if (root == null) return;
        //找到最左结点
        if (root.left != null){
            flatten(root.left);
        }
        //最左结点的右节点
        if (root.right != null){
            flatten(root.right);
        }
        TreeNode tem = root.right;
        root.right = root.left;//将根节点的右结点用左结点替换
        root.left = null;//左结点为空
        while (root.right != null){
            root = root.right; //改变当前根节点为右结点
        }
        root.right = tem; //将原右节点加上

    }

    /**
     * 非递归写法
     * @param root
     */
    public void flatten_0(TreeNode root) {


    }
}
