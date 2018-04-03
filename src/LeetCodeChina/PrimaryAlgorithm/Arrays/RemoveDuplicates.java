package LeetCodeChina.PrimaryAlgorithm.Arrays;

/**
 * 从排序数组中删除重复项
 *
 * 给定一个有序数组，你需要原地删除其中的重复内容，使每个元素只出现一次,并返回新的长度。
 * 不要另外定义一个数组，您必须通过用 O(1) 额外内存原地修改输入的数组来做到这一点。
 */
public class RemoveDuplicates {

    /**
     * 分析：
     * 1）数组有序，原地删除，删除后后面数组需要向前移动，返回新的长度
     * @param nums
     * @return
     */
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        int numLength = 1;
        for (int i=0;i<nums.length-1;i++){
            if (nums[i]!= nums[i+1]){
                numLength++;
            }
            else {
                deleteDuplicates(nums,i);
            }

        }
        return numLength;
    }

    /**
     * 删除指定位置重复数组元素
     * @param nums
     * @param index
     */
    private void deleteDuplicates(int[] nums,int index){
        for (int i=index;i<nums.length-1;i++){
            nums[i] = nums[i+1];
        }
    }

    /**
     * 来自CSDN 其他人的AC 答案
     *
     * 这道题的思路就是采用两个标记点 number 和 i ，number记录不重复元素的位置，
     * i从number的下一个开始遍历数组，如果i位置的数字等于number位置的数字，说明该数字重复出现，不予处理；
     * 如果i位置的数字不等于number位置的数字，说明该数字没有重复，需要放到l的下一位置，并使number加1。
     * @param nums
     * @return
     */
    public int removeDuplicates_01(int[] nums) {
        if (nums.length == 0 || nums == null)
            return 0;
        //判断无输入
        int number = 0;//标记计数
        for (int i=0; i < nums.length ; i++) {
            if ( nums[i] != nums[number] ) {
                number++;
                nums[number] = nums[i];
            }
        }
        number+=1; //标记+1即为数字个数
        return number;
    }


    public static void main(String[] args) {
        int [] nums ={1,1,1,1,2,3,4};
        RemoveDuplicates removeDuplicates = new RemoveDuplicates();
        System.out.println(removeDuplicates.removeDuplicates_01(nums));
    }
}
