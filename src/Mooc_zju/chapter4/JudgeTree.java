package Mooc_zju.chapter4;

import java.util.Scanner;

class BinarySearchTree{
    int value;
    BinarySearchTree left;
    BinarySearchTree right;

    int flag;

    /**
     * 够着函数，用于初始化
     *
     * https://blog.csdn.net/zjkC050818/article/details/53730108
     * @param value
     */
    public BinarySearchTree(int value){
        this.value = value;
        left = null;
        right = null;
        flag =0;
    }
}

public class JudgeTree {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner sc=new Scanner(System.in);
        int length=sc.nextInt();
        int N=0;
        BinarySearchTree root=null;
        while(length!=0){
            N=sc.nextInt();
            //建树
            root=buildTree(sc,length);
            //判断是否同一棵树，把结果存储到一棵树中
            boolean[] arr=new boolean[N];
            for(int i=0;i<N;i++){
                arr[i]=judge(root,sc,length);
                reset(root);
            }

            for(int j=0;j<N;j++){
                if(arr[j])
                    System.out.println("Yes");
                else
                    System.out.println("No");
            }
           // sc.nextInt();
            length=sc.nextInt();
        }

    }


    /**
     * 检测函数，这个不懂
     * @param value
     * @param t
     * @return
     */
    public static boolean check(int value,BinarySearchTree t){
        if (t.flag == 0){
            if (value == t.value){
                t.flag =1;
                return true;
            }
            else
                return false;
        }
        if (value>t.value){
            return check(value,t.right);
        }
        if (value<t.value){
            return check(value,t.left);
        }
        else {
            t.flag =1;
            return true;
        }
    }

    /**
     * 建立二叉搜索树
     * @param sc
     * @param length
     * @return
     */
    public  static  BinarySearchTree buildTree(Scanner sc,int length){
        BinarySearchTree root = null;
        int tem;
        for (int i=0;i<length;i++){
            tem = sc.nextInt();//读入
            root = insert(tem,root);
        }

        return root;//返回根结点
    }

    /**
     * 插入结点
     * @param value
     * @param t
     * @return
     */
    public static  BinarySearchTree insert(int value,BinarySearchTree t){
        if (t == null){/**如果为null，则实例化结点*/
            return new BinarySearchTree(value);
        }
        else {
            if (value>t.value){
                t.right = insert(value,t.right);
            }
            else if (value<t.value){
                t.left = insert(value,t.left);
            }
            /**如果已经存在，则什么都不做*/
        }

        return t;
    }

    /**
     * 判断是否合格，一个一个的 check
     * @param root
     * @param sc
     * @param length
     * @return
     */
    public static boolean judge(BinarySearchTree root,Scanner sc,int length) {
        int temp;
        boolean flag = true;/**false 表示还是一致的*/
        for (int j = 0; j < length; j++) {
            temp = sc.nextInt();
            if (!check(temp, root)) {
                //需要继续打印,并且需要补上 j++
                j++;//因为这里在for 循环本应该加1 的，但是被耽误了，不加一就会出现错位
                while (j < length) {
                    int x= sc.nextInt();
                    j++;
                }
                return false;
            }
        }
        return true;
    }

    /**
     * 重置 二叉树中的 flag
     * @param root
     */
    public static void reset(BinarySearchTree root){
        if (root.left != null)
            reset(root.left);
        if (root.right != null)
            reset(root.right);
        root.flag =0;
    }

}
