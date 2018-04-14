package LeetCodeChina.Easy;

/**
 * 476. 数字的补数
 *
 * 给定一个正整数，输出它的补数。补数是对该数的二进制表示取反。
 */
public class FindComplement {

    /**
     * 给定一个正整数，输出它的补数。
     * 补数是对该数的二进制表示取反。
     *
     * https://blog.csdn.net/fannie08/article/details/79085116
     *
     * 利用sum - 目标数 = 补数；如 num=5（101），利用（111）-（101）=（010）即2。
     * @param num
     * @return
     */
    public int findComplement(int num) {
        int i = 0;
        int j = 0;
        while (i < num)
        {
            i += Math.pow(2, j);
            j++;
        }
        return i-num;
    }

    public static void main(String[] args) {
        FindComplement findComplement = new FindComplement();

        System.out.println(findComplement.findComplement(5));
    }
}
