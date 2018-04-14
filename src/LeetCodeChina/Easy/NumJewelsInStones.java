package LeetCodeChina.Easy;

import java.util.HashMap;

public class NumJewelsInStones {

    public int numJewelsInStones(String J, String S) {
        if (J == null || S == null)
            return 0;

        if (J.length() == 0 || S.length() ==0)
            return 0;

        //创建字符哈希表
       int [] map = new int[256];

       int res = 0;

       for (int i=0;i<J.length();i++){
           map[J.charAt(i)] = 1;
       }

       for (int i=0;i<S.length();i++){
           if (map[S.charAt(i)] == 1)
               res++;
       }
        return res;
    }
}
