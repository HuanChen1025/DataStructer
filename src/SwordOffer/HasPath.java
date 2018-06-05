package SwordOffer;

public class HasPath {
    /**
     *
     * @param matrix 是什么鬼，也不是二维矩阵。矩阵为什么是一维的？
     * @param rows
     * @param cols
     * @param str
     * @return
     */
    public boolean hasPath(char[] matrix, int rows, int cols, char[] str)
    {
        //标志数组，标记某个元素是否被访问过
        int [] flag = new int[matrix.length];
        for (int i=0;i<rows;i++){
            for (int j=0;j<cols;j++){
                if (helper(matrix,rows,cols,i,j,str,0,flag))
                    return true;
            }
        }
        return false;
    }

    private boolean helper(char[] matrix,int rows,int cols,int i,int j,char[] str,int k ,int[] flag){
        //索引，二维数组的坐标在 matrix 字符串中的位置
        int index = i*cols + j;
        // matrix[index] != str[k] : 说明字符串不匹配
        // flag[index] == 1 ： 说明此处已经被访问过了
        if (i<0 || i>= rows || j<0 || j>= cols || matrix[index] != str[k] || flag[index] == 1){
            return false;
        }
        //长度符合，返回true
        if (k == str.length -1) return true;
        flag[index] = 1; // 标记为已访问
        if (helper(matrix,rows,cols,i-1,j,str,k+1,flag)||
                helper(matrix,rows,cols,i+1,j,str,k+1,flag)||
                helper(matrix,rows,cols,i,j-1,str,k+1,flag) ||
                helper(matrix,rows,cols,i,j+1,str,k+1,flag)
                ){
            return true;
        }
        flag[index] = 0;    //该点的四周都访问结束后，释放掉这个点，标记为未访问
        return false;
    }
}
