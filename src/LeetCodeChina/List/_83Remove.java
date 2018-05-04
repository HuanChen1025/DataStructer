package LeetCodeChina.List;

   class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }

public class _83Remove {
    public static ListNode deleteDuplicates_01(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode pHead = head;

        while (pHead.next != null){
            //此处的处理逻辑有问题
            if (pHead.val == pHead.next.val){
              ListNode temp = pHead.next.next;
              pHead.next = temp;
            }
            else {
                pHead = pHead.next;
            }

        }
        return head;
    }

    /**
     * 采用递归，3行即可解决问题
     * 可以AC，但是本地调试的时候有问题
     * @param head
     * @return
     */
    public  ListNode deleteDuplicates_02(ListNode head) {
        if (head == null || head.next == null) return head;
        head.next = deleteDuplicates_02(head.next);
        return head.val == head.next.val?head.next:head;
    }

    public static void main(String[] args) {
        ListNode root = new ListNode(1);
        root.next = new ListNode(1);
        root.next.next = new ListNode(2);
        _83Remove obj = new _83Remove();
        System.out.println(obj.deleteDuplicates_02(root));
        System.out.println();
    }
}
