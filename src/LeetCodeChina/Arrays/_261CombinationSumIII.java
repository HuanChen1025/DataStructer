package LeetCodeChina.Arrays;

import java.util.ArrayList;
import java.util.List;

/**
 * Find all possible combinations of k numbers that add up to a number n,
 * given that only numbers from 1 to 9 can be used and each combination
 * should be a unique set of numbers.

 */
public class _261CombinationSumIII {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>(); //返回结果
        combinations(res,new ArrayList<>(),k,n,1);

        return res;
    }

    /**
     * 难点在于递归的逻辑
     * 回溯法 backtracking
     * @param result
     * @param temp
     * @param k
     * @param n
     * @param index
     */
    private void combinations(List<List<Integer>> result,List<Integer> temp,int k, int n, int index){
        //满足边界条件，记录结果
        if (temp.size() == k && n==0){
            result.add(new ArrayList<>(temp));
            return;
        }

        //为什么 i 要从 index 开始
        for (int i=index;i<=9 && k>0 && n>0 ;i++){
            temp.add(i);
            combinations(result,temp,k,n-i,i+1);
            temp.remove(temp.size()-1);//means we need to change the element here
        }
    }
}
