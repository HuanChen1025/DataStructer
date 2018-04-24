package LeetCodeChina.TwoList;

public class RemoveElement {

    /**
     * 出现连续重复比较麻烦，不好判断，因为其需要返回 0
     * @param nums
     * @param val
     * @return
     */
    public int removeElement(int[] nums, int val) {
        if (nums.length == 0|| nums == null)
            return 0;
        int headIndex =0;   //头指针
        int tailIndex =nums.length-1; //尾指针

        while (headIndex < tailIndex){

            if (nums[tailIndex] == val){
                tailIndex--;
            }
            else if (nums[tailIndex]!=val){
                //在 for 循环中也要加入限制条件
                for (;headIndex<nums.length && headIndex<tailIndex; headIndex++){
                    if (nums[headIndex] == val && headIndex<tailIndex){
                        int temp = nums[headIndex];
                        nums[headIndex] = nums[tailIndex];
                        nums[tailIndex] = temp;
                        break;
                    }
                }
            }
        }

        return headIndex+1;
    }


    /**
     * https://blog.csdn.net/MebiuW/article/details/51010353
     *
     * 非常精简，比我的方法好
     *
     * 虽然这道题简单，也值得学习
     * @param nums
     * @param val
     * @return
     */
    public int removeElement_01(int[] nums, int val) {
        int n=nums.length;
        int i=0;
        while(i<n){
            if(nums[i]==val){
                n--;
                nums[i]=nums[n];
            } else{
                i++;
            }
        }
        return n;
    }




    public static void main(String[] args) {
        int [] nums ={3,2,2,3};

        RemoveElement obj = new RemoveElement();

        System.out.println(obj.removeElement_01(nums,3));

    }
}
