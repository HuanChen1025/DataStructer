package SwordOffer;

import java.util.ArrayList;

/**
 * 输出所有和为S的连续正数序列。序列内按照从小至大的顺序，序列间按照开始数字从小到大的顺序
 */
public class FindContinuousSequence {

    public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {

        if (sum<=0){
            return new ArrayList<ArrayList<Integer>>();
        }
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();

        //定义两个指针，指针中间就是我们需要的序列
        int small = 1;
        int big = 2;
        int middle = (sum + 1)/2;
        int currentSum = small + big;

        while (small<middle){
            //如果符合条件，将这一组序列添加到链表中
            if (currentSum == sum){
                result.add(addSequence(small,big));

            }
            //如果当前和大于 sum,删掉较小的并逐个增加 small
            while (currentSum>sum && small < middle){
                currentSum -= small;
                small++;
                //符合条件，将序列添加到 ArrayList 中
                if (currentSum == sum){
                    result.add(addSequence(small,big));
                }
            }
            big++;
            currentSum +=big;

        }
        return result;
    }

    /**
     * 将查找到的序列添加到一个链表中
     * @param small
     * @param big
     * @return
     */
    private ArrayList<Integer> addSequence(int small,int big){
        ArrayList<Integer> tempResult = new ArrayList<>();
        for (int i=small;i <= big;i++){
            tempResult.add(i);
        }

        return tempResult;
    }
}
