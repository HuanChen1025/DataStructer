package LeetCodeChina.PrimaryAlgorithm.Arrays;

public class RotateImage {
    /**
     * 给定一个 n × n 的二维矩阵表示一个图像。
     * 将图像旋转 90 度（顺时针）。
     * 先按照副对角线翻转，然后按照水平线翻转
     * @param matrix
     */
    public void rotate_01(int[][] matrix) {
        //校验输入
        if (matrix == null)
            return;

        //N * N 的矩阵长度
        int nLength = matrix.length;
        //沿副对角线翻转
        for (int i=0;i<nLength;i++)
            for (int j=0;j<nLength-i;j++){
            int temp =  matrix[i][j];
            matrix[i][j] = matrix[nLength-1-j][nLength-1-i];
            matrix[nLength-1-j][nLength-1-i] = temp;
            //swap(matrix[i][j],matrix[nLength-1-j][nLength-1-i]);
            }

            //沿水平线翻转
            for (int i=0;i<nLength/2;i++){
            for (int j=0;j<nLength;j++){
                //swap(matrix[i][j], matrix[nLength - 1 - i][j]);
                int temp = matrix[i][j];
                matrix[i][j] = matrix[nLength - 1 - i][j];
                matrix[nLength - 1 - i][j] =temp;
            }
            }
    }

    /**
     * 另外一种更快的方法就是直接计算翻转后的值，
     * @param matrix
     */
    public void rotate_02(int[][] matrix) {
    }

    }
