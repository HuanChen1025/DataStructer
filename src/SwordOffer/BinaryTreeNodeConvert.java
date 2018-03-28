package SwordOffer;

public class BinaryTreeNodeConvert {

    public  TreeNode binaryTreeNodeConvert(TreeNode pRootOfTree){
        TreeNode pLastNodeInList = ConvertNode(pRootOfTree,null);
        //返回头结点
        TreeNode pHeadOfList = pLastNodeInList;
        while (pHeadOfList != null && pHeadOfList.left!= null){
            pHeadOfList = pHeadOfList.left;
        }
        return pHeadOfList;
    }

    private TreeNode ConvertNode(TreeNode pNode,TreeNode pLastNodeInList){
        if (pNode == null)
            return null;

        TreeNode pCurrent = pNode;

        if (pCurrent.left != null)
            pLastNodeInList =  ConvertNode(pCurrent.left,pLastNodeInList);

        pCurrent.left = pLastNodeInList;
        if (pLastNodeInList != null)
            pLastNodeInList.right = pCurrent;

        pLastNodeInList = pCurrent;

        if (pCurrent.right != null)
            pLastNodeInList = ConvertNode(pCurrent.right,pLastNodeInList);

        return pLastNodeInList;
    }

    public static void main(String[] args) {
        BinaryTreeNodeConvert tree = new BinaryTreeNodeConvert();
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(6);
        root.right = new TreeNode(14);
        tree.binaryTreeNodeConvert(root);


    }

}
