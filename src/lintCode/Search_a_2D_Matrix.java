package lintCode;

public class Search_a_2D_Matrix {

    /**
     * @param matrix: matrix, a list of lists of integers
     * @param target: An integer
     * @return: a boolean, indicate whether matrix contains target
     *
     * Integers in each row are sorted from left to right.
     * The first integer of each row is greater than the last integer of the previous row.
     *  [
            [1, 3, 5, 7],
            [10, 11, 16, 20],
            [23, 30, 34, 50]
        ]
    从右上角开始查找，时间复杂度倒是不高，可是就是有小问题无法通过哦
     哎，各种通不过
     */
    public static boolean searchMatrix(int[][] matrix, int target) {
          // write your code here
         //matrix.length 表示二维矩阵代表的行m
        //matrix[i].length 表示每一行的宽度n

        if (matrix.length ==0 || matrix ==null){
            return false;
        }

        int j=matrix[0].length-1;
        for (int i=0;i<matrix.length-1;){
            //如果i 值越界，返回false
            if (matrix[i][j]>target){
                //target大于右上角的数字，说明所查数据在本行
                j--;
            }
            if ( j<0 ||i>=matrix.length){
                return false;
            }
           if (matrix[i][j]<target){
                //说明所查数据不在本行，跳转到下一行
                i++;
                j=matrix[i].length-1;
           }
            if (matrix[i][j] == target){
                return true;
            }
            if ( j<0 ||i>=matrix.length){
                return false;
            }

        }


        return false;
    }

    /**
     * 择日重写此方法
     * @param matrix
     * @param target
     * @return
     */
    public static boolean searchMatrix_01(int[][] matrix, int target) {
        // write your code here
        if(matrix == null || matrix.length == 0){
            return false;
        }

        if(matrix[0] == null || matrix[0].length == 0){
            return false;
        }

        int row = matrix.length;
        int column = matrix[0].length;

        int start = 0, end = row * column - 1;
        while(start <= end){
            int mid = start + (end - start) / 2;
            int number = matrix[mid / column][mid % column];
            if(number == target){
                return true;
            }else if(number > target){
                end = mid - 1;
            }else{
                start = mid + 1;
            }
        }

        return false;

    }

    public static void main(String[] args) {
        int [][] matrix = {{1,4,8,15,20,22,25,32,36,43,49,51,53,55,59,65,69,73,80},
                {100,116,136,148,169,188,207,222,245,266,283,299,323,347,363,384,406,431,447},
                {460,477,494,512,532,548,562,582,604,617,630,643,663,675,690,713,735,758,783}};
        System.out.println(searchMatrix(matrix,81));
    }
}
