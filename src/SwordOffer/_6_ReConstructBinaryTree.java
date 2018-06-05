package SwordOffer;

public class _6_ReConstructBinaryTree {
    public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        if (pre == null || in == null || pre.length != in.length)
            return null;
        return reConstructBinaryTree(pre,0,pre.length-1,in,0,in.length-1);
    }

    /**
     * 递归，重建二叉树
     * 根据前序遍历找到跟结点，根据找到的跟结点在中序遍历中找到左右子树的分界点
     * https://www.nowcoder.com/questionTerminal/8a19cbe657394eeaac2f6ea9b0f6fcf6
     * @param pre
     * @param startPre
     * @param endPre
     * @param in
     * @param startIn
     * @param endIn
     * @return
     */
    private TreeNode reConstructBinaryTree(int [] pre, int startPre,int endPre,int [] in, int startIn,int endIn){

        //校验输入，如果不满足条件，退出
        if (startPre>endPre || startIn > endIn )
            return null;

        TreeNode root = new TreeNode(pre[startPre]);
        for (int i= startIn;i<=endIn;i++){
            if (in[i] == pre[startPre]){ //中序遍历与前序遍历结点对比，找出根结点
                //递归调用，继续构建左右子节点的子树
                root.left = reConstructBinaryTree(pre,startPre+1,startPre+i-startIn,in,startIn,i-1);
                root.right = reConstructBinaryTree(pre,i-startIn+startPre+1,endPre,in,i+1,endIn);
            }
        }
        return root;
    }
}
