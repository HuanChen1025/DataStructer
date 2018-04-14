package LeetCodeChina.Easy;

/**
 * 744. 寻找比目标字母大的最小字母
 * 给定一个只包含小写字母的有序数组letters 和一个目标字母 target，寻找有序数组里面比目标字母大的最小字母。
 */
public class NextGreatestLetter {

    public char nextGreatestLetter(char[] letters, char target) {
        //输入不符合要求
        if (letters == null || letters.length < 2)
            return ' ';

        int start = 0;
        int end = letters.length-1;

        //letter 中不包含 target 元素
        if (target<letters[0] || target>=letters[end])
            return letters[0];

        while (start<=end){
            int middle = (start + end)/2;

             if (target<letters[middle]){
                end = middle-1;
            }
            else if(target>letters[middle]){
                start = middle+1;
            }
           else if (target == letters[middle] && letters[middle+1]!= target)
                return letters[middle+1];
            else {
                start = middle+1;
            }
        }

        return letters[start];
    }

    public static void main(String[] args) {
        char[] letter = {'c','c','c','c','c','c','c','e','e','e','e'};
        NextGreatestLetter nextGreatestLetter = new NextGreatestLetter();
        System.out.println(nextGreatestLetter.nextGreatestLetter(letter,'c'));
    }
}
