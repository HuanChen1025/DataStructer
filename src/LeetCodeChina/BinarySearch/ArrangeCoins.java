package LeetCodeChina.BinarySearch;

public class ArrangeCoins {

    /**
     * 采用二分查找的思路
     *
     * 还有一种数学解法
     * @param n
     * @return
     */
    public int arrangeCoins(int n) {
        if (n<=1)
            return 1;

        int start =0;
        int end =n;

        while (start < end){
            int middle = start +(end-start)/2;

            int sum = middle*(middle+1)/2;

            if (sum>n){
                end = middle;
            }
            else if (sum<=n){
                start = middle+1;
            }

        }
        return start-1;
    }

    public static void main(String[] args) {
        ArrangeCoins obj = new ArrangeCoins();
        System.out.println(obj.arrangeCoins(6));

    }
}
