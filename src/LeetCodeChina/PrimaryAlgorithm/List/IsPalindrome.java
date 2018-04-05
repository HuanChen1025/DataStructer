package LeetCodeChina.PrimaryAlgorithm.List;


import java.util.ArrayDeque;
import java.util.Stack;

/**
 * 回文链表
 *
 * 请检查一个链表是否为回文链表。

 * 进阶：
 * 你能在 O(n) 的时间和 O(1) 的额外空间中做到吗？
 */
public class IsPalindrome {

    /**
     *采用栈实现
     * 从中间开始遍历，是否与前面的元素都相等
     *
     * @param head
     * @return
     */
    public boolean isPalindrome_01(ListNode head) {
        //校验输入，此处为空是true 还是 false 都要沟通清楚
        if (head == null)
            return true;


        ListNode p = head;
        ListNode q = head;

        ArrayDeque<Integer> stack = new ArrayDeque<>();

        while (q!= null && q.next!=null){
            stack.push(p.val);
            p = p.next;
            q = q.next.next;
        }

        //当链表元素为奇数个时,慢指针指向下一个，也即是正中间元素
        if (q !=null){
            p =p.next;
        }

        //比较链表后一半元素与栈中元素
        while (stack.size() != 0 && p != null) {
            if (p.val != stack.pop()) {
                return false;
            }
            p = p.next;
        }
        return true;
    }

    /**
     * 还有更好的办法实现这道题，
     * 避免使用额外空间
     * @param head
     * @return
     */
    public boolean isPalindrome_02(ListNode head) {


        return false;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next = new ListNode(3);
        IsPalindrome isPalindrome = new IsPalindrome();
        System.out.println(isPalindrome.isPalindrome_01(head));

    }
}
