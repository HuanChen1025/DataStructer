package SwordOffer;

public class FindRotateArray {

    public static int findRotateArray(int [] array){
        //考虑数组为空或者数组无元素
        if (array == null || array.length == 0){
            return 0;
        }
        // 考虑数组中只有一个元素
       if (array.length == 1){
            return array[array.length-1];
         }
        int i = 0;
        int j = array.length - 1;
        int mid = i;
        while (array[i] >= array[j]){
            //如果满足 j-i=1,说明已经搜索完毕，j就是最小元素
            if (j - i == 1){
                mid = j;
                break;
            }
            mid  = (i+j)/2;
            //如果 i, j 和 mid 三个全部相等，则导致指针移动方向未知，需要采用顺序判断
            //比如{3,2,3,3,3,3,3}，无法查找出最小值2
            //但是{3,3,3,3,3,2,3} 是可以查找出最小值的，所以这里面存在漏洞。
            if (array[i] == array[j] && array[i] == array[mid]){
                return minInOrder(array,i,j);
            }

            if (array[mid] >= array[i]){
                i = mid;
            }else
            if (array[mid] <= array[j]){
                j = mid;
            }

        }
        return array[mid];
    }

    /**
     * 顺序查找最小值
     * @param array
     * @param i
     * @param j
     * @return
     */
    public static int minInOrder(int[] array,int i,int j){
        int result = array[i];
        for (int k = i+1;i<=j;i++){
            if (array[k] < result){
                result = array[k];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int [] array = {};
        System.out.println(findRotateArray(array));

    }

}
