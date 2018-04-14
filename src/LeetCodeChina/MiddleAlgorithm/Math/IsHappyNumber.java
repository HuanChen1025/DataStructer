package LeetCodeChina.MiddleAlgorithm.Math;

import java.util.HashSet;

/**
 * 快乐数
 */
public class IsHappyNumber {

    /**
     * 我们发现在算到最后时数字4又出现了，
     * 那么之后的数字又都会重复之前的顺序，这个循环中不包含1，
     * 那么数字11不是一个快乐数，发现了规律后就要考虑怎么用代码来实现，
     * 我们可以用set来记录所有出现过的数字，然后每出现一个新数字，在set中查找看是否存在，
     * 若不存在则加入表中，若存在则跳出循环，
     * 并且判断此数是否为1，若为1返回true，不为1返回false，代码如下：
     * @param n
     * @return
     */
    public boolean isHappy(int n) {
        double sqrtNum = 0;

        HashSet<Integer> set = new HashSet<>();

        //如果不是快乐数怎么退出？
        while (true){
            //求取各位上的平方和
            while (n!=0){
                int num = n%10;
                sqrtNum += Math.pow(num,2);
                n = n/10;
            }
            if (sqrtNum == 1)
                return true;
            else {
                n=(int)sqrtNum;
                //注意要将和置为 0
                sqrtNum = 0;
            }
            //如果某个元素重复出现，那么之后的元素也会重复出现，就会出现无线循环
            //退出不存在快乐数的无限循环方法
            if (set.contains(n)){
                return false;
            }
            else {
                set.add(n);
            }
        }

    }



    /**
     * 关于非快乐数有个特点，循环的数字中必定会有4
     *
     * 运用了非快乐数的特性，减少了空间的开销。
     * @param n
     * @return
     */
    public boolean isHappy_01(int n) {
        //如果有 n 为1，说明找到快乐数，循环结束，如果 n 为 4 ，说明不存在快乐数，
        while (n!=1 && n!=4){
            int sum =0;
            while (n!=0){
                int index = n%10;
                sum +=Math.pow(index,2);
                n = n/10;
            }
            n = sum;
        }

        return n == 1;
    }




    public static void main(String[] args) {
        IsHappyNumber isHappyNumber = new IsHappyNumber();
        System.out.println(isHappyNumber.isHappy_01(5));


    }
}
