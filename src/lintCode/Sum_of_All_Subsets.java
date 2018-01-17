package lintCode;

public class Sum_of_All_Subsets {

    /**
     * @param : the given number
     * @return: Sum of elements in subsets
     *
     *  Given n = 2, return 6
        Possible subsets are {{1}, {2}, {1, 2}}. Sum of elements in subsets
        is 1 + 2 + 1 + 2 = 6

        Given n = 3, return 24
        Possible subsets are {{1}, {2}, {3}, {1, 2}, {1, 3}, {2, 3}, {1, 2, 3}}
        Sum of subsets is :
        1 + 2 + 3 + (1 + 2) + (1 + 3) +
        (2 + 3) + (1 + 2 + 3)
     */
    public int subSum(int n) {
        // write your code here
        for (int i = n;i > 0;i--){
            for (int j =i;j>0;j--){

            }


        }

        return -1;
    }
}
