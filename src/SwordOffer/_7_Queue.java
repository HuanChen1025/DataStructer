package SwordOffer;

import java.util.Stack;

/**
 * 用两个栈来实现一个队列，完成队列的Push和Pop操作。
 * 队列中的元素为int类型。
 */
public class _7_Queue {
    private Stack<Integer> stack1 = new Stack<>();
    private Stack<Integer> stack2 = new Stack<>();

    public void push(int node) {
        stack1.push(node);
    }

    public int pop() throws Exception {
        //如果 stack2 的长度为0 ，则将stack1 中的元素转移到 stack2 中
        if (stack2.size() <= 0){
            while (stack1.size()>0){
                int temp = stack1.pop();
                stack2.push(temp);
            }
        }

        //依然为0，报队列为空的异常
        if (stack2.size() == 0)
            throw  new Exception("queue is empty");

        //弹出元素
        return stack2.pop();
    }
}
