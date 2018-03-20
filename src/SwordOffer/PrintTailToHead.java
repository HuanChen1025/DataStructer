package SwordOffer;


import java.util.ArrayList;
import java.util.Stack;

public class PrintTailToHead {

    public static  void printTailToHead(ListNode listNode){
        Stack<ListNode> nodes = new Stack<>();
        while (listNode != null){
            nodes.push(listNode);
            listNode = listNode.next;
        }
        while (! nodes.empty()){
            listNode = nodes.pop();
            System.out.println(listNode.val);

        }

    }

    /**
     * 典型的先进后出，采用堆栈来存储顺序遍历链表的结果，再依次弹出
     * 采用堆栈的方式实现
     * @param listNode
     * @return
     */
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        Stack<ListNode> nodes = new Stack<>();
        ArrayList<Integer> arrayList = new ArrayList<>();
        while (listNode != null){
            nodes.push(listNode);
            listNode = listNode.next;
        }
        while (! nodes.empty()){
            listNode = nodes.pop();
            arrayList.add(listNode.val);
        }
        return arrayList;
    }

    /**
     * 采用递归的方式实现
     * 每次打印的时候，先打印后一个结点的值，
     * 最后输出形式为从尾到头输出
     * 有错误，AC 不通过
     * @param listNode
     * @return
     */
    public ArrayList<Integer> printListFromTailToHead_01(ListNode listNode){
        ArrayList<Integer> arrayList = new ArrayList<>();
        if (listNode != null){
            if (listNode.next != null){
                printListFromTailToHead_01(listNode.next);
            }
            arrayList.add(listNode.val);
        }

        return arrayList;
    }


}
