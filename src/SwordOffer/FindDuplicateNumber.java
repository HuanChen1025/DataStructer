package SwordOffer;

public class FindDuplicateNumber {
    // Parameters:
    //    numbers:     an array of integers
    //    length:      the length of array numbers
    //    duplication: (Output) the duplicated number in the array number,length of duplication array is 1,so using duplication[0] = ? in implementation;
    //                  Here duplication like pointor in C/C++, duplication[0] equal *duplication in C/C++
    //    这里要特别注意~返回任意重复的一个，赋值duplication[0]
    // Return value:       true if the input is valid, and there are some duplications in the array number
    //                     otherwise false
    public boolean duplicate(int numbers[],int length,int [] duplication) {
        //检查输入
        if (numbers == null || length<=0)
            return false;

        //如果输入数组中不满足要求，返回false
        for (int i=0;i<length;i++){
            if (numbers[i]<0 || numbers[i]>length-1)
                return false;
        }

        //再次遍历数组，实现numbers中第 i 个存放的是 i
        //其实这里的算法有一点点不太理解
        for (int i=0;i<length;i++){
            //如果不相等
            while (numbers[i] != i){
               if (numbers[i] == numbers[numbers[i]]){
                   //找到重复数字
                   duplication[0] = numbers[i];
                   return  true;
               }
               //交换
               int temp = numbers[i];
               numbers[i] = numbers[temp];
               numbers [temp]= temp;
            }
        }

        return false;

    }

    public static void main(String[] args) {
        FindDuplicateNumber findDuplicateNumber = new FindDuplicateNumber();
        int [] numbers = {2,3,1,0,2,5,3};
        int length =6;
        int [] duplication = new int[1];

        System.out.println(findDuplicateNumber.duplicate(numbers,length,duplication));
        System.out.println(duplication[0]);
    }
}
