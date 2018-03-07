package lintCode;

public class Partition_List {
    /**
     * 不懂！！！！！！！！！！
     * @param head: The first node of linked list
     * @param x: An integer
     * @return: A ListNode
     * http://blog.csdn.net/ljiabin/article/details/41891555
     * http://blog.csdn.net/DERRANTCM/article/details/47290703
     * 创建两个链表a，b，将原来链表中的每个结点，小于等于x的结点放在a链表的末尾，如果是大于就放在b的末尾，最后将b的头结点接到a末尾。
     */
    public ListNode partition(ListNode head, int x) {
        // write your code here
        ListNode le = new ListNode(0); //小于x的链表
        ListNode ge = new ListNode(0);//大于x 的链表
        ListNode t1 = le;
        ListNode t2 = ge;
        ListNode p = head;  //头结点
        while (p != null){
            if (p.val < x){
                t1.next = p;
                t1 = p;
            }
            else {     //大于等于 x 的值放到另外一个链表
                t2.next = p;
                t2 = p;
            }
            p = p.next; //指针指向下一个
        }
        t2.next = null; //指定后面一个指针的末尾为null

        //此处说明小于的链表上有数据
        if (t1 != le){
            t1.next = ge.next; //将t2 的头结点接到t1的末尾
            head = le.next;
        } else {
            head = ge.next;
        }


        return head;
    }
}
