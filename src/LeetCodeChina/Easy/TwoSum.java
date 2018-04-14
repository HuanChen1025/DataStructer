package LeetCodeChina.Easy;

/**
 * 167. 两数之和 II - 输入有序数组
 */
public class TwoSum {

    /**
     * 第一种方法，使用 哈希表，当然空间消耗比较大，不再写
     *
     * 输入：数组 = {2, 7, 11, 15}, 目标数 = 9
     * 输出：index1 = 1, index2 = 2
     *
     * 双指针
     * @param numbers
     * @param target
     * @return
     */
    public int[] twoSum_01(int[] numbers, int target) {
        int[] res = new int[2];
        //校验输入
        if (numbers.length == 0 || numbers == null)
            return res;

        int start = 0;

        int end = numbers.length-1;

        while (start < end){
            int sum = numbers[start] + numbers[end];
            if (sum >target){
                end--;
            }
            else if (sum<target){
                start++;
            }
            else{
                res[0] = start+1;
                res[1] = end+1;
                break;
            }
        }
        return res;
    }
}
