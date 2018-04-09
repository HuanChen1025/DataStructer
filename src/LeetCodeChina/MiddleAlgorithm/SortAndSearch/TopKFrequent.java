package LeetCodeChina.MiddleAlgorithm.SortAndSearch;

import java.util.*;

/**
 * Top K Frequent Elements
 *
 * 给定一个非空的整数数组，返回其中出现频率前 k 高的元素。
 *
 * 例如，
 *
 * 给定数组 [1,1,1,2,2,3] , 和 k = 2，返回 [1,2]。
 */
public class TopKFrequent {

    /**
     * 初步想法：
     * 采用哈希表实现
     *
     * 前 k 高
     *
     * 参考了某国外大佬的答案，不太能看懂:http://zpjiang.me/2017/11/13/top-k-elementes-system-design/
     *
     * his solution is very straight forward,
     * it stores all the elements in a HashMap that maps elements to their frequencies,
     * then inserts all the map entry to a max heap so as to get the ones with the highest frequency.
     * The time complexity is O(nlogn) and space complexity is O(n).
     * @param nums
     * @param k
     * @return
     */
    public List<Integer> topKFrequent_01(int[] nums, int k) {

        List<Integer> res = new ArrayList<>();
        if (nums == null || nums.length == 0 )
            return res;
        Map<Integer,Integer> map = new HashMap<>();



        //遍历元素，添加到 hashmap，语句非常精简
        for (int n : nums){
            map.put(n,map.getOrDefault(n,0)+1);
        }

        //优先队列，实现最大堆，这里看不懂？？？？
        PriorityQueue<Map.Entry<Integer, Integer>> maxHeap =
                new PriorityQueue<>((a,b) -> (b.getValue() - a.getValue()));

        //map.entrySet() 返回此映射所包含的映射关系的 Set 视图。
        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            maxHeap.add(entry);
        }

        while(res.size()<k){
            Map.Entry<Integer, Integer> entry = maxHeap.poll();
            res.add(entry.getKey());
        }
        return res;
    }
}
