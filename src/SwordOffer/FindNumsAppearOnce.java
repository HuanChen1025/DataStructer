package SwordOffer;

public class FindNumsAppearOnce {


    //num1,num2分别为长度为1的数组。传出参数
    //将num1[0],num2[0]设置为返回结果

    /**
     * 数组中有两个数字恰好只出现一次
     * 采用分治法
     * @param array
     * @param num1
     * @param num2
     */
    public void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        if(array == null || array.length == 2)
            return;

        int resultExclusiveOR = 0;
        //将原数组中的值依次求异或
        for (int i=0;i<array.length;i++){
            resultExclusiveOR ^=array[i];
        }

        //判断异或之后第一个零为第几位
        int indexOf1 = findFirstBitIs1(resultExclusiveOR);

        //在这里根据异或结果的第一个零的位置，将数据分做两个集合判别
        //分治法的思想很重要
        for (int i =0;i<array.length;i++){
            if (isBit1(array[i],indexOf1) == 1){
                num1[0] ^= array[i];
            }
            else {
                num2[0] ^= array[i];
            }
        }
    }

    /**
     * 查找 num 中第一个不为 1 的位
     * @param num
     * @return
     */
    private int findFirstBitIs1(int num){
        int indexBit = 0;
        while ((num & 1) == 0){
            num = num>>1;
            indexBit++;
        }
        return indexBit;
    }

    /**
     * 判断 num 的第 index 为是否是 1
     * @param num
     * @param index
     * @return
     */
    private int isBit1(int num,int index){

        num = num >>index;

        return  (num & 1);

    }

    public static void main(String[] args) {
        FindNumsAppearOnce findNumsAppearOnce = new FindNumsAppearOnce();
        int[] array = {2,4,3,6,3,2,5,5};
        int [] num1 = new int[1];
        int [] num2 = new int[1];
        findNumsAppearOnce.FindNumsAppearOnce(array,num1,num2);

        System.out.println(num1[0]);
        System.out.println(num2[0]);

    }
}
