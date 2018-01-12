package lintCode;


/**
 * Given an integer array,
 * sort it in ascending order.
 * Use selection sort, bubble sort, insertion sort or
 * any O(n2) algorithm.
 * Given [3, 2, 1, 4, 5], return [1, 2, 3, 4, 5].
 */
public class SortIntegers {

    /**
     * 冒泡排序
     * @param A
     */
    public void bubbleSort(int[] A) {
        if (A.length==0 || A ==null){
            return;
        }
        int temp =0;
        for (int i=0;i<A.length;i++){
            for (int j=i;j<A.length;j++){
                if (A[i]>A[j]){
                    temp = A[i];
                    A[i] = A[j];
                    A[j] = temp;
                }
            }
        }
    }

    /**
     * 选择排序
     * 通过n-1次关键字间的比较，从n-i+1 个记录中选出关键字最小的记录，
     * 并和第i 个记录交换。
     * @param A
     */
    public void  selectionSort(int [] A){
        if (A.length==0 || A ==null){
            return;
        }
        int min;
        int temp;
        for (int i =0;i<A.length;i++){
            min =i;
            for (int j=i+1;j<A.length;j++){
                if (A[min]>A[j]){
                    min =j;
                }
            }
            //内循环结束之后，再验证min的值是否被改变
            if (min != i){
                //交换A[min] 和 A[j]
                temp = A[min];
                A[min] =A[i];
                A[i] =temp;
            }
        }
    }


}
