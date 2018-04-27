package LeetCodeChina.Arrays;

import java.util.ArrayList;
import java.util.List;

/**
 * 118. Pascal's Triangle
 */
public class _118PascalTriangle {
    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> temp;
        //校验输入
        if (numRows<=0){
            return result;
        }

        for (int i=1;i<=numRows;i++){
            temp = new ArrayList<>();
            if (i==1){
                temp.add(1);
                result.add(temp);
            }
            if (i==2){
                temp.add(1);
                temp.add(1);
                result.add(temp);
            }
            if (i>2){
                temp.add(1);
                //中间是需要计算的值
                List<Integer> list = result.get(i-2);
                for (int j=0;j<list.size()-1;j++){
                    int sum = list.get(j) + list.get(j+1);
                    temp.add(sum);
                }
                temp.add(1);
                result.add(temp);
            }

        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(generate(2));

    }

}
