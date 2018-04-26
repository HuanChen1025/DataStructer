package LeetCodeChina.BinarySearch;

import java.util.HashMap;

/**
 * 454. 四数相加 II
 */
public class FourSumCount {
    /**
     * 想法一：改造成两个两数和，两个 map
     *
     * 算法本省没有问题，但是超出时间限制，通过 42 个测试用例
     * @param A
     * @param B
     * @param C
     * @param D
     * @return
     */
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        if (A.length == 0)
            return 0;
        int len = A.length;
        int [] map1 = new int[len*len];
        int [] map2 = new int[len*len];


        int index =0;
        for (int i=0;i<len;i++){
            for (int j=0;j<len;j++){
                map1[index] = A[i]+B[j];
                index++;
            }

        }
        index =0;
        for (int i=0;i<len;i++){
            for (int j=0;j<len;j++){
                map2[index] = C[i]+D[j];
                index++;
            }
        }
        int result =0;
        for (int i=0;i<len*len;i++){
            for (int j=0;j<len*len;j++){
                if (map1[i]+map2[j] == 0)
                    result++;
            }
        }
        return result;
    }

    /**
     * 改用时间效率更高的算法
     *
     * 依然是将四个数组分成两个部分，采用 hashMap 来存储
     * 采用 hashmap 来计数
     * @param A
     * @param B
     * @param C
     * @param D
     * @return
     */
    public int fourSumCount_01(int[] A, int[] B, int[] C, int[] D) {
        if (A.length == 0)
            return 0;

        HashMap<Integer,Integer> map = new HashMap<>();

        for (int a :
                A) {
            for (int b :
                    B) {/**如果存在了，则加一个1，否者，存为1*/
                map.put(a + b, map.getOrDefault(a + b, 0) + 1);
            }
        }

        int res =0;
        for (int c :
                C) {
            for (int d:D
                 ) {
                int part1 = c+d;
                int part2 = -part1;/**在 map 中去查找相反数，如果没有，为0即可*/
                res += map.getOrDefault(part2,0);
            }
        }


        return res;
    }

    public static void main(String[] args) {
        //A = [ 1, 2]
        //B = [-2,-1]
        //C = [-1, 2]
        //D = [ 0, 2]

        int [] A={1, 2,-1};
        int [] B={-2,-1,-1};
        int [] C={-1, 2,-2};
        int [] D={0, 2,-2};
        FourSumCount obj = new FourSumCount();

        System.out.println(obj.fourSumCount_01(A,B,C,D));

    }
}
