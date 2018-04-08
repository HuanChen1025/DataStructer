
## leetcode-china 
本部分为 leetcode  china 的 中级链表部分

## 目录
<!-- MarkdownTOC -->

- [leetcode](#leetcode)
- [2.两数相加](#2%E4%B8%A4%E6%95%B0%E7%9B%B8%E5%8A%A0)
- [328.Odd Even Linked List](#328odd-even-linked-list)
- [160. 相交链表](#160-%E7%9B%B8%E4%BA%A4%E9%93%BE%E8%A1%A8)

<!-- /MarkdownTOC -->

<a id="leetcode"></a>
## leetcode

<a id="2%E4%B8%A4%E6%95%B0%E7%9B%B8%E5%8A%A0"></a>
## 2.两数相加

### 题目：
>给定两个非空链表来代表两个非负整数，位数按照逆序方式存储，它们的每个节点只存储单个数字。将这两数相加会返回一个新的链表。
>
>你可以假设除了数字 0 之外，这两个数字都不会以零开头。
>
> 示例：
>
> 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
>
>输出：7 -> 0 -> 8
>
>原因：342 + 465 = 807



### 思路：

>声明新链表及其指针和进位，设定循环，每轮的总求和为两链表指针当前位置的数字之和再加上一轮的进位，
>
>计算当前结果值为总求和的个位，进位值为其十位，直到两个链表均为空
>
>参考：https://blog.csdn.net/weixin_38385524/article/details/79520460

### 代码

```java
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
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

            if (list1.next == null && list2.next == null){
                if (add != 0){
                    head.next = new ListNode(add);
                }
                break;
            }
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
}
```




<a id="328odd-even-linked-list"></a>
## 328.Odd Even Linked List

----------


### 问题：


> Given a singly linked list, group all odd nodes together followed by the even nodes. Please note here we are > talking about the node number and not the value in the nodes.
>
> You should try to do it in place. The program should run in O(1) space complexity and O(nodes) time complexity.
>
>Example:
>
>Given 1->2->3->4->5->NULL,
>
>return 1->3->5->2->4->NULL.
>
>Note:
>The relative order inside both the even and odd groups should remain as it was in the input. 
>The first node is considered odd, the second node even and so on ...


### 思路:

>最直观的思路是采用采用新链表就可以完成，但本题要求是在 O(1) 的空间复杂度完成。
>
>使用两个头结点，一个指向奇数，一个指向偶数，遍历链表，奇数位置的记录在奇数结点后面，偶数位置的记录在偶数位置后面，交替>记录，使用的还是原来的链表存储元素，只是NEXT 指针方向改变。遍历完成后有奇偶两条链表，将偶数添加到奇数后面即可。
>

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

<a id="160-%E7%9B%B8%E4%BA%A4%E9%93%BE%E8%A1%A8"></a>
## 160. 相交链表
### 问题：
>编写一个程序，找到两个单链表相交的起始节点。
>
>例如，下面的两个链表：
>
>![160Image](https://github.com/HuanChen1025/DataStructer/blob/master/img/160Image.JPG?raw=true)
>
>在节点 c1 开始相交。
>
>注意：
>
>如果两个链表没有交点，返回 null.
在返回结果后，两个链表仍须保持原有的结构。
可假定整个链表结构中没有循环。
>程序尽量满足 O(n) 时间复杂度，且仅用 O(1) 内存。


### 思路：
 > 思路：两个链表的公共结点，也就是说这两个链表在这里交汇。
 >
 > 如果为双向链表的话，可以从后往前遍历，寻找分叉点，效率很高
 >
 > 单链表没有指向前一个结点的指针
 >
 > 首先获取到整个链表的长度，做差得到两个链表的长度差值，
 >
 > 长的链表先走 差值 步，然后两个链表同时向前走，知道两个结点不为空且相等，
 >
 > 返回该结点，即位公共结点
 >
 > 方法是最优的，其中语句可以做优化，使运算速度更快

### 代码(java)

```java
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
                if (headA == null || headB == null)
            return null;

        int longList  = listLength(headA);
        int shortList = listLength(headB);
        ListNode longListNode = headA;
        ListNode shortListNode = headB;


        int diff = longList - shortList;

        if (diff<0){
            longListNode = headB;
            shortListNode = headA;
            diff = Math.abs(diff);
        }

        while (diff>0){
            longListNode = longListNode.next;
            diff--;
        }

        while (longListNode != null && shortListNode != null && (longListNode != shortListNode)){
            longListNode = longListNode.next;
            shortListNode = shortListNode.next;
        }

        return longListNode;
    }
    
        private int listLength(ListNode head){
        if (head == null)
            return 0;
        int result =1;

        if (head.next == null)
            return result;

        while (head.next != null){
            result++;
            head = head.next;
        }
        return result;
    }
}

```