package SwordOffer;

import java.util.Arrays;

public class IsContinuous {

    /**
     * 从扑克牌中随机抽出五张，查看是否为顺子
     * @param numbers
     * @return
     */
    public boolean isContinuous(int [] numbers) {
        //输入校验
        if (numbers == null || numbers.length != 5){
            return false;
        }

        //对输入的数组排序
        Arrays.sort(numbers);

        int numbersOfZero = 0;
        int numberOfGap = 0;

        //求取数组中 0 的个数
       for (int i=0; i<numbers.length && numbers[i]==0;++i)
           ++numbersOfZero;

       //求取除 0 以外相邻两个数的间隔
       int small = numbersOfZero;
       int big = small +1;

       while (big < numbers.length){
           //数组中有对子，输出false
           if (numbers[small] == numbers[big])
               return false;

           numberOfGap += numbers[big] - numbers[small] -1;

           //指针指向下一个
           small = big;
           ++big;
       }

       //如果 0 的个数大于间隔个数，返回为真
        return numbersOfZero>=numberOfGap?true:false;
    }

    public static void main(String[] args) {
        int[] numbers ={0,3,1,6,4};
        IsContinuous isContinuous = new IsContinuous();
        System.out.println(isContinuous.isContinuous(numbers));
    }
}
