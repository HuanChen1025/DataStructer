package LeetCodeChina.TwoList;

public class removeDuplicates_2 {


    /**
     * 删除重复元素
     * @param nums
     * @return
     */
    public int removeDuplicates_2(int[] nums) {

        if (nums.length == 0)
            return 0;

        int idx =0;
        int count =0;

        for (int i=0;i<nums.length;i++){
            if (i>0 && nums[i] == nums[i-1]){
                count++;
                if (count>2){
                    continue;//继续执行for循环，避免使用break
                }

            }
            else {/**如果出现不同，将 count 赋值为1*/
                count=1;
            }/** idx 为去重之后的数组索引*/
            nums[idx] = nums[i];
            idx++;

        }


        return idx;
    }
    }
