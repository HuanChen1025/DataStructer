
## LeetCode and  lintcode Record
## 1. learn leetcode 
记录在LintCode 刷过的题。本身比较菜，好多稍难一点的题，要想很久才能想出来，方法不一定是最优的

## 2. 面试题
记录刷过的面试，笔试题
<!-- MarkdownTOC -->

- [leetcode](#leetcode)
- [328.Odd Even Linked List](#328odd-even-linked-list)

<!-- /MarkdownTOC -->

<a id="leetcode"></a>
## leetcode



<a id="328odd-even-linked-list"></a>
## 328.Odd Even Linked List

----------


### 问题：


> Given a singly linked list, group all odd nodes together followed by the even nodes. Please note here we are > talking about the node number and not the value in the nodes.

> You should try to do it in place. The program should run in O(1) space complexity and O(nodes) time complexity.

>Example:

>Given 1->2->3->4->5->NULL,

>return 1->3->5->2->4->NULL.

>Note:
The relative order inside both the even and odd groups should remain as it was in the input. 
The first node is considered odd, the second node even and so on ...


### 思路:

最直观的思路是采用采用新链表就可以完成，但本题要求是在 O(1) 的空间复杂度完成。

使用两个头结点，一个指向奇数，一个指向偶数，遍历链表，奇数位置的记录在奇数结点后面，偶数位置的记录在偶数位置后面，交替记录，使用的还是原来的链表存储元素，只是NEXT 指针方向改变。遍历完成后有奇偶两条链表，将偶数添加到奇数后面即可。


 ### 代码(java)：

``` java
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode oddEvenList(ListNode head) {
                if (head == null || head.next == null)
            return head;

        ListNode even = head.next;
        ListNode evenNext = even;
        ListNode oddNext =head;

        while (evenNext != null){
            oddNext.next = evenNext.next;
            if (oddNext.next != null){
                oddNext = oddNext.next;
                evenNext.next = oddNext.next;
                evenNext = evenNext.next;
            }else {
                break;
            }

        }
        oddNext.next = even;
        return head;
    }
}
```



