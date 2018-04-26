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

    /**
     * 原地翻转，空间复杂度为O(1)
     *
     * 改变链表的指向
     *
     * @param head
     * @return
     */
    public ListNode ReverseList_1(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode reverseHead = null;
        ListNode pNode = head;
        ListNode pPrev = null;

        while (pNode != null){
            ListNode pNext = pNode.next;

            //如果链表遍历结束，将 pNode 赋值给 reverseHead
            if (pNext == null)
                reverseHead = pNode;

            pNode.next = pPrev;

            pPrev =pNode;
            pNode =pNext;
        }

        return reverseHead;
    }

    public static void main(String[] args) {
        ListNode root = new ListNode(1);
        root.next = new ListNode(2);
        root.next.next = new ListNode(3);
        ReverseList obj = new ReverseList();
        obj.ReverseList_1(root);
    }
}
