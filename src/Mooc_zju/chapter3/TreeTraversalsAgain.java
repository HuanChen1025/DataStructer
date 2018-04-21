package Mooc_zju.chapter3;

import java.util.*;

class TreeNode1{
    int val;
    int left;
    int right;
}

/**
 * 拥有前序和中序，需要后序遍历结点
 */
public class TreeTraversalsAgain {

//    public static int[] in ={};
//    int[] pre ={};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N =sc.nextInt();
      //  int root =buildTree(sc,N,T1);

        //list 中第一个为前序，第二个为中序，需要打印的是后序遍历的结果
        List<List<Integer>> list = buildTree(sc,N);

        list.get(0);
        int[] pre = new int[list.get(0).size()];
        int[] in  = new int[list.get(1).size()];

        for (int i=0;i<pre.length;i++){
            pre[i] = list.get(0).get(i);
        }
        for (int i=0;i<in.length;i++){
            in[i] = list.get(1).get(i);
        }

        List<Integer> res = new ArrayList<>();

        post(0,0,in.length-1,in,pre,res);
        //System.out.println();
        for (int i=0;i<res.size();i++){
            if (i!= res.size()-1){
                System.out.print(res.get(i)+" ");
            }
            else
                System.out.print(res.get(i));
        }




        //知道前序中序，需要打印后序
        //前序：根左右；中序：左根右

        System.out.println();
    }

    private static List<List<Integer>> buildTree(Scanner sc, int N){
        Stack<Integer> stack = new Stack<>();//构建一个堆
        List<Integer> preOrderTrav = new ArrayList<>();
        List<Integer> middleOrder = new ArrayList<>();

        for (int i=0;i<2*N;i++){
            String str = sc.next();
            if (str.equals("Push")){
                int num = sc.nextInt();
                stack.push(num);
                preOrderTrav.add(num);
            }
            else {
                int num = stack.pop();
                middleOrder.add(num);
            }
        }

        List<List<Integer>> res = new ArrayList<>();
        res.add(preOrderTrav);
        res.add(middleOrder);

        return res;
    }


    /**
     * https://blog.csdn.net/liuchuo/article/details/52135882
     * @param root
     * @param start
     * @param end
     * @param in
     * @param pre
     * @param res
     * @return
     */
   public static List<Integer> post(int root, int start, int end,int [] in,int []pre,List<Integer> res) {
        if(start > end)
            return null;
        int i = start;
        while(i < end && in[i] != pre[root]) i++;
        post(root + 1, start, i - 1,in,pre,res);
        post(root + 1 + i - start, i + 1, end,in,pre,res);
        res.add(pre[root]);
        //System.out.println(pre[root]);

        return res;
    }


}
