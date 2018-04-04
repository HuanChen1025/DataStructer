package LeetCodeChina.PrimaryAlgorithm.List;

/**
 * 删除链表的倒数第N个节点
 *
 * 给定一个链表，删除链表的倒数第 n 个节点并返回头结点。
 *
 *  给定一个链表: 1->2->3->4->5, 并且 n = 2.

 * 当删除了倒数第二个节点后链表变成了 1->2->3->5.
 *
 * 说明：
 * 1）给的 n 始终是有效的。
 * 2）尝试一次遍历实现。
 */
public class RemoveNthFromEnd {

    /**
     * 两个指针，一个先走 n 步，另外一个再走，当 第快指针走到 终点时，慢指针正好指到倒数第 n 个
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null)
            return head;

        //创建一个临时链表
        ListNode myHead = new ListNode(0);
        myHead.next = head;
        ListNode p = myHead;
        ListNode q = myHead;

        // p 先走 n 步
        while (n>0){
            p = p.next;
            n--;
        }
        // p 、q 指针同时走
        while (p.next != null){
            p = p.next;
            q = q.next;
        }
        q.next = q.next.next;

        return myHead.next;
    }

    public static void main(String[] args) {
        RemoveNthFromEnd removeNthFromEnd = new RemoveNthFromEnd();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        removeNthFromEnd.removeNthFromEnd(head,1);


    }


}
