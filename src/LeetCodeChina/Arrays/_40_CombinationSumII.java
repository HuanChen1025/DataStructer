package LeetCodeChina.Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class _40_CombinationSumII {

    //  candidates 中的每个元素只能利用一次，不能重复利用
    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (candidates == null || candidates.length == 0)
            return res;


        Arrays.sort(candidates);
        helper(res,new ArrayList<>() ,0,0,candidates,target);
        return res;
    }



    /**
     * 回溯法
     * https://leetcode.com/problems/combination-sum-ii/discuss/16878/Combination-Sum-I-II-and-III-Java-solution-(see-the-similarities-yourself)
     * @param res
     * @param temp
     * @param currentIndex
     * @param count
     * @param candidates
     * @param target
     */
    private static void helper( List<List<Integer>> res,List<Integer> temp ,int currentIndex,int count,int[] candidates, int target){
        //检查结果是否满足条件，满足与target 相等，就添加到res 中
        if (count >= target){
            if (count == target)
                res.add(new ArrayList<>(temp));
            return;
        }
        //循环里面包含着递归,回溯法
        for (int i=currentIndex;i<candidates.length;i++){
            if (count+candidates[i]>target){
                break;
            }
            else if (i>currentIndex && candidates[i] == candidates[i-1])/** 跳过重复的元素 */
                continue;
            temp.add(candidates[i]);
            helper(res,temp,i+1,count+candidates[i],candidates,target);
            temp.remove(temp.size()-1);
        }
    }

    public static void main(String[] args) {
        int [] candidates ={10,1,2,7,6,1,5};
        int target = 8;

        combinationSum2(candidates,target);
    }
}
