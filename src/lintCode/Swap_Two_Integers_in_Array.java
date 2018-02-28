package lintCode;

public class Swap_Two_Integers_in_Array {
    /**
     * @param A: An integer array
     * @param index1: the first index
     * @param index2: the second index
     * @return: nothing
     */
    public void swapIntegers(int[] A, int index1, int index2) {
        // write your code here
        if (index1>A.length-1 || index2>A.length-1){
            return;
        }
        int temp = 0;
        temp = A[index1];
        A[index1] = A[index2];
        A[index2] = temp;
    }
}
