package lintCode;

public class MergeTwoSortedLists {
    /**
     * @param l1: ListNode l1 is the head of the linked list
     * @param l2: ListNode l2 is the head of the linked list
     * @return: ListNode head of linked list
     *
     * 采用比较两个链表中元素大小的方式，
     * 谁的元素小就先存谁，放到一个第三方链表中
     *
     */
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // write your code here
        if (l1 == null || l2 == null){
            return l1 == null ? l2 : l1; //如果其中一个为null，则返回另外一个
        }
        //1->3->8->11->15->null
        //2->null
        // 对于上面的例子，有一点不太理解，当l2元素没有了，指向了null后，while 循环不是应该停止了吗
        //1) 首先应该明白这个是链表不是数组，链表中的元素与元素之间是有关联的
        //2) 当l2为null while 退出，但是node.next = l1; 这句话仍然会将这个节点后的元素一起带走
        final ListNode head = new ListNode(0);
        ListNode node = head;
        while (l1 != null && l2 != null){
            if (l1.val > l2.val){
               node.next = l2;
               l2 = l2.next;
            }
            else {
                node.next = l1;
                l1 = l1.next;
            }
            node = node.next;
        }
        //遍历比较完毕，剩下最后一个结点
        if (l1 != null){
            node.next = l1;
        } else if (l2 != null){
            node.next = l2;
        }

        return head.next;   //第一个结点为0，不算
        }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(3);
        l1.next.next = new ListNode(8);
        ListNode l2 = new ListNode(2);
        mergeTwoLists(l1,l2);

    }
}
