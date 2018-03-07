package lintCode;

import java.util.List;

class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          this.val = x;
          this.next = null;}
  }

/**
 * 在原头结点之前，加上一个新的结点，然后使用head.next != null 语句判断
 * 如果不采用增加结点的方式，会出现第一个结点无法判断的方式
 */
public class RemoveLinkedListElements {
    public static ListNode removeElements(ListNode head, int val) {
        if (head == null){  //首先判断是否为空树，这个在关于树的算法中都比较重要
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
     * Given 1->2->3->3->4->5->3, val = 3,
     * you should return the list as 1->2->4->5
     * @param head
     * @param val
     * @return
     * 第一次重写，没完全写对，错误出现在没有处理好怎样在head之前加一个结点，以使用head.next;
     * 另外，对于元素next的控制也没有处理好
     */
//    public ListNode removeElements2(ListNode head, int val) {
//        // Write your code here
//        if (head == null){
//            return null;
//        }
//        ListNode dummy = new ListNode(0); //创建一个临时结点
//        dummy.next =head; //生成新的链表，其中在头结点head前加了一个新的结点0
//        head =dummy;    //重新产生一个链表，头结点为dummy
//        while (head.next !=null){
//            if (head.next.val == val){
//                head.next = head.next.next;
//            }
//            else {
//                head = head.next;
//            }
//        }
//
//        return dummy.next;
//
//    }


    /**
     * 如果增加难度。要求删除出现多次的元素，但是保留其中一个元素
     */



}
