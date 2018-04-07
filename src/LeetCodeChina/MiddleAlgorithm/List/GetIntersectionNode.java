package LeetCodeChina.MiddleAlgorithm.List;

import LeetCodeChina.MiddleAlgorithm.ListNode;

public class GetIntersectionNode {

    /**
     *相交链表
     *
     * 编写一个程序，找到两个单链表相交的起始节点。
     *
     * 思路：两个链表的公共结点，也就是说这两个链表在这里交汇。
     *
     * 如果为双向链表的话，可以从后往前遍历，寻找分叉点，效率很高
     *
     * 单链表没有指向前一个结点的指针
     *
     * 首先获取到整个链表的长度，做差得到两个链表的长度差值，
     *
     * 长的链表先走 差值 步，然后两个链表同时向前走，知道两个结点不为空且相等，
     *
     * 返回该结点，即位公共结点
     *
     * 方法是最优的，其中语句可以做优化，使运算速度更快
     *
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null)
            return null;

        int longList  = listLength(headA);
        int shortList = listLength(headB);
        ListNode longListNode = headA;
        ListNode shortListNode = headB;


        int diff = longList - shortList;

        if (diff<0){
            longListNode = headB;
            shortListNode = headA;
            diff = Math.abs(diff);
        }

        while (diff>0){
            longListNode = longListNode.next;
            diff--;
        }

        while (longListNode != null && shortListNode != null && (longListNode != shortListNode)){
            longListNode = longListNode.next;
            shortListNode = shortListNode.next;
        }

        return longListNode;
    }


    private int listLength(ListNode head){
        if (head == null)
            return 0;
        int result =1;

        if (head.next == null)
            return result;

        while (head.next != null){
            result++;
            head = head.next;
        }
        return result;
    }
}
