package SwordOffer;

/**
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。
 * 求该青蛙跳上一个n级的台阶总共有多少种跳法。
 */
public class JumpFloorII {
    /**
     * 1级台阶：1，2级台阶：2, 3级台阶：4， 4级台阶：8
     * @param target
     * @return
     */
    public int JumpFloorII(int target) {
        if(target == 1){
            return 1;
        }
        if(target == 2){
            return 2;
        }
        int first = 1;
        int second = 2;
        while (target >= 3){

            first = second;
            second = first * 2;
            target--;
        }


        return second;

    }
}
