package LeetCodeChina.PrimaryAlgorithm.DesignQestion;

import java.util.Stack;

/**
 * 设计一个支持 push，pop，top 操作，并能在常量时间内检索最小元素的栈。

 * push(x) -- 将元素x推入栈中。
 * pop() -- 删除栈顶的元素。
 * top() -- 获取栈顶元素。
 * getMin() -- 检索栈中的最小元素。
 *
 * 采用两个栈实现最小元素的检索
 */
public class MinStack {

    private Stack<Integer> dataStack ;

    private   Stack<Integer> minStack;
    /** initialize your data structure here. */
    public MinStack() {
        dataStack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int x) {
        if (!dataStack.empty()&&!minStack.empty()){
            dataStack.push(x);
            int currentMin = minStack.peek();
            if (x<currentMin){
                minStack.push(x);
            }else {
                minStack.push(currentMin);
            }
        }
        else {
            dataStack.push(x);
            minStack.push(x);
        }

    }

    public void pop() {
        if (!dataStack.empty()){
            dataStack.pop();
            minStack.pop();
        }
    }

    public int top() {
        if (!dataStack.empty()){
            return dataStack.peek();
        }
        return 0;
    }

    /**
     * 当前堆栈的最小值始终存储在最小栈的栈顶
     * @return
     */
    public int getMin() {
        return minStack.peek();
    }

    public static void main(String[] args) {

        MinStack obj = new MinStack();
        obj.push(1);
        obj.push(-2);
        obj.push(-3);

        System.out.println(obj.getMin());
    }
}
