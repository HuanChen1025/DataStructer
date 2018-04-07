package LeetCodeChina.MiddleAlgorithm.List;

import LeetCodeChina.MiddleAlgorithm.ListNode;

public class AddTwoNumbers {

    /**
     * https://blog.csdn.net/weixin_38385524/article/details/79520460
     * 声明新链表及其指针和进位，设定循环，每轮的总求和为两链表指针当前位置的数字之和再加上一轮的进位，
     * 计算当前结果值为总求和的个位，进位值为其十位，直到两个链表均为空
     *
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null)
            return l1==null?l2:l1;

        ListNode list1 = l1;
        ListNode list2 = l2;

        ListNode result = new ListNode(0);

        ListNode head = result;

        int add =0; //add表示进位
        while (true){
            int sum  = list1.val + list2.val + add;

            head.val = sum%10;  //当前结点值

            add = sum/10;   //进位

            //两链表均为空，如果 add 不为0，在末尾加上add，否则break
            if (list1.next == null && list2.next == null){
                if (add != 0){
                    head.next = new ListNode(add);
                }
                break;
            }
            //以下情况为 链表中其中一个不为0，或者两个都不为零
            if (list1.next == null)
                list1.next = new ListNode(0);

            if (list2.next == null)
                list2.next = new ListNode(0);

            list1 = list1.next;

            list2 = list2.next;

            head.next = new ListNode(0);

            head = head.next;

        }
            return result;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        ListNode l2 = new ListNode(8);

        AddTwoNumbers addTwoNumbers = new AddTwoNumbers();

        System.out.println(addTwoNumbers.addTwoNumbers(l1,l2));


    }
}
