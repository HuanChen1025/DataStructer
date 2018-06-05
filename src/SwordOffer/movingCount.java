package SwordOffer;

public class movingCount {
    public int movingCountMenthd(int threshold, int rows, int cols)
    {
        boolean [] visited = new boolean[rows*cols];
        for (int i=0;i<rows*cols;i++)
            visited[i] = false;
        return count(threshold,rows,cols,0,0,visited);
    }

    /** 计数，统计 */
    private int count(int threshold,int rows,int cols,int row,int col,boolean[] visited){
        int count =0;
        //回溯法，递归
        if (check(threshold,rows,cols,row,col,visited)){
            visited[row*cols + col] = true;
            count = 1 + count(threshold, rows, cols,row-1,col,visited)+
                    count(threshold,rows,cols,row+1,col,visited)+
                    count(threshold,rows,cols,row,col-1,visited)+
                    count(threshold,rows,cols,row,col+1,visited);
        }
        return count;
    }

    private boolean check(int threshold,int rows,int cols,int row,int col,boolean[] visited){
        if (row>= 0 && row<rows && col>=0 && col < cols && getDigitSum(row)+getDigitSum(col)<=threshold && !visited[row * cols + col])
            return true;
        return false;
    }

    /**
     * 求一个整数的各位数字之和
     * @param num
     * @return
     */
    private int getDigitSum(int num){
        int sum = 0;
        while (num != 0){
            sum += num%10;
            num = num/10;
        }
        return sum;
    }
}
