package Mooc_zju.chapter4;

class TreeNode{
    int Data;
    TreeNode left;
    TreeNode right;
    public TreeNode(int val){
        Data = val;
    }
}

public class BinTree {
    /**
     * 插入结点
     * @param BST
     * @param x
     * @return
     */
    public TreeNode insert(TreeNode BST , int x){
        //找到结点并赋值，生成并返回
        if (BST == null){
            //需要实例化 BST
            BST = new TreeNode(x);
            //BST.Data = x;
            BST.left = BST.right = null;
        }
        else {/** 开始找要插入袁术的位置**/
            if (x<BST.Data){
                BST.left = insert(BST.left,x);/**递归插入左子树**/
            }
            else if (x>BST.Data){
                BST.right = insert(BST.right,x);/**递归插入右子树**/
            }
            /**已经存在，什么都不做**/
        }
        return BST;
    }

    /**
     * 删除二叉树中的结点
     * @param BST
     * @param x
     * @return
     */
    public TreeNode delete(TreeNode BST,int x){
        TreeNode temp;
        if (BST==null){
            System.out.println("要删除的元素未找到");
        }
        else {
            if (x<BST.Data){/**从左子树递归删除**/
                BST.left = delete(BST.left,x);
            }
            else if (x>BST.Data){/**从右子树开始删除**/
                BST.right = delete(BST.right,x);
            }/**BST就是要删除的结点**/
            else {
                /**如果被删除结点右左右两个子节点**/
                if (BST.left != null && BST.right != null){
                    /**从右子树中找最小值*/

                    // temp = findMin(BST.right);
                    // BST.Data = temp.Data;
                    BST.right = delete(BST.right,BST.Data);
                }
                else {
                    temp = BST;
                    if (BST.left != null){
                        BST = BST.right;
                    }
                    else {
                        BST = BST.left;
                    }
                }
            }
        }
        return BST;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(12);
       // root.Data=12;
        BinTree obj = new BinTree();
        obj.insert(root,15);

    }

}
