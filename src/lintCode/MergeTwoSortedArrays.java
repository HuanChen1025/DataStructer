package lintCode;

public class MergeTwoSortedArrays {
    /*
     * @param A: sorted integer array A
     * @param B: sorted integer array B
     * @return: A new sorted integer array
     */
    public static int[] mergeSortedArray(int[] A, int[] B) {
        // write your code here
        if (A== null || B == null){
            return A == null ? B : A;
        }
        //A=[1,2,3,4]
        //B=[3,4,5]
        int [] res = new int[A.length + B.length];
        int i = 0;
        int j = 0;
        int k =0;
        while (i<A.length && j < B.length){
            if (A[i] > B[j]){
                res[k] = B[j];
                j++;
            }
            else {
                res[k] = A[i];
                i++;
            }
            k++;
        }
        if (i != A.length){//A已经
            //在res 中添加i 到 A.length的元素
            for (int m =i;i<A.length;m++){
                res[k] =A[m];
                k++;
            }
        }else if (j != B.length){
            //在res 中添加j 到 B.length的元素
            for (int m =j;i<B.length;m++){
                res[k] =B[m];
                k++;
            }

        }
        return res;
    }

    public static void main(String[] args) {
        int[] A = {1,2,3,4};
        int[] B = {89};
        System.out.println(mergeSortedArray(A,B));
        mergeSortedArray(A,B);


    }
}
