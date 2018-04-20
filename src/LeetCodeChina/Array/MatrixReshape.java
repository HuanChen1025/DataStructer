package LeetCodeChina.Array;

import java.util.ArrayList;
import java.util.List;

public class MatrixReshape {

    /**
     * 方法不能通过所有的测试用例
     * @param nums
     * @param r
     * @param c
     * @return
     */
    public int[][] matrixReshape(int[][] nums, int r, int c) {
        int[][] res = new int[r][c];

        if (nums.length == 0 || nums[0].length ==0)
            return res;
        int rows = nums.length;
        int cols = nums[0].length;

        if (rows*cols != r*c)
            return nums;
        else {
            if (rows == r){
                return nums;
            }
            int indexR = 0;
            int indexC = 0;
            for (int i=0;i<rows;i++){
                for (int j=0;j<cols;j++){
                    if (c>=r){
                    if (indexC<c && indexR <r){
                        res[indexR][indexC]= nums[i][j];
                        indexC++;
                    } else {
                        indexC = 0;
                        indexR++;
                        if (indexC<c && indexR <r)
                        res[indexR][indexC]= nums[i][j];
                    }
                    }
                    else {

                        if (indexC<c && indexR <r){
                            res[indexR][indexC]= nums[i][j];
                            indexR++;
                        } else {
                            indexR = 0;
                            indexC++;
                            if (indexC<c && indexR <r)
                                res[indexR][indexC]= nums[i][j];
                        }

                    }
                }
            }
        }
        return res;
    }

    /**
     * 暴力法，先将数组拿出来放到链表中，在放到新的数组中，
     *
     * 时间复杂度O(nm），空间复杂度O(nm)
     *
     * @param nums
     * @param r
     * @param c
     * @return
     */
    public int[][] matrixReshape_01(int[][] nums, int r, int c) {
        int[][] res = new int[r][c];

        if (nums.length == 0 || nums[0].length ==0)
            return res;
        int rows = nums.length;
        int cols = nums[0].length;

        if (rows*cols != r*c){
            return nums;
        }
        else {
            List<Integer> list = new ArrayList<>();
            for (int i=0;i<rows;i++){
                for (int j=0;j<cols;j++){
                    list.add(nums[i][j]);
                }
            }

            int index =0;
            for (int i=0;i<r;i++){
                for (int j=0;j<c;j++){
                    res[i][j] = list.get(index);
                    index++;
                }
            }
        }
        return res;
    }

    /**
     * 最简洁的解法
     * @param nums
     * @param r
     * @param c
     * @return
     */
    public int[][] matrixReshape_02(int[][] nums, int r, int c) {
        int[][] res = new int[r][c];

        if (nums.length == 0 || nums[0].length ==0)
            return res;
        int rows = nums.length;
        int cols = nums[0].length;

        if (rows*cols != r*c){
            return nums;
        }
        else {
            for (int i=0;i<r*c;i++){
                //将两个数组从左往右依次遍历
                res[i/c][i%c] = nums[i/cols][i%cols];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        MatrixReshape obj = new MatrixReshape();
        int [][] nums ={{1,2,3,4}};
        obj.matrixReshape_02(nums,2,2);

    }
}
