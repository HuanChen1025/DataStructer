package LeetCodeChina.Middle;

import java.util.PriorityQueue;

/**
 * 378. 有序矩阵中第K小的元素
 * 给定一个 n x n 矩阵，其中每行和每列元素均按升序排序，找到矩阵中第k小的元素。
 * 请注意，它是排序后的第k小元素，而不是第k个元素。
 */
public class KthSmallest {

    /**
     * 求矩阵里面第k小的数，首先比较容易想到的是用heap来做，maxheap或者minheap都可以，
     * 用maxheap的话把全部元素放进heap里面，同时如果heap的size大于k就弹出，保持heap的size为k，
     * 最后root的元素就是第k小的。复杂度是k + (m*n - k)logk，其中m = matrix.length, n = matrix[0].length。
     * @param matrix
     * @param k
     * @return
     */
    public int kthSmallest_01(int[][] matrix, int k) {
        /**
         *  public PriorityQueue(int initialCapacity,
         *  Comparator<? super E> comparator) {}
         */
        //最大堆实现，下标从 0 开始
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((k+1),(a,b)->(b-a));

        int m = matrix.length;
        int n = matrix[0].length;

        for (int i=0;i<m;i++){
            for (int j=0;j<n;j++){
                maxHeap.offer(matrix[i][j]);
                //大于 k ,弹出堆顶元素
                if (maxHeap.size()>k)
                    maxHeap.poll();
            }
        }
        return maxHeap.poll();
    }


    /**
     * 采用最小堆实现
     *
     * 时间和空间消耗都不小，最好的办法是二分查找
     * @param matrix
     * @param k
     * @return
     */
    public int kthSmallest_02(int[][] matrix, int k) {

        PriorityQueue<Integer> minHeap = new PriorityQueue<>(k+1,(a,b)->(a-b));

        int m = matrix.length;
        int n = matrix[0].length;

        for (int i=0;i<m;i++){
            for (int j=0;j<n;j++){
                minHeap.offer(matrix[i][j]);
            }
        }

        for (int i=1;i<k;i++){
            minHeap.poll();
        }

        return minHeap.poll();
    }

    /**
     * 运用二分查找
     * @param matrix
     * @param k
     * @return
     */
    public int kthSmallest_03(int[][] matrix, int k) {


        return -1;
    }


    public static void main(String[] args) {
        int[][] a = new int[][]{{1,5,9,11},{2,6,10,14},{3,7,13,15}};
        KthSmallest kthSmallest = new KthSmallest();
        System.out.println(kthSmallest.kthSmallest_02(a,1));
    }
}
