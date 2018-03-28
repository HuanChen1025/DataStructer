package SwordOffer;



import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 基于回溯法思想：
 * https://uploadfiles.nowcoder.net/images/20170705/7578108_1499250116235_8F032F665EBB2978C26C4051D5B89E90
 */
public class Permutation {

    public ArrayList<String> Permutation(String str) {
        List<String> res = new java.util.ArrayList<>();
        if (str != null && str.length()>0){
            PermutationHelper(str.toCharArray(),0,res);
            Collections.sort(res);
        }
        return (ArrayList) res;
    }

    private  void PermutationHelper(char[] cs, int i, List<String> list){
        if (i == cs.length - 1){
            String val = String.valueOf(cs);
            if (!list.contains(val))
                list.add(val);
        }else {
            for (int j=i;j<cs.length;j++){
                //先把第一个字符与后面任意一个字符交换，
                // 交换后要还原到交换前的状态，否则会影响之后的循环
                //最后一个循环是递归调用swap交换前后两个字符，
                // 在最后交换完成入List之后再交换回来，回到初始状态再进下一个循环
                swap(cs,i,j);
                PermutationHelper(cs,i+1,list);
                swap(cs,i,j);

            }
        }
    }

    private void swap(char[] cs ,int i,int j){
        char temp = cs[i];
        cs[i] = cs[j];
        cs[j] = temp;
    }

    public static void main(String[] args) {
        Permutation p = new Permutation();
        System.out.println(p.Permutation("abc").toString());


    }


}
