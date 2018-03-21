package SwordOffer;

import Mooc_zju.linearList.Stack;

public class ReverseList {

    /**
     * 反转链表
     * 采用堆栈实现
     * @param head
     * @return
     */
    public ListNode ReverseList(ListNode head) {
        if (head == null){
            return null;
        }
        java.util.Stack<Integer> stack = new java.util.Stack<>();
        while (head != null){
           stack.push(head.val);
           head = head.next;
        }

        ListNode pHead = new ListNode(0);
        ListNode temp = new ListNode(0);
        temp = pHead;

        while (stack != null){
            temp.val = stack.pop();
            temp = temp.next;
        }
        return pHead.next;
    }
}
