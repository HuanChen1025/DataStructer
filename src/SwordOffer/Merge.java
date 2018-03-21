package SwordOffer;

public class Merge {

    /**
     * 输入两个单调递增的链表，输出两个链表合成后的链表，
     * 当然我们需要合成后的链表满足单调不减规则。
     * @param list1
     * @param list2
     * @return
     */
    public ListNode Merge(ListNode list1,ListNode list2) {
        if (list1 == null && list2 != null){
                return list2;
        }   if (list1 != null && list2 == null){
                return list1;
        }
        if (list1 == null && list2 == null){
            return null;
        }
        ListNode resultNode = new ListNode(0);  //需要返回的结点，返回为resultNode.next
        ListNode pHead =resultNode;         //用于在循环过程中使用的指针头，这个pHead 指针会指向链表的最大一个元素

        while (list1 !=null && list2 != null){
            if (list1.val > list2.val){
                pHead.next = list2;
                list2 = list2.next;
            }else {
                pHead.next = list1;
                list1 = list1.next;
            }
            pHead = pHead.next;
        }
        if (list1 != null){
            pHead.next = list1;
        }if (list2 != null){
            pHead.next = list2;
        }

        return resultNode.next;
    }
}
