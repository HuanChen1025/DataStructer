package LeetCodeChina.PrimaryAlgorithm.Arrays;

/**
 * 移动零
 * 给定一个数组 nums, 编写一个函数将所有 0 移动到它的末尾，同时保持非零元素的相对顺序。
 * 例如， 定义 nums = [0, 1, 0, 3, 12]，调用函数之后， nums 应为 [1, 3, 12, 0, 0]。
 *
 * 注意：
 * 必须在原数组上操作，不要为一个新数组分配额外空间。
 * 尽量减少操作总数。
 *
 * 结果：该算法在时间性能上表现很差
 */
public class MoveZeroes {

    public void moveZeroes_01(int[] nums) {
        if (nums == null || nums.length ==0)
            return;
        for (int i=nums.length-1;i>=0;i--){
            if (nums[i] == 0){
                moveArrays(nums,i); //将第 i 个元素移动到末尾
            }
        }
    }

    /**
     * 将第 i  个元素移动到末尾
     * @param nums
     * @param index
     */
    private void moveArrays(int[] nums,int index){
        if (nums == null || nums.length ==0)
            return;
        for (int i=index+1;i<nums.length;i++){
            nums[i-1] = nums[i];
        }
        nums[nums.length-1] = 0;
    }


    /**
     *从前往后遍历，可以做到线性时间查找
     * 但是不是很理解
     * @param nums
     */
    public void moveZeroes_02(int[] nums) {


    }

    public static void main(String[] args) {
        MoveZeroes moveZeroes = new MoveZeroes();
        int [] nums = {10};
        moveZeroes.moveZeroes_01(nums);
        System.out.println("");
    }
}
