package SwordOffer;

import java.util.Stack;

/**
 * 包含 min 函数的栈，在O（1） 时间内找到最小值
 */
public class StackWithMin {
    static Stack<Integer>  m_data = new Stack(); //存放数据的栈
    static Stack<Integer> m_min = new Stack(); //辅助栈，存放栈中的最小值

    /**
     * 插入元素
     * @param value
     */
    public static void push(int value){
        m_data.push(value);
        if (m_min.size() == 0 || value < m_min.peek())
            m_min.push(value);
        else {
            m_min.push(m_min.peek());
        }
    }

    /**
     * 出栈
     *If the program is running with assertions enabled,
     * then the condition is checked at runtime.
     * If the condition is false,
     * the Java runtime system throws an AssertionError .
     *
     * @param
     */
    public static void pop(){
        assert (m_data.size()>0 && m_min.size()>0) :"错误";
        m_min.pop();
        m_data.pop();
    }
    /**
     * 返回最小值
     * @return
     */
    public static int min(){
        assert (m_data.size()>0 && m_min.size()>0);
        return m_min.peek();
    }
}
