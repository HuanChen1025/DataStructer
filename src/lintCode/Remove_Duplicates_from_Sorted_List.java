package lintCode;

public class Remove_Duplicates_from_Sorted_List {
    /**
     * @param head: head is the head of the linked list
     * @return: head of linked list
     * Given a sorted linked list, delete all duplicates such that each element appear only once.
     */
    public ListNode deleteDuplicates(ListNode head) {
        // write your code here
        ListNode current = head;
        while (current != null && current.next != null){
            if (current.val == current.next.val){
                //如果值相等，将第二个替换掉
                current.next = current.next.next;
            }else {
                //否则将当前的指针移到下一个
                current = current.next;
            }


        }
        return head;
    }
}
