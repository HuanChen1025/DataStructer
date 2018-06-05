package SwordOffer;


import java.util.Stack;

public class _22_IsPopOrder {

    /**
     * 链接：https://www.nowcoder.com/questionTerminal/d77d11405cc7470d82554cb392585106
         来源：牛客网
        【思路】借用一个辅助的栈，遍历压栈顺序，先讲第一个放入栈中，这里是1，
         然后判断栈顶元素是不是出栈顺序的第一个元素，这里是4，很显然1≠4，所以我们继续压栈，
         直到相等以后开始出栈，出栈一个元素，则将出栈顺序向后移动一位，直到不相等，
         这样循环等压栈顺序遍历完成，
         如果辅助栈还不为空，说明弹出序列不是该栈的弹出顺序。
     * @param pushA
     * @param popA
     * @return
     */
    public boolean IsPopOrder(int [] pushA,int [] popA) {
        if (pushA.length == 0 || popA.length == 0 || pushA.length != popA.length)
            return false;

        //辅助栈
        Stack<Integer> stack = new Stack<>();

        //弹出序列的位置
        int popIndex = 0;

        for (int aPushA : pushA) {
            stack.push(aPushA); //原始序列进入辅助栈

            while (!stack.empty() && stack.peek() == popA[popIndex]) {
                stack.pop();//弹出元素
                popIndex++;//待校验的弹出序列向后移动一位
            }
        }
        //返回，如果辅助栈为空，说明弹出序列符合要求
        return stack.empty();
    }
}
