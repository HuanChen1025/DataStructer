package LeetCodeChina.TwoList;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PartitionLabels {

    public List<Integer> partitionLabels(String S) {
        List<Integer> res = new ArrayList<>();
        //校验输入
        if (S == null)
            return res;
      //  HashMap<Character,Integer> map = new HashMap<>();

        //自建 哈希表
        int[] map = new int[26];

        /**添加到 map 中，记录每个元素的最后出现位置*/
        for (int i=0;i<S.length();i++){
          //  map.put(S.charAt(i),i);
            map[S.charAt(i)-'a'] =i;
        }

        //双指针
        int start =0;
        int last=0;

        for (int i=0;i<S.length();i++){
            //在遍历过程中，取 last 的最大值
            last = Math.max(last,map[S.charAt(i)-'a']);
            if (i==last){
                res.add(i-start+1);
                start = i+1;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        PartitionLabels obj = new PartitionLabels();
        System.out.println(obj.partitionLabels("ababcbacadefegdehijhklij"));
    }
}
