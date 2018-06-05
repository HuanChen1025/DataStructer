package SwordOffer;

import java.util.ArrayList;

public class maxInWindows {

    /**
     * 暴力法查找，如果滑动窗口的大小为k，需要O(k)的时间找到窗口内的最大值，总的时间复杂度为O（nk)
     * @param num
     * @param size
     * @return
     */
    public ArrayList<Integer> maxInWindowsMenth(int [] num, int size)
    {
        ArrayList<Integer> res = new ArrayList<>();

        if (num == null || num.length < size || size <=0)
            return res;

        // 双指针
        int len = num.length;
        for (int i=0,j=size-1;i<len&&j<len;i++,j++){
            //找出每一个滑动窗口的最大值
            int max =  findMax(i,j,num);
            res.add(max);
        }
        return res;
    }

    private int findMax(int i,int j,int[] num){
        int max = 0;
        for (;i<=j;i++){
            max = Math.max(max,num[i]);
        }
        return max;
    }

    public static void main(String[] args) {
        maxInWindows obj = new maxInWindows();
        int [] num = {2,3,4,2,6,2,5,1};
        obj.maxInWindowsMenth(num,3);
    }

}
