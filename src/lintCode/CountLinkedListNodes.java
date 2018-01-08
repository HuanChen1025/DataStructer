package lintCode;


public class CountLinkedListNodes {
    /*
     * @param head: the first node of linked list.
     * @return: An integer
     * Given 1->3->5, return 3.
     */
    public int countNodes(ListNode head) {
        // write your code here
        if (head == null){
            return 0;
        }
        int nums = 1;
        while (head.next != null){
            nums++; //计数器加1
            head = head.next; //指针指向下一个
        }

        return nums;
    }
}

/**
 * 算法时间复杂度为O（n),空间复杂度为O（1）
 */