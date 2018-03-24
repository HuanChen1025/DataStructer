package SwordOffer;

public class Odd_Even {

    /**
     * 采用位运算，调试失败
     * @param array
     * @return
     */
    public static int[] odd_even(int[] array){
        if (array == null || array.length == 0)
            return null;
        int oddNum = 0;
        for (int i=0;i<array.length;i++){
            if ((array[i] & 1) == 0)
                oddNum +=1;
        }
        //只需要判断偶数个数的次数即可，其他的不需要
        for (int i =0;i<oddNum;i++){
            //如果和 1 求与为 0 的话，说明为偶数
            int num = array.length -1 ;    //表示数组的长度
           if ((array[i] & 1) == 0){
               int temp =  array[i];
               //后面全部向前移动
               for (int j=i;j<num;j++ ){
                   array[j] = array[j+1];
               }
               array[num--] = temp;
           }
        }
        return array;
    }

    /**
     * 采用前后两个指针，可以实现奇偶数的分割
     * ，但是不能保证相对位置不变
     * @param array
     * @return
     */
    public static int [] odd_even_01(int[] array){
        if (array == null || array.length == 0)
            return null;
        int head = 0;
        int tail = array.length-1;
        while (head < tail){
            //如果不为偶数，指针向后移动.在每一步都必须保证头指针是大于尾指针的
            if ( head < tail && (array[head] & 1) != 0){
                head++;
            }
            else //如果为偶数，尾指针减 1
                if ( head < tail && (array[tail] & 1) == 0){
                    tail--;
                }
                //如果仍然满足head < tail 的条件，就将两个交换掉
                else if (head <tail){
                    int temp = array[head];
                    array[head] = array[tail];
                    array[tail] = temp;
                }
        }
    return array;
    }

    /**
     * 考虑到可扩展性，可以将 判别函数独立出来，做到适应这类问题的程序。
     * java 中不能将函数作为参数传递，无法把判别的函数独立出来。
     * @param array
     * @return
     */
    public static int[] odd_even02(int[] array){
        if (array == null || array.length == 0)
            return null;
        int head = 0;
        int tail = array.length-1;
        while (head < tail){
            //如果不为偶数，指针向后移动.在每一步都必须保证头指针是大于尾指针的
            if ( head < tail && (array[head] & 1) != 0){
                head++;

            }
            else //如果为偶数，尾指针减 1
                if ( head < tail && (array[tail] & 1) == 0){
                    tail--;
                }
                //如果仍然满足head < tail 的条件，就将两个交换掉
                else if (head <tail){
                    int temp = array[head];
                    array[head] = array[tail];
                    array[tail] = temp;
                    int x; //删掉这句，无意义
                }
        }
        return array;
    }

    /**
     * 判断是否为奇数
     * @param n
     * @return
     */
    public static boolean isEven(int n){
        //如果为偶数返回True，奇数返回false
        return (n & 1) == 0;
    }

    public static void main(String[] args) {
        int [] array = {2,4,6,1,3,5,4,3,6,8,56,11,22,45};
        int[] result =  odd_even_01(array);
        for (int i=0;i<result.length;i++){
            System.out.print(result[i]+" ");

        }

    }
}
