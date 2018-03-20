package SwordOffer;
class ListNode {
    int val;
    ListNode next;
    ListNode(int x){
        this.val = x;
        this.next = null;
    }
}

/**
 * 查找链表中第 K 个数，两个指针，第一个指针到第 K-1 个时，第二个指针开始，如果第一个指针到尾时，第二个指针即指向了第 K 个
 */
public class FindKthToTail {
    public static void main(String[] args) {

    }

    /**
     * 查找链表中倒数第 K 个数.程序有缺陷
     * @param listNode
     * @param K
     * @return
     */
    public ListNode findKthToTail(ListNode listNode,int K){
        if (listNode == null){
            return null;
        }

        ListNode pHead = listNode;  //头指针
        ListNode pBehind = null;    //尾指针，用于指向第 K 个数

       for (int i =0;i<K-1 ;i++){
           if (pHead.next != null){
               pHead = pHead.next;
           }
           else {
               return null; //如果链表长度本身不足 K 个，输出 null
           }
       }

       pBehind = listNode;
       while (pHead != null){
           pBehind = pBehind.next;
           pHead = pHead.next;
       }

        return pBehind;
    }

}
