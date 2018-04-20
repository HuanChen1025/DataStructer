package Mooc_zju.chapter3;

import java.util.Scanner;

class TreeNode{
    public char Element;
    public int left;
    public  int right;}


public class TreeTG {

    public static void main(String[] args) {

        //建立存储的数组，最大为10
        TreeNode T1[] = new TreeNode[10];
        TreeNode T2[] = new TreeNode[10];
        int r1 = buildTree(T1);
        int r2 = buildTree(T2);


    }

    private static int buildTree(TreeNode T[]){
        int Root = 0;
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        if (N>0){
            int[] check = new int[10];
            for (int i=0;i<N;i++) check[i] =0;
            for (int i=0;i<N;i++){
                char[] temp = sc.nextLine().toCharArray();
                T[i].Element = temp[0];
                if (temp[1] != '-'){
                    T[i].left = temp[1]-'0';
                    check[T[i].left]=1;
                }
                else {
                    T[i].left = -1;
                }

                if (temp[2]!='-'){
                    T[i].right = temp[2]-'0';
                    check[T[i].right] =1;
                }
                else {
                    T[i].right = -1;
                }
                for ( i=0;i<N;i++){
                    if (check[i]==0)
                        break;
                }
                Root = i;

            }
        }
        return Root;
    }

}
