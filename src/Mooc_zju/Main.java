package Mooc_zju;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner  sc = new Scanner(System.in);
        int k = sc.nextInt();
        int[] inputArray = new int[k];
        for (int i =0;i<inputArray.length;i++){
            inputArray[i] = sc.nextInt();

        }
        Maximum_Subsequence_Sum(inputArray);

    }

    /**
     * O(n2)的复杂度，两层 for 循环
     * @param inputArray
     * @return
     */
    public static int maxSubsequence(int inputArray[]){
        int maxSum = 0;
        for (int i=0;i<inputArray.length;i++){
            int temMaxSum = 0;
            for (int j=i;j<inputArray.length;j++){
                temMaxSum +=inputArray[j];
                if (temMaxSum > maxSum){
                    maxSum = temMaxSum;
                }
            }
        }
        return maxSum;
    }

    /**
     * 在线处理
     * @param inputArray
     * @return
     */
    public static int maxSubSequence_online(int inputArray[]){
        int maxSum = 0;
        int thisSum = 0;
        for (int i = 0; i < inputArray.length; i++){
            thisSum +=inputArray[i]; //向右累加
            if (thisSum > maxSum){
                maxSum = thisSum;  //发现更大的则更新当前的结果
            }
            else if (thisSum < 0){  //如果当前子列和小于0，抛弃
                thisSum = 0;
            }
        }
        return maxSum;
    }

    /**
     * 01-复杂度2 Maximum Subsequence Sum（25 分）
     * 求解最大子列和与最大子列和的位置，不对啊，部分正确，部分错误
     * @param inputArray
     * @return
     */
    public static void Maximum_Subsequence_Sum(int[] inputArray){
        int maxSum = 0; //子列最大和
        int thisSum = 0;    //当前可能子列最大和
        int Lindex = 0;     //左边索引
        int Rindex = 0;     // 右边索引
        int maybe_Lindex=0;//可能成为最大子列和的第一个结点
        int flag_max=0;//flag represent whether max has been rewrite
        int flag = 0;   //thisSum归零一次，有可能后续子数列会出现大于当前max的数列
        for (int i = 0; i < inputArray.length; ++i){
            thisSum +=inputArray[i]; //向右累加
            if (thisSum > maxSum){
                flag_max = 1;
                if (flag == 0){
                    Lindex = maybe_Lindex;
                    flag =1;
                }
                Rindex = i; //更新右边的索引
                maxSum = thisSum;  //发现更大的则更新当前的结果
            }
            else if (thisSum < 0){  //如果当前子列和小于0，抛弃
                maybe_Lindex = i+1;
                thisSum = 0;
                flag = 0;
            }
        }

        if (flag_max == 0){
            System.out.println(0 + " " + inputArray[0] + " " + (inputArray[inputArray.length-1]));
        }
        else{
            System.out.println(maxSum + " " +inputArray[Lindex] + " " + inputArray[Rindex]);
        }


    }
}