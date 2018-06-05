package LeetCodeChina.Arrays;

/**
 * 高度不能取边
 */
public class _11_ContainerWithMostWater {

    /**
     * 题目要求任意两条线段之间的面积，所以类似二分查找，要从两边向中间查找
     * @param height
     * @return
     */
    public static int maxArea(int[] height) {
        int left = 0,right = height.length -1;
        int maxArea = 0;
        while (left<right && left>=0 && right <= height.length -1){
            //木桶原理，能装的水以矮边为准
            maxArea = Math.max(maxArea,Math.min(height[left],height[right])*(right- left));
            //如果左边的高度大于右边，那么右边抛弃，右边向中间靠
            if (height[left] > height[right]){
                right--;
            }
            else {
                left++;
            }
        }
        return maxArea;
    }

    public static void main(String[] args) {
        int [] height = {2,3,6,9};
        System.out.println(maxArea(height));
    }
}
