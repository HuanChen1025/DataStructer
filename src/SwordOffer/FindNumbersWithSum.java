package SwordOffer;

import java.util.ArrayList;
import java.util.HashMap;

//输入一个递增排序的数组和一个数字S，在数组中查找两个数，
// 是的他们的和正好是S，如果有多对数字的和等于S，输出两个数的乘积最小的。
public class FindNumbersWithSum {
    /**
     * 采用 java 提供的特殊数据结构 HashMap 实现
     * 时间复杂度比 O(n) 略多
     * @param array
     * @param sum
     * @return
     */
    public ArrayList<Integer> FindNumbersWithSum(int [] array, int sum) {
        //输入非法，返回一个空的 ArrayList 集合
        if ( array == null || array.length<2)
            return new ArrayList<>();

       HashMap<Integer,Integer> map = new HashMap<>();

       ArrayList<Integer> resultList = new ArrayList<>();

       int tempMul = 0;
       boolean firstSum =true;

       for (int i=0;i<array.length;i++){
           if (! map.containsKey(sum - array[i])){
               map.put(array[i],array[i]); //按照顺序添加到 hashmap 中
           }
           else {
               //获取符合条件的两个数
               int firstNum = map.get(sum - array[i]);
               int secondNum = array[i];

               //如果是第一次找到这两个数，将 rempMul 赋值为这两个数的乘积
               if (firstSum == true){
                   tempMul = firstNum*secondNum;
                   resultList.add(firstNum);
                   resultList.add(secondNum);
                   firstSum = false;
                   //如果不是第一次，需要进行多次比较
               }else if (tempMul>=(firstNum*secondNum)){
                   tempMul = firstNum*secondNum;
                   resultList.clear();
                   resultList.add(firstNum);
                   resultList.add(secondNum);
               }
           }
       }
        return resultList;
    }

    /**
     * 由于数组是递增的，我们采用两个指针，从两端开始往中间查询
     * 这个程序不对，由于涉及到乘积，比较的时候比较麻烦
     * 能AC，但是逻辑不对
     * @param array
     * @param sum
     * @return
     */
    public ArrayList<Integer> FindNumbersWithSum_01(int [] array, int sum) {
        //输入非法，返回一个空的 ArrayList 集合
        if ( array == null || array.length<2)
            return new ArrayList<>();

        ArrayList<Integer> resultList = new ArrayList<>();

        int pHead = 0;
        int pTail = array.length-1;

        int tempMul = 0;
        boolean firstSum =true; //第一次出现相等

        while (true){
            if ((array[pHead]+array[pTail]) > sum && pHead<pTail){
                pTail--;
            }
            else if ((array[pHead]+array[pTail]) < sum && pHead<pTail){
                pHead++;
            }
            else if ((array[pHead]+array[pTail]) == sum && pHead<pTail && firstSum == true){
                tempMul = array[pHead] * array[pTail];
                firstSum = false;
                resultList.add(array[pHead]);
                resultList.add(array[pTail]);
            }
            else if ((array[pHead]+array[pTail]) == sum && pHead<pTail && firstSum == false && tempMul>(array[pHead]*array[pTail])){
                resultList.clear();
                resultList.add(array[pHead]);
                resultList.add(array[pTail]);
            }
            //如果以上条件都不在满足了，退出循环
            else {
                break;
            }
        }
        return resultList;
    }





    public static void main(String[] args) {
        int[] array ={1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20};
        FindNumbersWithSum findNumbersWithSum = new FindNumbersWithSum();
       ArrayList<Integer> result =  findNumbersWithSum.FindNumbersWithSum_01(array,21);
        System.out.println(result.get(0));
        System.out.println(result.get(1));
    }
}
