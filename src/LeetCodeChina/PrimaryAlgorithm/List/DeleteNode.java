package LeetCodeChina.PrimaryAlgorithm.List;


/**
 *  删除链表的结点
 *
 *  编写一个函数，在给定单链表一个结点(非尾结点)的情况下，删除该结点。
 *
 * 假设该链表为1 -> 2 -> 3 -> 4 并且给定你链表中第三个值为3的节点，在调用你的函数后，该链表应变为1 -> 2 -> 4。
 */
public class DeleteNode {

    /**
     * 在给定单链表一个结点(非尾结点)的情况下，删除该结点
     * @param node
     */
    public void deleteNode_01(ListNode node) {
        if (node != null && node.next != null){
           node.val = node.next.val;
           node.next = node.next.next;
        }


    }
}
