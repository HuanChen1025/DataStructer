package LeetCodeChina.List;

public class _24_SwapNodesinPairs {
    /**
     * 链表题目，每两个交换位置，不足的不改变，常量空间
     * 注意：交换的是链表结点中的值，而不是要依次翻转链表
     * @param head
     * @return
     */
    public static ListNode swapPairs(ListNode head) {
        //校验输入
        if (head == null || head.next == null){
            return head;
        }
        ListNode newHead = new ListNode(0);
        newHead.next = head;
        while (newHead.next != null && newHead.next.next!= null){
            int temp = newHead.next.val;
            newHead.next.val = newHead.next.next.val;
            newHead.next.next.val = temp;
            //指向下一个的下一个
            newHead = newHead.next.next;
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode root = new ListNode(1);
        root.next = new ListNode(2);
        root.next.next = new ListNode(3);
        root.next.next.next = new ListNode(4);
        swapPairs(root);
    }
}
