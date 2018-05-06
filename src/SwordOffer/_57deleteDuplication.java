package SwordOffer;

/**
 * 在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留，返回链表头指针。
 */
public class _57deleteDuplication {
    public ListNode deleteDuplication(ListNode pHead)
    {
        if(pHead == null || pHead.next == null)
            return pHead;
        ListNode head = pHead;
        ListNode first = new ListNode(-1);//设置一个trick
        first.next = pHead;
        ListNode last = first;


        while(head != null && head.next != null){
            if(head.val == head.next.val){
                int val = head.val;
                while (head!= null && head.val == val)
                    head = head.next;
                last.next = head;
            }
            else{
                last = head;
                head = head.next;
            }
        }


        return first.next;
    }
}
