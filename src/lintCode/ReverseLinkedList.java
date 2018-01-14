package lintCode;

public class ReverseLinkedList {
    /*
     * @param head: n
     * @return: The new head of reversed linked list.
     *
     * 对于这道题中的逻辑，还是没有思考明白
     */
    public ListNode reverse(ListNode head) {
        // write your code here
        ListNode prev =null;
        while (head != null){
            ListNode temp = head.next; //保存当前结点的下一个到temp
            head.next = prev; //为反转链表做准备，
            prev =head; //将当前头结点赋值给prev
            head =temp;//将下一个结点（temp）赋值为头
        }
        return prev;
    }
}
