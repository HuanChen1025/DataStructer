package SwordOffer;

public class DeleteListNode {


    /**
     * O(1) 时间删除结点
     * @param pListHead
     * @param pToBeDeleted
     */
    public static void deleteListNode(ListNode pListHead,ListNode pToBeDeleted){
        if (pListHead == null || pToBeDeleted ==null)
            return;

        if (pToBeDeleted.next != null){ //待删除结点后存在结点
            ListNode temp = pToBeDeleted.next;
            pToBeDeleted = temp;
            pToBeDeleted.next = temp.next;

        }else if (pListHead == pToBeDeleted){   //链表中只有一个结点
            pListHead = null;
            pToBeDeleted = null;
        }
        else {      //删除结点为尾节点
            ListNode pNode = pListHead;
            while (pNode.next != pToBeDeleted){
                pNode = pNode.next;
            }
            pNode.next = null;
            pToBeDeleted = null;

        }
    }

    public static void main(String[] args) {
        ListNode head1 = new ListNode(0);


    }


}
