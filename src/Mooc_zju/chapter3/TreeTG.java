package Mooc_zju.chapter3;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class TreeNode{
    String val;
    int left;
    int right;
}

/**
 * 树的同构
 *
 */
public class TreeTG {

    private static TreeNode[] T1 = new TreeNode[10];
    private static TreeNode[] T2 = new TreeNode[10];
    private static int[] check = new int[10];
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        //接受长度并将check数组初始化为 0
        int T = scan.nextInt();
        Arrays.fill(check, 0);
        int root = buildTree(scan,T,T1);

        //循环结束后，再次接受长度并将check数组初始化为 0
        T = scan.nextInt();
        Arrays.fill(check, 0);
        int root1 = buildTree(scan,T,T2);

        System.out.println(an(root,root1)?"Yes":"No");
    }

    private static int buildTree(Scanner scan,int T,TreeNode[] T1){
        for(int i=0;i<T;i++){
//            System.out.println(treeNode.length);
            T1[i] = new TreeNode();
            T1[i].val = scan.next();
            String left = scan.next();
            String right = scan.next();
            if(left.equals("-")){
                T1[i].left = -1;
            }else{
                T1[i].left = Integer.parseInt(left);
                check[Integer.parseInt(left)] = 1;
            }

            if(right.equals("-")){
                T1[i].right = -1;
            }else{
                T1[i].right = Integer.parseInt(right);
                check[Integer.parseInt(right)] = 1;
            }
        }
        int root = -1;
        for(int i=0;i<T;i++){
            if(check[i]==0){
                root = i;
            }
        }

        return root;
    }

    //传递进来root的索引值可以避免数组越界
    public static boolean an(int root1,int root2){
        if(root1==-1&&root2==-1){
            return true;
        }
        if((root1==-1&&root2!=-1)||(root1!=-1&&root2==-1)||(!T1[root1].val.equals(T2[root2].val))){

            return false;
        }
        if(T1[root1].left==-1&&T2[root2].left==-1){

            return an(T1[root1].right,T2[root2].right);
        }
        if((T1[root1].left!=-1&&T2[root2].left!=-1)&&T1[T1[root1].left].val.equals(T2[T2[root2].left].val)){

            return (an(T1[root1].left,T2[root2].left)&&an(T1[root1].right,T2[root2].right));
        }else{

            return (an(T1[root1].left,T2[root2].right)&&an(T1[root1].right,T2[root2].left));
        }
    }
}