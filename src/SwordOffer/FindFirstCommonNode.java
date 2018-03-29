package SwordOffer;

public class FindFirstCommonNode {

    public ListNode findFirstCommonNode(ListNode pHead1,ListNode pHead2){
        //判断输入是否为空
        if (pHead1 == null || pHead2 == null)
            return null;

        //获取两个链表的长度
       final int  nLength1 = getListNodeLength(pHead1);
       final int  nLength2 = getListNodeLength(pHead2);

       //找出较长的链表
       int nLengthDif = nLength1 - nLength2;
       ListNode nListNodeLong = pHead1;
       ListNode nListNodeShort = pHead2;
       if (nLength2>nLength1){
           nLengthDif = nLength2 - nLength1;
            nListNodeLong = pHead2;
            nListNodeShort = pHead1;
       }

       //较长的链表先走 nLengthDif 步
       while (nLengthDif>0){
           nListNodeLong = nListNodeLong.next;
           nLengthDif--;
       }

       //找出第一个相同的结点
       while ((nListNodeLong!=null)&&(nListNodeShort!=null)&&(nListNodeLong!=nListNodeShort)){
           nListNodeLong = nListNodeLong.next;
           nListNodeShort = nListNodeShort.next;
       }

       //返回resultNode，结果
       ListNode resultNode = nListNodeLong;
        return resultNode;
    }

    /**
     * 获取链表的长度
     * @param listNode
     * @return
     */
    private int getListNodeLength(ListNode listNode){
        if (listNode == null)
            return 0;
        int length = 0;
        while (listNode != null){
            length++;
            listNode = listNode.next;
        }
        return length;
    }

    public static void main(String[] args) {
        //构造两个具有公共结点的代码
        ListNode pHead1 = new ListNode(0);
        pHead1.next = new ListNode(1);
        pHead1.next.next = new ListNode(2);
        pHead1.next.next.next = new ListNode(4);
        ListNode pHead2= new ListNode(0);
        pHead2.next = new ListNode(3);
        pHead2.next.next =pHead1.next.next;

        FindFirstCommonNode findFirstCommonNode = new FindFirstCommonNode();

        ListNode result =  findFirstCommonNode.findFirstCommonNode(pHead1,pHead2);

        System.out.println(result.val);


    }

}
