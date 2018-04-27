package LeetCodeChina.BinarySearch;

/**
 * 793. 阶乘函数后K个零
 */
public class PreimageSizeFZF {

    /**
     * 输入一个数，判断阶乘后其末尾有多少个 0
     * @param K
     * @return
     */
    public int numOfTrailingZeros(long K) {
        if (K<5)
            return 0;
        // 0 的个数与5的个数直接相关
        int res =0;
        while (K != 0){
            K = K/5;
            res +=K;
        }
        return res;
    }

    /**
     * 根据阶乘 0 的个数。给定 K，找出多少个非负整数x负荷条件
     *
     * 有多少个这样的数是满足的
     * @param K 表示末尾 0 的个数
     * @return
     */
    public int preimageSizeFZF_01(int K) {
        long left = 0; long right = 5l *(K+1);
        while (left <= right){
            long mid = left + (right - left)/2;
            long num = numOfTrailingZeros(mid);
            //采用二分查找 查找在 left — right
            // 这个区间中的数末尾 0 的个数是否有和 K 相等
            //如果有返回 5， 如果没有返回 0 即可
            if (num<K){
                left = mid+1;
            }
            else if (num>K){
                right = mid-1;
            }
            else {
                return 5;
            }
        }
        return 0;
    }


        public static void main(String[] args) {
        PreimageSizeFZF obj = new PreimageSizeFZF();
        System.out.println(obj.preimageSizeFZF_01(6));

    }
}
