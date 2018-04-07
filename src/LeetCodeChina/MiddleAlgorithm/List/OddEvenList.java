package LeetCodeChina.MiddleAlgorithm.List;

import LeetCodeChina.MiddleAlgorithm.ListNode;

/**
 * Odd Even Linked List
 *
 * Given a singly linked list, group all odd nodes together followed by the even nodes.
 * Please note here we are talking about the node number and not the value in the nodes.
 * You should try to do it in place. The program should run in O(1) space complexity and O(nodes) time complexity.
 */
public class OddEvenList {

    /**
     * 将奇数结点和偶数结点分开
     *
     * 采用两个指针,奇偶交替，最后合并
     *
     * 采用O（n）的空间复杂度和O(nodes)的时间复杂度
     * @param head
     * @return
     */
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode even = head.next;
        ListNode evenNext = even;
        ListNode oddNext =head;

        while (evenNext != null){
            oddNext.next = evenNext.next;
            if (oddNext.next != null){
                oddNext = oddNext.next;
                evenNext.next = oddNext.next;
                evenNext = evenNext.next;
            }else {
                break;
            }

        }
        oddNext.next = even;
        return head;
    }
}
