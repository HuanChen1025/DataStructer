package SwordOffer;

class RandomListNode {
    int label;
    RandomListNode next = null;
    RandomListNode random = null;

    RandomListNode(int label) {
        this.label = label;
    }
}

public class ComplexListNode {

    public RandomListNode Clone(RandomListNode pHead)
    {
        cloneNodes(pHead);
        connectSiblingNodes(pHead);

        return reconnectNodes(pHead);

    }

    /**
     * 在原链接的每个结点之后加上一个一模一样的结点
     * @param pHead
     */
    private void cloneNodes(RandomListNode pHead){
        RandomListNode pNode = pHead;
        while (pNode != null){
            RandomListNode pCloneNode = new RandomListNode(0);
            pCloneNode.label = pNode.label;
            pCloneNode.next = pNode.next;
            pCloneNode.random = null;
            pNode.next = pCloneNode;
            pNode = pCloneNode.next;
        }
    }

    /**
     * 将原链表上的子链表结点依次添加到复制结点上
     * @param pHead
     */
    private void  connectSiblingNodes(RandomListNode pHead){

        RandomListNode pNode = pHead;
        while (pNode != null){
            RandomListNode pCloned = pNode.next;    //  得到复制的结点
            if (pNode.random != null){
                pCloned.random = pNode.random.next; //将复制结点的复杂结点连接起来
            }
            pNode = pCloned.next;
        }
    }

    /**
     * 拆分结点
     * @param pHead
     * @return
     */
    private RandomListNode reconnectNodes(RandomListNode pHead){
        RandomListNode pNode = pHead;
        RandomListNode pClonedHead = null;  //头结点
        RandomListNode pClonedNode = null;  //拆分时循环的结点
        //拿到头结点
        if (pNode != null){
            pClonedHead = pClonedNode = pNode.next;
            pNode.next = pClonedNode.next;
            pNode = pNode.next;
        }
        //依次循环，拆分原链表和复制链表
        while (pNode != null){
            pClonedNode.next = pNode.next;
            pClonedNode = pClonedNode.next;
            pNode.next = pClonedNode.next;
            pNode = pNode.next;
        }

        return pClonedHead;
    }

    public static void main(String[] args) {
        RandomListNode pHead = new RandomListNode(0);
        pHead.next = new RandomListNode(1);
        pHead.random = new RandomListNode(2);
        pHead.next.next = new RandomListNode(2);
        pHead.next.next.next = new RandomListNode(3);
        ComplexListNode complexListNode = new ComplexListNode();
        complexListNode.Clone(pHead);
    }
}
