package lintCode;

public class Remove_Nth_Node_From_End_of_List {
    /**
     * @param head: The first node of linked list.
     * @param n: An integer
     * @return: The head of linked list.
     * Given linked list: 1->2->3->4->5->null, and n = 2.
     * After removing the second node from the end, the linked list becomes 1->2->3->5->null
     * 从末尾开始删除
     */
    public ListNode removeNthFromEnd_0(ListNode head, int n) {
        // write your code here
        int length =0;
        ListNode current = head;
        while (current != null){
            length++;
            current = current.next;
        }
        current = head;
        int count =0;
        while (current != null){
            if (count == length-n){
                current = current.next.next;
                break;
            }
            current = current.next;
            count++;
        }
        return head;
    }

    /**
     * 首先计算出链表的长度，然后将指针移动到 first-n 位置，跳过first-n+1,得到最后的链表
     * ???: 为什么要使用dummy
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd_1(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        int length = 0;
        ListNode first = head;
        //计算链表的长度
        while (first != null){
            length++;
            first = first.next;
        }
        //执行完while循环后，first 为 null
        length -= n;
        first = dummy;
        while (length > 0){
            length--;
            first = first.next;//将指针移动到 first - n 位置
        }
        first.next =first.next.next;    //跳过需要移除的结点
        return dummy.next;
    }

}





















