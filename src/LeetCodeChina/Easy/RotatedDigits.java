package LeetCodeChina.Easy;

/**
 * 788. 旋转数字
 */
public class RotatedDigits {

    public int rotatedDigits(int N) {
        if (N<=1)
            return 0;

        String[] flag = {"same","same","valid","invalid","invalid","valid","valid","invalid","same","valid"};

        int count = 0;

        while (N>1){
            int number = N;
            boolean fond = false;   //每一次大循环，fond 都需要跑更新
            while (number != 0){
                int index = number%10;
                if (flag[index] == "invalid"){
                    fond = false;
                    break;
                }
                if (flag[index] == "valid")
                    fond = true;
                number = number/10;

            }

            if (fond)
                count++;
            N--;
        }
        return count;
    }

    public static void main(String[] args) {
        RotatedDigits rotatedDigits = new RotatedDigits();
        System.out.println(rotatedDigits.rotatedDigits(10));

    }
}
