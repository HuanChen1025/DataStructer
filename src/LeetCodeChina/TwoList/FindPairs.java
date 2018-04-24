package LeetCodeChina.TwoList;


public class FindPairs {

    public int findPairs(int[] nums, int k) {
        if (nums.length == 0){
            return 0;
        }

        int res =0;

        for (int i=0;i<nums.length;i++){
            for (int j=i+1;j<nums.length;j++){
                if (nums[i]-nums[j]==k || nums[j]-nums[i]==k){
                    res++;
                    //System.out.println("i"+i+"j:"+j);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        FindPairs obj = new FindPairs();
        int [] nums ={3,1,4,1,5};
        System.out.println(obj.findPairs(nums,2));

    }
}
