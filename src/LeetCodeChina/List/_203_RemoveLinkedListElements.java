package LeetCodeChina.List;

/**
 * Remove all elements from a linked list of integers that have value val.
 */
public class _203_RemoveLinkedListElements {
    /**
     * O(N) 算法，从前向后遍历
     * @param head
     * @param val
     * @return
     */
    public static ListNode removeElements_01(ListNode head, int val) {
        if (head == null)
            return null;

        ListNode helper = new ListNode(0);
        helper.next  = head;

        ListNode pHead =  helper;

        while (pHead.next != null){
            //此处的逻辑有待修改
            if (pHead.next.val == val){//如果相等，需要跳过这个
                pHead.next = pHead.next.next;
            }
            else {
                pHead = pHead.next;
            }

        }
        return helper.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(6);
        head.next = new ListNode(2);
        head.next.next = new ListNode(6);
        head.next.next = new ListNode(6);
        head.next.next.next = new ListNode(5);

        ListNode res =removeElements_01(head,6);

        System.out.println(removeElements_01(head,6));
        System.out.println();

    }
}
