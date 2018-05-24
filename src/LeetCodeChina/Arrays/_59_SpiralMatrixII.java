package LeetCodeChina.Arrays;

public class _59_SpiralMatrixII {
    public static int[][] generateMatrix(int n) {
        int [][] res = new int[n][n];
        if (n<1)
            return res;
        if (n==1){
            res[0][0] =1;
            return res;
        }
        //n >1

        //一圈一圈的生成数组
        int rowBegin =0;
        int rowEnd =n-1;
        int colBegin =0;
        int colEnd = n-1;
        int count =1;
        while (colBegin <= colEnd && rowBegin <= rowEnd){
            //生成上方行
            for (int i=colBegin;i<=colEnd;i++){
                res[rowBegin][i] =count++;
            }
            rowBegin++;

            //生成右边列
            for (int i=rowBegin;i<=rowEnd;i++){
                res[i][colEnd] = count++;
            }
            colEnd--;

            //生成下方行
            if (rowBegin <= rowEnd){
                for (int i=colEnd;i>=colBegin;i--){
                    res[rowEnd][i] = count++;
                }
            }
            rowEnd--;

            //生成左边列
            if (colBegin <= colEnd){
                for (int i= rowEnd;i>=rowBegin;i--){
                    res[i][colBegin] = count++;
                }
            }
            colBegin++;
        }


        return res;
    }

    public static void main(String[] args) {
        System.out.println(generateMatrix(3));
    }
}
