package LeetCodeChina.Easy;

import java.util.ArrayList;
import java.util.List;

/**
 * 728. 自除数
 */
public class SelfDividingNumbers {

    /**
     * 暴力法
     * 有更优化的方法，
     * @param left
     * @param right
     * @return
     */
    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> res = new ArrayList<>();

        if (left>right)
            return res;

        while (left <= right){
            int temp = left;
            boolean flag =true;

            while (temp!=0){
                int x = temp%10;
                temp = temp/10;
                if (x==0 || left%x != 0){
                    flag = false;
                    break;
                }
            }

            //此处注意 flag = true ,依然会成立，并且一直成立，将 flag 赋值为 true，而不是判断
            if (flag == true)
                res.add(left);

            left++;
        }

        return res;
    }

    public static void main(String[] args) {
        SelfDividingNumbers selfDividingNumbers = new SelfDividingNumbers();
        System.out.println(selfDividingNumbers.selfDividingNumbers(1,22));

    }
}
