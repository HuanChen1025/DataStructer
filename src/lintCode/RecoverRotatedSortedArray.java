package lintCode;

import java.util.ArrayList;
import java.util.List;

public class RecoverRotatedSortedArray {

    /**
     * 给定一个旋转排序数组，在原地恢复其排序。
     * 时间复杂度还行，空间复杂度有点高，
     * 拘役思路是查找到第一个逆序的地方，并分成两部分将输入到另外一个链表之中。
     * @param nums: An integer array
     * @return: nothing
     */
    public static void recoverRotatedSortedArray(List<Integer> nums) {
        // write your code here
        List<Integer> result = new ArrayList<>();
        if (nums.size() ==0 || nums ==null){
            return;
        }
        int j=0;
        for (int i=0;i<nums.size()-1;i++){
            if (nums.get(i)>nums.get(i+1)){
                j=i+1;
            }
        }
        for (int i = j;i<nums.size();i++){
            result.add(nums.get(i));
        }
        for (int i = 0;i<j;i++){
            result.add(nums.get(i));
        }
        nums = result;
        System.out.println(nums.toString());
        return;


    }

    /**
     *
     * 『三步翻转法』，以[4, 5, 1, 2, 3]为例。
     *   首先找到分割点5和1
     *    翻转前半部分4, 5为5, 4，后半部分1, 2, 3翻转为3, 2, 1。整个数组目前变为[5, 4, 3, 2, 1]
     *    最后整体翻转即可得[1, 2, 3, 4, 5]
     *    使用两个指针，一个指头，一个指尾，使用for循环移位交换即可
     * @param nums
     */
    public static void recoverRotatedSortedArray_01(List<Integer> nums) {
        if (nums.size() == 0 || nums == null){
            return;
        }
        for (int i = 0;i < nums.size()-1;i++){
            if (nums.get(i) > nums.get(i + 1)) {
                reverse(nums,0,i);  //翻转0-i
                reverse(nums,i+1,nums.size()-1);    //翻转i+1 - nums.size()-1
                reverse(nums,0,nums.size()-1);      //将整个逆序链表翻转
                System.out.println(nums.toString());
                return;     //此处的return 语句还是必不可少的
            }

        }
    }
    public static void reverse(List<Integer> nums, int start,int end){
        for (int i=start,j = end ; i < j ;i++,j--){
            int temp = nums.get(i);
            nums.set(i,nums.get(j));
            nums.set(j,temp);
        }

    }

    public static void main(String[] args) {
        List<Integer> nums = new ArrayList<>();
        nums.add(4);
        nums.add(5);
        nums.add(1);
        nums.add(2);
        nums.add(3);
        recoverRotatedSortedArray(nums);
    }
}
