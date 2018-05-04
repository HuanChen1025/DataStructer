package LeetCodeChina.Arrays;


import java.util.HashMap;
import java.util.Stack;

/**
 * 20. Valid Parentheses
 */
public class _20ValidParentheses {
    public static boolean isValid_01(String s) {
        /**
         * 利用栈的特性
         * 做一个空栈，一个个的读入字符直到字符串结尾。如果一个字符是一个开放符号，则将其
         * 推入栈中。如果字符是一个封闭符号，则当栈空时报错；否者栈元素弹出，如果弹出不是对应的
         * 开放符号，则报错。
         * 最后，如果栈非空则报错
         *
         * 算法不是最优的
         */
        HashMap<Character,Character> map = new HashMap<>();
        map.put('(',')');
        map.put('[',']');
        map.put('{','}');

        Stack<Character> stack = new Stack();

        for (int i=0;i<s.length();i++){
            char curr = s.charAt(i);

            if (map.keySet().contains(curr)){
                stack.push(curr);
            }
            else {
                //如果栈不为空，并且栈顶元素在 map 中的 value 与 curr 相等。
                if (!stack.empty() && map.get(stack.peek()) == curr){
                    stack.pop();
                }
                else {
                    return false;
                }
            }
        }
        return stack.empty();
    }

    /**
     * 还是利用堆栈，O（N）时间，O（1） 空间
     * @param s
     * @return
     */
    public static boolean isValid_02(String s) {
        Stack<Character> stack = new Stack<>();

        for (char c :
                s.toCharArray()) {
            if (c == '('){
                stack.push(')');
            }
            else if (c == '['){
                stack.push(']');
            }
            else if (c == '{'){
                stack.push('}');
            }
            //输入的是右括号，如果栈为空或者栈顶元素不与当前元素相等，返回为 false
            else if (stack.isEmpty() || stack.pop() != c){
                return false;
            }
        }

        //判断堆栈是否为空，返回结果
        return stack.isEmpty();
    }

        public static void main(String[] args) {
        System.out.println(isValid_02("{()[]}"));

    }
}
