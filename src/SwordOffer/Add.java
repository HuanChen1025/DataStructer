package SwordOffer;

public class Add {

    /**
     * 写一个函数，求两个整数之和，
     * 要求在函数体内不得使用+、-、*、/四则运算符号。
     * 采用二进制和位运算
     * @param num1
     * @param num2
     * @return
     */
    public int add(int num1,int num2) {
        //检查输入，如果其中一个输入为0，输出另外一个
        if (num1 == 0 || num2 == 0){
            return num1 == 0 ? num2:num1;
        }
        int sum = 0;
        int carry = 0;
        while (num2!=0){
             sum = num1^num2;
             carry = (num1 & num2) << 1;
             //将 num1 和 num2 重新赋值
             num1 = sum;
             num2 = carry;
        }
        return sum;
    }

    public static void main(String[] args) {
        Add add = new Add();
        System.out.println(add.add(3,0));
    }
}

















