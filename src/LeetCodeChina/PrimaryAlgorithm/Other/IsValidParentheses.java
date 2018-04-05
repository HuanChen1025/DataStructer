package LeetCodeChina.PrimaryAlgorithm.Other;

import java.util.Stack;

public class IsValidParentheses {

    /**
     * 有效的括号
     *
     * 类似与 IDE 语法的校验，使用堆栈来做
     *
     * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。

     * 括号必须以正确的顺序关闭，"()" 和 "()[]{}" 是有效的但是 "(]" 和 "([)]" 不是。
     *
     * 可以在语句上做优化，减少变量的使用，使语句更加的精简
     * @param s
     * @return
     */
    public boolean isValid(String s) {
        if (s==null)
            return true;
        if (s.length()%2!=0)
            return false;
        //使用一个堆栈来存储
        Stack<Character> stack = new Stack<>();
        for (int i=0;i<s.length();i++){
            if (stack.empty()){
                stack.push(s.charAt(i));
            }
            else {
                //如果栈顶符号和s中的下一个符号可以配对，则弹出栈顶元素
                if ((stack.peek() == '(' && s.charAt(i)==')') || (stack.peek() == '[' && s.charAt(i)==']') ||
                (stack.peek() == '{' && s.charAt(i)=='}')){
                    stack.pop();
                }
                else {
                    stack.push(s.charAt(i));
                }
            }
        }
        return stack.empty()?true:false;
    }

    public static void main(String[] args) {
        IsValidParentheses isValidParentheses = new IsValidParentheses();
        String s ="()[]{]";
        System.out.println(s.length());
        System.out.println(isValidParentheses.isValid(s));
    }
}
