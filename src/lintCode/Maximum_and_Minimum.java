package lintCode;

import java.util.ArrayList;
import java.util.Arrays;

public class Maximum_and_Minimum {
    /**
     * @param matrix: an input matrix
     * @return: nums[0]: the maximum,nums[1]: the minimum
     * 这个算法有问题，无法通过oj的 accept
     */
    public static int[] maxAndMin(int[][] matrix) {
        // write your code here
        //k
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return null;
        int[] res = new int[2];
        res[0] = matrix[0][0];
        res[1] = matrix[0][0];
        for(int i=0;i<matrix.length;i++){
            for (int j=0;j<matrix[0].length;j++){
                if (matrix[i][j]>res[0]){
                    res[0] = matrix[i][j];
                }
                if (matrix[i][j]<res[1]){
                    res[1] = matrix[i][j];
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int [][] res = new int[2][2];
        System.out.println(maxAndMin(res));
    }
}
