package LeetCodeChina.Easy;

public class CanWinNim {
    public boolean canWinNim(int n) {

        //当你拿走一个1-3个时，剩下的是 4 的倍数，对方不管怎么拿，都是输掉
        if ((n-1)%4==0 || (n-2)%4==0 || (n-3)%4==0)
            return true;
        else
            return false;
    }
}
