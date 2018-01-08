package lintCode;

import java.util.List;

class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }

/**
 * 在原头结点之前，加上一个新的结点，然后使用head.next != null 语句判断
 * 如果不采用增加结点的方式，会出现第一个结点无法判断的方式
 */
public class RemoveLinkedListElements {
    public static ListNode removeElements(ListNode head, int val) {
        if (head == null){
            return null;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        head = dummy; //在原head 之前增加一个结点
        while (head.next != null){
            if (head.next.val == val){
                head.next = head.next.next;
            }else {
                head = head.next;
            }
        }
        return dummy.next; //除去第一个结点的结点
    }

    /**
     * 增加难度。要求删除出现多次的元素，但是保留其中一个元素
     */



}
