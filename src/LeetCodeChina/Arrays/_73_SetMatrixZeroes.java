package LeetCodeChina.Arrays;

/**
 * 本题的难点在于处理空间复杂度
 *  O（mn) 的算法并不难
 */
public class _73_SetMatrixZeroes {

    /**
     * O（MN）的空间复杂度
     * 空间复杂度不满足要求，居然通过了AC！！！！！！！！1
     * @param matrix
     */
    public static void setZeroes_01(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return;

        int row = matrix.length;
        int col = matrix[0].length;

        int[][] res = new int[row][col];

        //返回数组赋初值
        for (int i=0;i<row;i++){
            for (int j=0;j<col;j++){
                res[i][j] =matrix[i][j];
            }
        }
        for (int i=0;i<row;i++){
            for (int j=0;j<col;j++){
                if (matrix[i][j] == 0){
                    for (int k =0;k<row;k++)
                        res[k][j] =0;
                    for (int k=0;k<col;k++)
                        res[i][k] =0;
                }
            }
        }
        for (int i=0;i<row;i++){
            for (int j=0;j<col;j++){
                matrix[i][j] = res[i][j];
            }
        }
    }

    /**
     * O(m+n) 的空间复杂度,排名提高到 92%
     *
     * 将行和列中的零用一个标志数组存起来
     * @param matrix
     */
    public static void setZeroes_02(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return;

        int rowNum = matrix.length;
        int colNum = matrix[0].length;

        int [] rows = new int[rowNum];

        for (int i=0;i<rows.length;i++)
            rows[i] =1;

        int [] cols = new int[colNum];

        for (int i=0;i<cols.length;i++)
            cols[i] =1;

        for (int i=0;i<rowNum;i++){
            for (int j=0;j<colNum;j++){
                if (matrix[i][j] == 0){
                    rows[i] =0;
                    cols[j] =0;
                   // break;
                }
            }
        }

       for (int i=0;i<rows.length;i++){
            if (rows[i] == 0){
               for (int j=0;j<colNum;j++){
                   matrix[i][j] =0;
               }
            }
       }

       for (int i=0;i<cols.length;i++){
            if (cols[i] == 0){
                for (int j=0;j<rowNum;j++){
                    matrix[j][i] = 0;
                }
            }
       }
    }

        public static void main(String[] args) {
        int [][] nums ={{0,1,2,0},{3,4,5,2},{1,3,1,5}};
         //   System.out.println(nums[2][3]);
            setZeroes_02(nums);
            System.out.println();

    }
}
