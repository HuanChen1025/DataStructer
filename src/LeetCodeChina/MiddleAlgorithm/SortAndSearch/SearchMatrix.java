package LeetCodeChina.MiddleAlgorithm.SortAndSearch;

public class SearchMatrix {

    /**
     * 编写一个高效的算法来搜索 m x n 矩阵中的一个目标值。该矩阵具有以下特性：

     * 每行的元素从左到右升序排列。
     * 每列的元素从上到下升序排列。
     *
     * 从右上角开始搜索
     * @param matrix
     * @param target
     * @return
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        //校验输入
        if (matrix== null || matrix.length ==0 || matrix[0].length==0)
            return false;

        int rows = matrix.length;//行数
        int cols = matrix[0].length;    //列数

        int i=0,j=cols-1;

        //如果行和列都满足条件，则循环，时间复杂度为O(n)
        for ( ;i<rows && j>=0;){
                if (matrix[i][j]>target){
                    j--;
                }
                else if (matrix[i][j]<target){
                    i++;
                }
                else if (matrix[i][j]==target){
                    return true;
                }
        }
        return false;
    }

    public static void main(String[] args) {

        int [][]nums = {{1,4,7,11},{2,5,8,12},{3,6,9,16}};

        SearchMatrix searchMatrix = new SearchMatrix();

        System.out.println(searchMatrix.searchMatrix(nums,19));
    }


}
