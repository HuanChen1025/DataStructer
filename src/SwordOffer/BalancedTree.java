package SwordOffer;

public class BalancedTree {
    /**
     * 判断一颗二叉树是否是平衡二叉树
     * 这是最容易想到的方法
     * 但是存在大量重复计算的结点，时间效率利用不高
     * @return
     */
    public boolean isBalanced(TreeNode root){
        if (root == null)
            return true;

        //求取每个结点的左右子树的高度
        int left =  getTreeDepth(root.left);
        int right = getTreeDepth(root.right);

        //判断结点的左右子树高度
        int diff = left - right;
        if (diff>1 || diff<-1)
            return false;

        return isBalanced(root.left) && isBalanced(root.right);
    }

    private int getTreeDepth(TreeNode root){
        if (root == null)
            return 0;

        int left = getTreeDepth(root.left);
        int right = getTreeDepth(root.right);


        //判断左右子节点深度，谁大就在它的基础上加1返回，此处需要注意
        return (left>right)?(left+1):(right+1);
    }

    /**
     * 采用后续遍历的方式，一边遍历一边判断每个结点是不是平衡的
     * 不能通过所有的测试用例
     * @param root
     * @param depth
     * @return
     */
       static int[] left = new int[1]; static int[] right = new int[1];
    private boolean isBalanced_function(TreeNode root,int[] depth){
        if (root == null){
            depth[0] =0;
            return true;
        }
        if (isBalanced_function(root.left,left)&&isBalanced_function(root.right,right)){
            int diff = left[0]-right[0];
            if (diff<=1 && diff>=-1){
                depth[0] = 1 + (left[0]>right[0] ?left[0]:right[0]);
                return true;
            }
        }
        return false;
    }

    public boolean isBalanced_02(TreeNode root){
        int[] depth = new int[1];
        return isBalanced_function(root,depth);
    }

    public static void main(String[] args) {
        BalancedTree balancedTree = new BalancedTree();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(3);
        root.right = new TreeNode(8);

        System.out.println(balancedTree.isBalanced_02(root));
    }
    }
