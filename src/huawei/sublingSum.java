package huawei;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 输入不确定个数的最大连续子数组和
 */
public class sublingSum {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ArrayList<Integer> list=new ArrayList<>();
        while (in.hasNext()) {
            String s=in.nextLine();
            String[] str=s.split(" ");
            for(int i=0;i<str.length;i++){
                list.add(Integer.parseInt(str[i]));
            }
            System.out.println(SubingSum(list));
            break;
        }
    }

    public static int SubingSum(ArrayList<Integer> arr){
        if (arr == null || arr.size() == 0){
            return 0;
        }
        int currentSum = 0;
        int resultSum = 0;
        for (int i=0;i<arr.size();i++){
            currentSum +=arr.get(i);
            if (currentSum>resultSum){
                resultSum = currentSum;
            }
            if (currentSum<=0){
                currentSum = 0;
            }
        }
        return currentSum;
    }

}
