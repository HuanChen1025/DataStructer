package lintCode;

public class Number_of_Islands {
    /**
     * @param grid: a boolean 2D matrix
     * @return: an integer
     * 采用深度优先遍历，把访问过的改为‘0’，继续遍历
     */
    public  int numIslands(boolean[][] grid) {
        // write your code here
        if (grid == null || grid.length == 0 || grid[0].length == 0){
            return 0;
        }
        int count = 0;
        int rows = grid.length;
        int cols = grid[0].length;
        //两重for循环，重复遍历项较多，效果不好
        for (int i =0;i<rows;i++){
            for (int j=0;j<cols;j++){
                if (grid[i][j] == true){
                    count++;
                    dfsSearch(grid,i,j,rows,cols);
                }
            }
        }
        return count;
    }
    private  void dfsSearch(boolean[][] grid,int i,int j,int rows,int cols){
        //防止出现越界的情况
        if (i<0 || i>= rows || j<0 || j>= cols){
            return;
        }
        //如果遍历到周围某个位置不为1，则返回到上一层。采用多层递归，效率不一定好
        if (grid[i][j] != true)
            return;

        grid[i][j] = false;
        dfsSearch(grid, i + 1, j, rows, cols);
        dfsSearch(grid, i - 1, j, rows, cols);
        dfsSearch(grid, i, j + 1, rows, cols);
        dfsSearch(grid, i, j - 1, rows, cols);

    }

    public static void main(String[] args) {
        boolean [][] booleans = {{true,false},{true,false}};
       // System.out.println(numIslands(booleans));

    }

}
