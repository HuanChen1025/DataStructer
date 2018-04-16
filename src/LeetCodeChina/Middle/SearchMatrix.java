package LeetCodeChina.Middle;

public class SearchMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0)
            return false;

        int row = matrix.length-1;    //行
        int col = matrix[0].length-1; //列

        for (int i=0,j=col;i<=row && j>=0;){
            if (matrix[i][j]>target){
                j--;
            }
            else if (matrix[i][j]<target){
                i++;
            }
            else {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        SearchMatrix searchMatrix = new SearchMatrix();
        int[][] nums ={{1,3,5,7},{10,11,16,20},{23,30,34,50}};
        System.out.println(searchMatrix.searchMatrix(nums,55));

    }
}
