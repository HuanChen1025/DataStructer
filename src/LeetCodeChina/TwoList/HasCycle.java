package LeetCodeChina.TwoList;

import java.util.HashSet;

public class HasCycle {
    /**
     * 方法一：采用 hashset
     * @param head
     * @return
     */
    public boolean hasCycle_01(ListNode head) {
        if(head == null)
            return false;

        HashSet<ListNode> set = new HashSet<>();

        while (head!=null){

            if (set.contains(head)){
                return true;
            }
            else {
                set.add(head);
                head = head.next;
            }
        }
        return false;
    }

    /**
     * 采用快慢指针
     * @param head
     * @return
     */
    public boolean hasCycle_02(ListNode head) {
        if(head == null)
            return false;

        ListNode slowIndex = head;  //一次走一步
        ListNode fastIndex =head;   //一次走两步

        while (fastIndex!= null && fastIndex.next !=null){
            slowIndex = slowIndex.next;
            fastIndex =fastIndex.next.next; //如果当前节点数不足的话，最终会指向 null

            if (slowIndex == fastIndex){
                return true;
            }
        }
        return false;
    }

}

