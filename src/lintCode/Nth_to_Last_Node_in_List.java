package lintCode;

public class Nth_to_Last_Node_in_List {
    /**
     * @param head: The first node of linked list.
     * @param n: An integer
     * @return: Nth to last node of a singly linked list.
     * 与 Remove_Nth_Node_From_End_of_List 的方法基本类似
     */
    public ListNode nthToLast(ListNode head, int n) {
        // write your code here
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        int length = 0;
        ListNode first = head;
        while (first != null){
            length++;
            first = first.next;
        }
        length -= n;
        first = dummy;
        while (length>0){
            length--;
            first = first.next;
        }
        return first.next;
    }
}
