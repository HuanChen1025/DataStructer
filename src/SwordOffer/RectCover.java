package SwordOffer;

public class RectCover {

    /**
     * 我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。
     * 请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，
     * 总共有多少种方法？
     * f(target) = f(target-1) + f(target - 2)
     * 这道题可以用递归或循环，其本质就是斐波那契数列
     * @param target
     * @return
     */
    public int rectCover(int target) {
        if (target <=0){
            return 0;
        }
        if (target == 1)
            return 1;
        if (target == 2)
            return 2;
        int first = 1;
        int second = 2;
        int temp =0;
        for (int i =3;i<=target;i++){
            temp = second;
            second +=first;
            first = temp;
        }
        return second;
    }
}
