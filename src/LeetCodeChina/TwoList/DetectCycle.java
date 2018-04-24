package LeetCodeChina.TwoList;

import java.util.HashSet;

/**
 *142. 环形链表 II
 */
public class DetectCycle {
    /**
     * 采用 hashset
     * @param head
     * @return
     */
    public ListNode detectCycle_01(ListNode head) {
        if (head == null || head.next ==null){
            return null;
        }

        HashSet<ListNode> set = new HashSet<>();

        while (head!=null){

            if (set.contains(head)){
                return head;
            }
            else {
                set.add(head);
                head = head.next;
            }
        }

        return null;
    }

    /**
     * 采用更加优化的算法
     *
     * 当找到环中相遇点时，将 慢指针拉回到起点，快指针不动，
     * 并且两者都再次单步走，直到相遇，则为链表的起点
     *
     * 但是其中的分析思路并不懂
     *
     *
     * @param head
     * @return
     */
    public ListNode detectCycle_02(ListNode head) {
        if (head == null || head.next ==null)
            return null;

        ListNode slowIndex = head;
        ListNode fastIndex = head;

        while (fastIndex != null && fastIndex.next != null){
            slowIndex =slowIndex.next;
            fastIndex =fastIndex.next.next;

            if (slowIndex == fastIndex){
                slowIndex = head;

                while (slowIndex != fastIndex){
                    slowIndex = slowIndex.next;
                    fastIndex =fastIndex.next;
                }
                return slowIndex;
            }
        }
        return null;
    }

    }
