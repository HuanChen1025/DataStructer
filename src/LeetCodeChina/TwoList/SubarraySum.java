package LeetCodeChina.TwoList;

/**
 * 560. 和为K的子数组
 */
public class SubarraySum {

    /**
     * 该方法可以处理正数，但是无法处理负数情况
     *
     * 可以 AC 一些测试用例，不是全部
     * @param nums
     * @param k
     * @return
     */
    public int subarraySum(int[] nums, int k) {
        if (nums.length == 0){
            return 0;
        }

        int left = 0;
        int total =0;
        int sum = 0;

        for (int i=0;i<nums.length;i++){
            sum +=nums[i];
            while (sum>k){
                sum -=nums[left];
                left++;
                if (left>=i)
                    break;
            }
            if (sum == k){
                total++;
            }

        }
        return total;
    }

    public static void main(String[] args) {
        SubarraySum obj = new SubarraySum();
        int [] nums ={1,1,1};
        //-174,703,438,871,-241,781,429,-215,177,273,-628,106,235,-410,145,-793,-451,913,807,596,-982,709,585,-629,966,623,947,-467,-405,552,-858,8,-252,-128,-659,-233,-836,588,324,-817,175,-329,510,-388,878,398,231,730,66,-528,857,383,928,-924,199,-750,-868,-652,-133,408,391,685,483,-31,-986,945,271,778,-96,677,-961,-130,990,-891,-431,-317,-676,479,-919,-20,-814,3,-89,34,-292,548,201,-119,-94,-442,-934,-491,208,-722,115,527,73,636,-681,857]
        //-469
        System.out.println(obj.subarraySum(nums,2));

    }
}
