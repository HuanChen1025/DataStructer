package huawei;

import java.util.Scanner;

/**
 * 最大连续四个数最大
 */
public class Max4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[21];
        for (int i=0;i<arr.length;i++){
            arr[i] = sc.nextInt();
        }
        sc.close();
        System.out.println(max4(arr));
    }

    public static  int  max4(int arr[]){
        int sum = 0;
        int index = -1;
        for (int i=0;i<arr.length-3;i++){
            int temp = arr[i] + arr[i+1] + arr[i+2] +arr[i+3];
            if (temp>sum){
                sum = temp;
                index =i;
            }
        }
        return index;   //返回索引从 0 开始
    }
}
