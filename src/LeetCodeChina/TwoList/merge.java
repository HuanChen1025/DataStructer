package LeetCodeChina.TwoList;

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

public class merge {
    /**
     * 需要重新写
     *
     * 理解比较的逻辑
     * @param intervals
     * @return
     */
    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> result = new ArrayList<>();

        if (intervals == null || intervals.size() <=1)
            return result;

        //对整个集合按照 start 进行排序，升序。采用 lambda 表达式比较
        Collections.sort(intervals,(a,b)->(a.start-b.start) );

        Interval last = intervals.get(0);

        //下一个的头和上一个的尾进行比较，如果头小于尾，则可以合并
        for (int i=1;i<intervals.size();i++){
            Interval curt = intervals.get(i);
            if (curt.start <= last.end){/**判断是否可以合并，last 的 头不变，改变 last 的尾结点*/
                last.end = Math.max(last.end,curt.end);
            }
            else {/**如果不可以合并，则将 last 添加进返回的集合*/
                result.add(last);
                last = curt;
            }
        }
        result.add(last);

        return result;
    }


    public static void main(String[] args) {
        merge obj = new merge();
        List<Interval> list = new ArrayList<>();
        list.add(new Interval(2,6));
        list.add(new Interval(1,3));
        list.add(new Interval(8,10));
        list.add(new Interval(15,18));

        System.out.println(obj.merge(list));
    }
}
