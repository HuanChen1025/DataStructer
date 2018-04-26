package SwordOffer;

import java.util.Arrays;

/**
 * 调整数组顺序使奇数位于偶数前面
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，
 * 使得所有的奇数位于数组的前半部分，所有的偶数位于位于数组的后半部分，
 * 并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 */
public class ReOrderArray {

    /**
     * 双指针：不能做，放弃.如果不考虑数组元素的相对位置，可以采用双指针
     *
     * 采用空间换时间的暴力法求解
     * @param array
     */
    public void reOrderArray(int [] array) {
        //校验数组长度
        if (array.length <=1){
            return;
        }
        //空间换时间
        int len = array.length;
        int [] res = new int[len];
        int resLen =0;

        for (int i=0;i<len;i++){
            if (array[i]%2==1){
                res[resLen] = array[i];
                resLen++;
            }
        }

        for (int i=0;i<len;i++){
            if (array[i]%2==0){
                res[resLen] = array[i];
                resLen++;
            }
        }

       for (int i=0;i<array.length;i++)
           array[i] = res[i];

    }

    public static void main(String[] args) {
        int [] nums ={1,2,3,4,5,6,7};
        ReOrderArray obj = new ReOrderArray();
        obj.reOrderArray(nums);
        System.out.println();

    }
}
