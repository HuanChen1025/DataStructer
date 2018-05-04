package LeetCodeChina.Tree;

public class _100SameTree {
    /**
     * 可以采用递归求解
     * @param p
     * @param q
     * @return
     */
    public boolean isSameTree_01(TreeNode p, TreeNode q) {
        if (p == null && q == null)
            return true;
        if (p == null || q == null || p.val != q.val)
            return false;

        //如果父节点的值相等，需要对子结点的结果求与，才是最后的返回结果
        return isSameTree_01(p.left,q.left) && isSameTree_01(p.right,q.right);
    }

}
