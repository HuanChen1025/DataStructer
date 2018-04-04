package LeetCodeChina.PrimaryAlgorithm.List;

import java.util.Stack;

/**
 * 反转链表
 *
 * 反转一个单链表。
 * 进阶:
 * 链表可以迭代或递归地反转。你能否两个都实现一遍？
 */
public class ReverseList {

    /**
     * 原地翻转，将指针指向前一个
     * @param head
     * @return
     */
    public ListNode reverseList_01(ListNode head) {



        return null;
    }


    /**
     * 顺序遍历采用堆栈存储，依次弹出并替换
     *
     * 时间效率太差，需要考虑第一个方法：原地翻转指针
     * @param head
     * @return
     */
    public ListNode reverseList_02(ListNode head) {
        if (head == null)
            return head;
        Stack<Integer> stack = new Stack<>();

        ListNode myHeaad = new ListNode(0);
        myHeaad.next = head;

        ListNode first = myHeaad;
        ListNode second = myHeaad;


        while (first.next != null){
            stack.push(first.next.val);
            first = first.next;
        }

        while (second.next != null){
            second.next.val = stack.pop();
            second =second.next;
        }
        return myHeaad.next;
    }

    }
