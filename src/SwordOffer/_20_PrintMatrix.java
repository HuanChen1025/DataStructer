package SwordOffer;

import java.util.ArrayList;

public class _20_PrintMatrix {
    public static ArrayList<Integer> printMatrix(int [][] matrix) {
        ArrayList<Integer> res = new ArrayList<>();
        //校验输入
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return res;

        int rows = matrix.length-1;
        int cols = matrix[0].length-1;
        int rowStart = 0;
        int colStart = 0;

        while (rowStart<=rows && colStart<=cols){
            //从左到右打印一行
           for (int i=rowStart;i<=cols;i++){
               res.add(matrix[rowStart][i]);
           }
            rowStart++;

           //从上到下打印一列
           if (rowStart < rows){
               for (int i=rowStart;i<=rows;i++){
                   res.add(matrix[i][cols]);
               }
               cols--;
           }

           //从右到左打印一行
           if (rowStart <= rows){ //检查是否还有行可打印
               for (int i=cols;i>=colStart;i--){
                   res.add(matrix[rows][i]);
               }
               rows--;
           }

           //从下到上打印一列
            if (colStart <= cols){ //检查是否还有列可打印
                for (int i=rows;i>=rowStart;i--){
                    res.add(matrix[i][colStart]);
                }
                colStart++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int [][] matrix = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
         printMatrix(matrix);

    }
}
