package LeetCodeChina.Arrays;

import java.util.HashSet;

public class _36_ValidSudoku {
    /**
     * 验证是否是有效的数独
     * @param board
     * @return
     */
    public boolean isValidSudoku(char[][] board) {
        //校验输入是否符合规范
        if (board == null || board.length == 0 || board[0].length == 0) {
            return false;
        }
        for (int i=0;i<9;i++){
            HashSet<Character> rows = new HashSet<>();
            HashSet<Character> cols = new HashSet<>();
            HashSet<Character> cubes = new HashSet<>();
            for (int j=0;j<9;j++){
                //行，如果在行中添加返回是 fasle 的话，说明有重复元素出现
                if (board[i][j] != '.' && !rows.add(board[i][j]))
                    return false;

                if (board[j][i] != '.' && !cols.add(board[j][i]))
                    return false;

                // 获取小方格的开始位置坐标
                int rowIndex = 3*(i/3);
                int colIndex = 3*(i%3);
                //验证在每一个小方格中是否出现了重复，出现重复，返回false
                if (board[rowIndex + j/3][colIndex + j%3] != '.' && !cubes.add(board[rowIndex + j/3][colIndex + j%3]))
                    return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {

    }
}
