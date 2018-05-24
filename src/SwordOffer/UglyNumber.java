package SwordOffer;

/**
 * 判断一个数是否是丑数，只包含因子2,3,5 的数称为丑数
 */
public class UglyNumber {

    /**
     * 判断一个数是否是丑数.如果将这个用于第 N 个丑数的判断，
     * 时间复杂度较高，需要每一个都判断
     * @param number
     * @return
     */
    public static boolean uglyNumber(int  number){
        while (number%2 == 0)
            number /= 2;
        while (number%3 == 0)
            number /= 3;
        while (number%5 == 0)
            number /= 5;
        return number == 1;
    }

    /**
     * 算法无法通过 1秒 的时间限制
     * @param index
     * @return
     */
    public static int getUglyNumber(int index){
        if (index < 0)
            return 0;
        int number = 0;
        int uglyFoud = 0;
        while (uglyFoud < index){
            ++ number;
            if (uglyNumber(number))
                ++uglyFoud;
        }
        return number;
    }

    /**
     * 在指定的时间效率里获取丑数，牺牲空间换取时间
     * 这道题的本质是： 动态规划
     * 动态规划就是要记住之前的计算结果，减少重复计算
     * @param index
     * @return
     */
    public static int getUglyNumber_Solution2(int index){
        if (index <= 0 )
            return 0;
        int [] pUglyNumbers = new int[index];
        pUglyNumbers[0] = 1;
        int nextUglyIndex = 1;

        //乘 2,3,5 丑数的索引值
        int  pMultiply2 = 0;
        int  pMultiply3 = 0;
        int  pMultiply5 = 0;

        while (nextUglyIndex <= index-1){
            //将2,3,5 索引位置的丑数都乘以2，3,5，取最小值
            pUglyNumbers[nextUglyIndex] = min(pUglyNumbers[pMultiply2]*2,pUglyNumbers[pMultiply3]*3,pUglyNumbers[pMultiply5]*5);

            //哪一个是最小值，就更新它的索引向前移动一步
            if (pUglyNumbers[pMultiply2]*2 == pUglyNumbers[nextUglyIndex])
                pMultiply2++;
            if (pUglyNumbers[pMultiply3]*3 == pUglyNumbers[nextUglyIndex])
                pMultiply3++;
            if (pUglyNumbers[pMultiply5]*5 == pUglyNumbers[nextUglyIndex])
                pMultiply5++;
            nextUglyIndex++;
        }

        return pUglyNumbers[nextUglyIndex-1];
    }


    /**
     * 比较三个数的最小值
     * @param number1
     * @param number2
     * @param number3
     * @return
     */
    public  static int min(int number1,int number2,int number3){
        int min = (number1<number2) ? number1:number2;
        min = (min<number3) ?min:number3;
        return min;
    }



    public static void main(String[] args) {
        System.out.println(getUglyNumber_Solution2(1500));


    }
}
