package SwordOffer;

/**
 * 数字在排序数组中出现的次数
 * 最好的算法的时间复杂度是O（lgn）
 */
public class GetNumberOfK {
    public int getNumberOfK(int [] array , int k) {
        int start =0;
        int end =array.length-1;
        int firstIndex = getFirstK(array,k,start,end);
        int lastIndex = getLastK(array,k,start,end);
        //如果得到的返回值均为 -1，说明不存在这个数，返回 0
        if (firstIndex == -1 && lastIndex == -1)
            return 0;
        //否则返回相应的 k 出现次数
        return lastIndex-firstIndex+1;
    }


    /**
     * 找到 k 在数组中的第一个位置
     * @param array
     * @param k
     * @param start
     * @param end
     * @return
     */
    private int getFirstK(int [] array,int k, int start,int end){
        //如果开始大于结束，输出为-1
        if (start>end)
            return -1;
        int middleIndex = (start+end)/2;
        while (start<=end){
            if (array[middleIndex]>k){
                end = middleIndex-1;
            }
            else if (array[middleIndex] < k){
                start = middleIndex+1;
            }
            else if (array[middleIndex] == k ){
                //此处判断中间点是否为起点
                if ((middleIndex>0 && array[middleIndex-1]!=k )||middleIndex == 0)
                    return middleIndex;
                else
                    end =middleIndex-1;
            }
            middleIndex = (start+end)/2;
        }

        //如果不存在，则返回 -1
        return -1;
    }


    /**
     * 找到 k 在数组中的最后一个位置
     * @param array
     * @param k
     * @param start
     * @param end
     * @return
     */
    private int getLastK(int [] array,int k, int start,int end){
        //如果开始大于结束，输出为-1
        if (start>end)
            return -1;
        int middleIndex = (start+end)/2;
        while (start <= end){
            if (array[middleIndex]>k){
                end = middleIndex-1;
            }else if (array[middleIndex]<k){
                start = middleIndex+1;
            }else if (array[middleIndex] == k){
                if (middleIndex==end||(array[middleIndex+1]!=k && middleIndex<=end))
                    return middleIndex;
                else
                    start = middleIndex+1;
            }
            middleIndex = (start+end)/2;
        }
        //如果不存在，则返回 -1
        return -1;
    }

    public static void main(String[] args) {
        int [] array = {1,3,3,3,3,4,5};
        GetNumberOfK getNumberOfK = new GetNumberOfK();
        System.out.println(getNumberOfK.getNumberOfK(array,6));

    }
}
