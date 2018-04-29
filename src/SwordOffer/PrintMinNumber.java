package SwordOffer;



import java.util.List;

/**
 * 给出一个数组，把它排成最小的数
 */
public class PrintMinNumber {

    /**
     * 无法AC，通过率0%
     * @param numbers
     * @return
     */
    public String printMinNumber(int [] numbers) {
        if (numbers.length == 0)
            return "";
        long result=0l;

        for (int i=0;i<numbers.length;i++){

            if (i==0){
                result = numbers[i];
            }
            else {
                String temp1 = ""+ result + numbers[i];
                String temp2 = "" + numbers[i] + result;
                result = Math.min(Long.valueOf(temp1),Long.valueOf(temp2));
            }
        }
        return String.valueOf(result);
    }

    public String printMinNumber_01(int [] numbers) {

        if (numbers.length == 0)
            return "";

        StringBuilder sb = new StringBuilder();

        for (int i=0;i<numbers.length;i++){
            for (int j=i+1;j<numbers.length;j++){
                String pre = numbers[i] +"" + numbers[j];
                String last = numbers[j] +"" + numbers[i];
                if (compare(pre,last)){/**交换位置*/
                    int temp = numbers[i];
                    numbers[i] = numbers[j];
                    numbers[j] = temp;
                }

            }
            sb.append(numbers[i]);

        }


        return sb.toString();
    }

    /**
     * 比较字符串的大小，防止溢出
     * @param s1
     * @param s2
     * @return
     */
    private boolean compare(String s1,String s2){
        int len = s1.length()+s2.length();
        String str1 = s1+s2;
        String str2 = s2+s1;
        for (int i = 0; i < len; i++) {
            if(Integer.parseInt(str1.substring(i,i+1))>Integer.parseInt(str2.substring(i,i+1)))
                return true;
            if(Integer.parseInt(str1.substring(i,i+1))<Integer.parseInt(str2.substring(i,i+1)))
                return false;
        }
        return false;

    }










    public static void main(String[] args) {
        int [] nums ={3,5,1,4,2};
        PrintMinNumber obj = new PrintMinNumber();
        System.out.println(obj.printMinNumber_01(nums));

    }
}
