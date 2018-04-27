package Interview.JD;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class TwoCollection {

    /**
     * 时间复杂度太高
     * @param args
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int first = sc.nextInt();
        int second = sc.nextInt();
        int[] firstList = new int[first];
        int[] secondList = new int[second];
        sc.nextLine();  //输入换行

      for (int i = 0;i<first;i++){
          firstList[i] = sc.nextInt();
        }
      sc.nextLine();    //输入换行

      for (int i = 0;i<second;i++){
          secondList[i] = sc.nextInt();
      }


      //对两个集合排序
        Arrays.sort(firstList);
        Arrays.sort(secondList);
        ArrayList<Integer> res = new ArrayList<>();
        int i=0,j=0;
        for (;i<first && j<second;){
            if (firstList[i] > secondList[j]){
                res.add(secondList[j]);
                j++;
            }
            else if (firstList[i] < secondList[j]){
                res.add(firstList[i]);
                i++;
            }else if (firstList[i] == secondList[j]){
                res.add(firstList[i]);
                res.add(secondList[j]);
                i++;
                j++;
            }
        }
        if (i<first){
            while (i<first){
                res.add(firstList[i]);
                i++;
            }

        }
        if (j<second){
            while (j<second){
                res.add(secondList[j]);
                j++;
            }

        }

        for (int k = 0;i<res.size();k++){
            if (k == res.size()-1){
                System.out.print(res.get(k));
                break;
            }

            System.out.print(res.get(k) +" ");
        }
    }
}
