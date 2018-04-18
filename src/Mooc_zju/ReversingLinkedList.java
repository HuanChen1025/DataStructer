package Mooc_zju;

import java.util.Scanner;

class ArrayNode{
    int data;
    int next;
    public ArrayNode() {
    }
}

/**
 * https://blog.csdn.net/u014800380/article/details/52919739
 */
public class ReversingLinkedList {
    public static void main(String[] args) {
        //读取用户输入的数据，存入数组
        ArrayNode[] array = new ArrayNode[100000];
        Scanner sc = new Scanner(System.in);
        int head = sc.nextInt();    //首地址
        int N = sc.nextInt();   //链表长度
        int k = sc.nextInt();   //k 的大小

        int current = 0;
        int a = head;   //第一个输入的就是首地址

        //将数组的值存储到输入数组中
        for (int i=0;i<N;i++){
            current = sc.nextInt();
            array[current] = new ArrayNode();
            array[current].data = sc.nextInt();
            array[current].next = sc.nextInt();
        }
        //返回数组中的有效的结点个数，为了防止数组中有多余的结点
        N = listLen(head,array);

        //逆转单向链表
        if (k>1){
            a = reverse(head,array,N,k);
        }

        // 打印逆转后的单项链表
        display(a,array);

    }

    /**
     * 改变输出格式，在不够五位数的前面补0
     * 需要完整的五位，不够补0
     * @param val
     * @return
     */
    private static String change(int val){
        if (val == -1) {
            return val + "";
        }
        String s = "00000";
        String first = val + "";
        int length = first.length();
        s = s.substring(length) + first;
        return s;
    }


    /**
     * 返回链表实际长度
     * @param head
     * @param arr
     * @return
     */
    private static int listLen(int head,ArrayNode arr[]){
        int num =0;
        while (head != -1){
            head = arr[head].next;
            num++;
        }
        return num;
    }

    private static void display(int head,ArrayNode[] arr){
        int num = 0;
        while (head != -1) {
            String head1 = change(head);
            String next1 = change(arr[head].next);
            System.out.println(head1 + " " + arr[head].data + " " + next1);
            head = arr[head].next;
            num++;
        }
    }

    /**
     * 以K为分界线对单向链表进行逆转
     * 这个是难点，不会
     * @param head
     * @param arr
     * @param N
     * @param K
     * @return
     */
    public static int reverse(int head, ArrayNode[] arr, int N, int K) {
        int num = 1;
        int reverse = 1;
        int remain = head;
        int old_head = arr[head].next;
        int new_head = head;
        int temp;
        int remain2 = head;
        while (reverse <= N / K) {
            while (num < K) {
                temp = arr[old_head].next;
                int a = arr[old_head].data;
                // 注意这里需要给数组该位置创建一个结点，不能直接用“arr[old_head].next= new_head”会影响old_head的值；
                arr[old_head] = new ArrayNode();
                arr[old_head].data = a;
                arr[old_head].next = new_head;// 将链表方向逆转
                new_head = old_head;
                old_head = temp;
                num++;
            }
            if (reverse == 1) {// 第一次逆转时，找到头节点，并将逆转之后的节点与还没逆转的节点相连
                head = new_head;
                arr[remain].next = old_head;
            } else {// 第i(i>1)次的逆转，都直接把逆转之后的节点与第i+1次逆转之后的节点连接起来
                arr[remain].next = new_head;
                remain = remain2;
            }
            if (old_head == -1) {// 当链表逆转结束时，将尾节点的下一个指向-1
                arr[remain2].next = -1;
            } else {// 如果一轮逆转之后链表还没结束，则还需要再进行一轮逆转，所以把所有的节点都往后移一位
                new_head = old_head;
                old_head = arr[old_head].next;
                remain2 = new_head;
            }
            num = 1;
            reverse++;
        }
        return head;
    }




}
