package LeetCodeChina.PrimaryAlgorithm.Arrays;

/**
 * 旋转数组
 * 将包含 n 个元素的数组向右旋转 k 步。
 * 例如，如果  n = 7 ,  k = 3，给定数组  [1,2,3,4,5,6,7]  ，向右旋转后的结果为 [5,6,7,1,2,3,4]。
 * 要求空间复杂度为 O(1)
 */
public class RotateArrays {
    /**
     * 采用翻转字符串的方式实现
     * 首先翻转整个数组
     * 然后翻转前 k 个
     * 翻转后面的 n - k 个字符串
     * 这个方法宣告失败，左旋转 k 步，需要考虑重复旋转数组，不仅仅是翻转
     * @param nums
     * @param k
     */
    public void rotate_01(int[] nums, int k) {
        //校验输入,尤其注意，nums.length 需要大于 k
        if (nums == null || nums.length == 0 )
            return;
        //救活整个方法：将 k 值与字符串的长度求余，得到的数字就是在字符串长度以内的旋转长度
         k = k%nums.length;
        //翻转整个字符串
        reverseArray(nums,0,nums.length-1);

        //翻转前 k 个字符串
        reverseArray(nums,0,k-1);

        reverseArray(nums,k,nums.length-1);

    }

    /**
     * 反转数组，头尾连续交换
     * @param nums
     * @param begin
     * @param end
     */
    private void reverseArray(int [] nums,int begin,int end){
        while (begin<end){
            int temp = nums[begin];
            nums[begin] = nums[end];
            nums[end]= temp;
            begin++;
            end--;
        }
    }

    /**
     * 翻转数组，考虑连续旋转，即 k 大于数组的长度
     * @param nums
     * @param k
     */
    public void rotate_02(int[] nums, int k) {



    }

    public static void main(String[] args) {
        RotateArrays rotateArrays = new RotateArrays();
        int [] nums = {1,2};
        rotateArrays.rotate_01(nums,3);
        for (int i=0;i<nums.length;i++){
            System.out.println(nums[i]);
        }

    }


}
