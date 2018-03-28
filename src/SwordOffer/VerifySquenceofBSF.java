package SwordOffer;

import java.util.Arrays;

public class VerifySquenceofBSF {

    /**
     * 后序遍历为左右根，序列中的最后一个元素为根结点
     * @param sequence
     * @param length
     * @return
     */
    public  boolean verifySquenceofBSF(int sequence[],int length){
        if (sequence == null || length <= 0)
            return false;
        int root = sequence[length-1];

        //左子树的结点小于根结点
        int i =0;
        for (;i<length-1;++i){
            //小于根结点之前的结点都是左子树的
            if (sequence[i]>root)
                break;
        }

        //右子树的结点小于根节点
        int j =i;
        for (;j<length-1;++j){
            if (sequence[j]<root)
                return false;
        }

        //判断左子树是不是搜索二叉树
        boolean left = true;
        if (i>0){
            left = verifySquenceofBSF(sequence,i);
        }
        //判断右子树是否是搜索二叉树
        boolean right = true;
        if (i<length-1){
            int[] newSequence = Arrays.copyOfRange(sequence,i,length-i-1);
            right = verifySquenceofBSF(newSequence,length-i-1);
        }

        return true && false;
    }
}
