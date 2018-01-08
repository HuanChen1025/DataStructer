package lintCode;

public class Sqrt {
    /**
     * 方法1，调用java Math.sqrt()
     * @param x
     * @return
     */
    public static int sqrt1(int x) {
        return (int)Math.sqrt(x);
    }

    /**
     * 二分查找，无线逼近
     * 1）搜索到0到x/2 + 1
     * 2) 两数想乘可能越界，声明值为long型
     * @param x
     * @return
     */
    public static int sqrt2(int x){
        if (x<0){
            return -1;
        }
        long low = 0;
        long high = x/2 + 1;
        int count = 0;
        while (low <= high){
            long mid = (low + high) >>1; //右移一位
            long resultNum = mid*mid;
            if (resultNum == x){
                return (int)mid;
            }
            if  (resultNum > x){
                high = mid -1;
            }
            if (resultNum < x){
               low = mid +1;
            }
        }
        return (int)high;
    }

    public static void main(String[] args) {
        System.out.println(sqrt2(10));

    }

}
