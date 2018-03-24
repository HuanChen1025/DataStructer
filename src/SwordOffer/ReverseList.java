package SwordOffer;

import Mooc_zju.linearList.Stack;

public class ReverseList {

    /**
     * 反转链表
     * 采用堆栈实现
     * 效率低下，换方法，采用多个指针
     * @param head
     * @return
     */
    public ListNode ReverseList(ListNode head) {
        if (head == null){
            return null;
        }
        ListNode resultNode = new ListNode(0);
        ListNode pHead = resultNode;
        java.util.Stack<Integer> stack = new java.util.Stack<>();
        // 将原链表的值入栈
        while (head != null){
           stack.push(head.val);
           head = head.next;
        }

        while (stack != null){
            pHead.val = stack.pop();
            pHead = pHead.next;
        }
        return resultNode.next;
    }

    public ListNode ReverseList_1(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode p = head.next;

        head.next = null;

        ListNode last = null;

        while (p.next != null){
            last  = p.next; //
            p.next = head;
            head = p;
            p = last;
        }
        p.next = head;
        head = p;
        return head;
    }
}
