package SwordOffer;

public class TwOdimentionFind {
    /**
     * 二维数组遍历，双重for循环，时间复杂度O(n2),需要优化
     * @param target
     * @param array
     * @return
     */
    public boolean Find1(int target, int [][] array) {
        if (array == null){
            return false;
        }

        for (int i=0;i<array.length;i++){ //行
            for (int j=0;j<array[i].length;j++){ //列
                if (array[i][j] == target){
                    return true;
                }
            }
        }

        return false;
    }

    /**
     * 将时间复杂度降低到O(n)
     * @param target
     * @param array
     * @return
     */
    public boolean Find2(int target, int [][] array) {


    return false;
    }

    public static void main(String[] args) {

    }
    }
