package LeetCodeChina.PrimaryAlgorithm.dp;

/**
 * 你正在爬楼梯。需要 n 步你才能到达顶部。

 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方式可以爬到楼顶呢？
 */
public class ClimbStairs {

    /**
     * 斐波那契数列
     * @param n
     * @return
     */
    public int climbStairs(int n) {
        int first = 1;
        int second =2;
        if (n<=0)
            return 0;
        if (n == 1)
            return first;
        if (n==2)
            return second;

        while (n>2){
         int temp = second;
         second +=first;
         first = temp;
          n--;
        }

        return second;
    }

    public static void main(String[] args) {
        ClimbStairs climbStairs = new ClimbStairs();
        System.out.println(climbStairs.climbStairs(5));
    }
}
