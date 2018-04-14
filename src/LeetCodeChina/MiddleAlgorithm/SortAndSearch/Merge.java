package LeetCodeChina.MiddleAlgorithm.SortAndSearch;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Interval {
      int start;
      int end;
      Interval() { start = 0; end = 0; }
      Interval(int s, int e) { start = s; end = e; }
  }


/**
 * 给出一个区间的集合, 请合并所有重叠的区间。
 *
 * 示例：
 * 给出 [1,3],[2,6],[8,10],[15,18],
 * 返回 [1,6],[8,10],[15,18].
 *
 * 首先需要按照 start 对区间进行排序
 *
 * 难点在于对集合排序，需要自己构造比较器
 */
public class Merge {

    public List<Interval> merge(List<Interval> intervals) {
        if (intervals == null || intervals.size()<=1)
            return  intervals;

        //对整个集合按照 start 进行排序，升序
        Collections.sort(intervals,new IntervalComparator() );

        List<Interval> result = new ArrayList<>();

        Interval last = intervals.get(0);

        //下一个的头和上一个的尾进行比较，如果头小于尾，则可以合并
        for (int i=1;i<intervals.size();i++){
            Interval curt = intervals.get(i);
            if (curt.start <= last.end){
                last.end = Math.max(last.end,curt.end);
            }
            else {
                result.add(last);
                last = curt;
            }
        }
        result.add(last);
        return result;
    }


    /**
     * 按照start对区间进行排序

     * 实现Comparator接口，重写compare方法
     */
    private class IntervalComparator implements Comparator<Interval> {
        public int compare(Interval a,Interval b){
            return a.start - b.start;
        }
    }
}



