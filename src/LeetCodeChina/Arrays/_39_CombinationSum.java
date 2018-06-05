package LeetCodeChina.Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _39_CombinationSum {
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        solve(res,0,0,new ArrayList<>(),candidates,target);
        return res;
    }

    /**
     * 回溯法
     * @param res
     * @param currentIndex
     * @param count
     * @param temp
     * @param candidates
     * @param target
     */
    private static void  solve(List<List<Integer>> res , int currentIndex, int count ,List<Integer> temp, int[] candidates ,int target ){
        if (count >= target){
            if (count == target){
                res.add(new ArrayList<>(temp));
            }
            return;
        }
        //循环中包含着递归
        for (int i=currentIndex;i<candidates.length;i++){
             //和超出了我们需要的target ，返回
            if (count + candidates[i] > target){
                break;
            }
            temp.add(candidates[i]);
            solve(res,i,count+candidates[i],temp,candidates,target);
            temp.remove(temp.size()-1);
        }
    }

    public static void main(String[] args) {
        int [] array = {8,7,4,3};
        System.out.println(combinationSum(array,11));

    }
}
