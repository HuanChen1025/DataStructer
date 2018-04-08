package LeetCodeChina.MiddleAlgorithm.TreeAndGraph;

/**
 * 给定 '1'（陆地）和 '0'（水）的二维网格图，计算岛屿的数量。
 * 一个岛被水包围，并且通过水平或垂直连接相邻的陆地而形成。
 * 你可以假设网格的四个边均被水包围。
 */
public class NumIslands {

    public int numIslands(char[][] grid) {
        //校验输入，注意：grid.length==0 的校验
        if (grid == null || grid.length==0 || grid[0].length ==0)
            return 0;
        int rows = grid.length;
        int cols = grid[0].length;
        int result = 0;
        for (int i=0;i<rows;i++){
            for (int j=0;j<cols;j++){
                if (grid[i][j]=='1')
                    result++;
                    dfSearch(grid,i,j,rows,cols);
            }
        }
        return result;
    }

    //如果一个位置为 1 ，将其四周的 1 全部置为 0
    private void dfSearch(char[][] grid,int i,int j,int rows,int cols){
        if (i<0 || i>=rows || j<0 || j>=cols)
            return;
        //如果这个位置不为 1 ，返回
        if (grid[i][j] != '1')
            return;

        grid[i][j] = 0;
        //将 i j 位置的上下左右搜索一遍，如果为 1 ，置位 0
        dfSearch(grid,i-1,j,rows,cols);
        dfSearch(grid,i+1,j,rows,cols);
        dfSearch(grid,i,j-1,rows,cols);
        dfSearch(grid,i,j+1,rows,cols);
    }
}
