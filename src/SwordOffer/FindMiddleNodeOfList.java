package SwordOffer;

/**
 * 寻找单链表的中间结点
 */
public class FindMiddleNodeOfList {

    /**
     * 查找单链表中间结点，定义两个指针
     * 第一个指针一次走两步，第二个指针一次走一步
     * 当第一个指针走不动了，那么第二个指针指向的就是中间结点
     * @param listNode
     * @return
     */
    public static int findMiddleNodeOfList(ListNode listNode){
        //如果头结点为空，或者只有一个结点，那么返回第一个结点
        if (listNode == null || listNode.next == null){
            return listNode.val;
        }
        ListNode pLittleHead = listNode;
        ListNode pBigHead = listNode;
        //如果链表的下两个结点不为空，执行 while 循环
        while (pBigHead.next.next != null){
            pBigHead = pBigHead.next.next;
            pLittleHead = pLittleHead.next;
        }
        return pLittleHead.val;
    }

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(0);
        listNode1.next = new ListNode(3);
        //listNode1.next.next = new ListNode(4);
        System.out.println(findMiddleNodeOfList(listNode1));

    }
}
