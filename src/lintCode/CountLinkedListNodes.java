package lintCode;


public class CountLinkedListNodes {
    /**
     * @param head: the first node of linked list.
     * @return: An integer
     * Given 1->3->5, return 3.
     * 算法时间复杂度为O（n),空间复杂度为O（1）
     */
    public int countNodes(ListNode head) {
        // write your code here
        if (head == null) {
            return 0;
        }
        int nums = 1;
        while (head.next != null) {
            nums++; //计数器加1
            head = head.next; //指针指向下一个
        }

        return nums;
    }

    /**
     * 相比与前一种方法，该方法占用的空间更多一些
     * @param head
     * @return
     */
    public int countNodes_01(ListNode head) {
        // write your code here
        if (head == null){
            return 0;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        head =dummy; //在原链表之前增加一个结点，然后判断head.next是否为null
        int n =0;
        while (head.next != null){
            n++;
            head = head.next;
        }
        return n;
    }

}

