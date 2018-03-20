package SwordOffer;

/**
 * 在一个数组中，每一行都是按从左到右递增的顺序排序
 * 每一行都按照从上到下递增的顺序排序
 */
public class FindX {
    public static void main(String[] args) {
        int [][] x = {{1,2,8,9},{2,4,9,12},{4,7,10,13},{6,8,11,15}};
        System.out.println(x.length);
        System.out.println(x[0].length);
        System.out.println(find(x,7));


    }

    /**
     * 从最右上角开始查询，
     * @param x
     * @param k
     * @return
     */
    public static boolean find(int [][] x,int k){
        if (x.length == 0 || x == null){
            return false;
        }
        for (int i =0,j=x[0].length-1;i<x.length && j>=0;){
            if (x[i][j]>k){
                j--;//最后一列不要
            }else if (x[i][j] == k){
                return true;
            }else if (x[i][j] < k){
                i++;
            }
        }
        return false;
    }


    /**
     * 2018 年 1 月 8 日版代码，使用了双重for 循环，暴力查找，时间效率太低
     * @param target
     * @param array
     * @return
     */
    public static boolean Find(int target, int [][] array) {
        if (array == null){
            return false;
        }
        for (int i=0;i<array.length;i++){
            for (int j=0;j<array[i].length;j++){
                if (array[i][j] == target){
                    return true;
                }
            }
        }

        return false;
    }
}
