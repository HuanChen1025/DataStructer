package SwordOffer;

public class FindGreatestSumOfSubArray {

    /**
     * 时间复杂度为O（n）的在线求和方法
     * @param array
     * @return
     */
    public static int FindGreatestSumOfSubArray(int[] array) {
        if (array == null){
            return 0;
        }
        if (array.length == 0){
            return 0;
        }
        int maxSubSum = -1; //当全部为负数时，返回 -1
        int thisSubSum = 0;
        for (int i=0; i<array.length;i++){
            thisSubSum += array[i];
            if (thisSubSum > maxSubSum){
                maxSubSum = thisSubSum;
            }

            //如果子列和小于 0 ，对于后续没有作用，抛弃
            if (thisSubSum < 0){
                thisSubSum = 0;
            }

        }

        return maxSubSum;

    }

    public static void main(String[] args) {
        int [] array = {6,-3,-2,7,-15,1,2,2};
        System.out.println(FindGreatestSumOfSubArray(array));
    }

}
