package Mooc_zju.chapter3;


import java.util.*;

class ThisTreeNode{
    int val;
    int left;
    int right;
}

public class ListLeaves {
    private static int[] check = new int[10];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ThisTreeNode[] T1 = new ThisTreeNode[10];
        int N =sc.nextInt();
        Arrays.fill(check, 0);
        int root =buildTree(sc,N,T1);

        //层次遍历二叉树，存储结点

        List<Integer> res = levelTraversal(root,T1);

        for (int i=0;i<res.size();i++){
            if (i!= res.size()-1){
                System.out.print(res.get(i)+" ");
            }
            else
                System.out.print(res.get(i));

        }



    }

    /**
     * 构建二叉树
     * @param sc
     * @param N
     * @param T
     * @return
     */
    private static int buildTree(Scanner sc,int N,ThisTreeNode[] T){
        for (int i=0;i<N;i++){
            T[i] = new ThisTreeNode();  //实例化很重要，否则会报空指针异常
            T[i].val = i;
            String left = sc.next();
            String right = sc.next();
            if(left.equals("-")){
                T[i].left = -1;
            }else{
                T[i].left = Integer.parseInt(left);
                check[Integer.parseInt(left)] = 1;
            }

            if(right.equals("-")){
                T[i].right = -1;
            }else{
                T[i].right = Integer.parseInt(right);
                check[Integer.parseInt(right)] = 1;
            }
        }
        int root = -1;
        for(int i=0;i<N;i++){
            if(check[i]==0){
                root = i;
            }
        }

        return root;
    }

    private static List<Integer> levelTraversal(int root,ThisTreeNode[] T1){
        Queue<Integer> queue = new ArrayDeque<>();

        List<Integer> list = new ArrayList<>();

        queue.add(root);

        while ( queue.size()!=0){

            root = queue.poll();

            if (T1[root].left ==-1 && T1[root].right ==-1 )
                list.add(root);

             if (T1[root].left!=-1){
                queue.offer(T1[root].left);
            }

             if (T1[root].right!=-1){
                queue.offer(T1[root].right);
            }



        }

        return list;
    }
}
