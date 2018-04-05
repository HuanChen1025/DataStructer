package LeetCodeChina.PrimaryAlgorithm.Sort;

/**
 * 合并两个有序数组
 *
 * 给定两个有序整数数组 nums1 和 nums2，将 nums2 合并到 nums1中，使得 num1 成为一个有序数组。
 */
public class MergeTwoArrays{

        /**
         * m 和 n 表示数组中元素的个数，数组实际长度可能比 m 和 n 大
         *
         * 从后往前比较和存储，从 m+n-1 开始存储
         *
         * 时间复杂度为O(M+N) ,空间复杂度为O(1)
         * @param nums1
         * @param m
         * @param nums2
         * @param n
         */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int index= m+n-1;
        int nums1Length = m-1;
        int nums2Length = n-1;

        while (index>=0){
            //第一个数组结束后第二个数组未结束，还有更小的元素
            if (nums1Length<0){
                for (int i= nums2Length;i>=0;i--){
                    nums1[index--] = nums2[nums2Length--];
                }
                return;
            }

            //第二个数组遍历结束
            if (nums2Length<0){
                return;
            }

            if (nums1[nums1Length]>nums2[nums2Length]){
                nums1[index--] = nums1[nums1Length--];
            }
            else {
                nums1[index--] = nums2[nums2Length--];
            }
        }
    }

    public static void main(String[] args) {
        MergeTwoArrays mergeTwoArrays = new MergeTwoArrays();
        int [] nums1 = new int[5];
        nums1[0] = 1;
        nums1[1] = 1;
        nums1[2] = 3;
        int [] nums2 = {3,4};
         mergeTwoArrays.merge(nums1,3,nums2,2);
        System.out.println();
    }
}
