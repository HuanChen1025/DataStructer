package LeetCodeChina.PrimaryAlgorithm.Arrays;

/**
 * 给定一个非负整数组成的非空数组，给整数加一。

 * 可以假设整数不包含任何前导零，除了数字0本身。

 * 最高位数字存放在列表的首位。

 * 本题的意图是：将一个非负整数的各位放到一个数组中，返回这个非负整数加一的结果
 */
public class PlusOne {

    public int[] plusOne(int[] digits) {
        if (digits == null || digits.length ==0)
            return null;

        //从后向前遍历
        int carry =1;   //用于判断该当前位加一是否有进位
        for (int i=digits.length-1;i>=0;i--){
            //如果 carry == 0,说明加一之后不为表为产生位数增加，直接返回
            if (carry ==0){
                return digits;
            }
            int temp = digits[i]+1;
            carry = temp/10;    //判断加一后是否产生了进位
            digits[i] = temp%10;    //如果产生了进位则为 0，如果没有产生进位，则为加一后的数字
        }

        if (carry == 1){
            int[] result = new int[digits.length+1];
            //初始化为 0
            for (int i=0;i<result.length;i++){
                result[i]=0;
            }
            result[0] =1;
            return result;
        }
        return digits;
    }

    public static void main(String[] args) {
        PlusOne plusOne = new PlusOne();
        int [] nums = {1,9,9,9};
        int [] result =plusOne.plusOne(nums);
        for (int i :
                result) {
            System.out.println(i);
        }
    }
}
