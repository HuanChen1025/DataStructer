package lintCode;

import java.util.HashMap;

public class single_Number {

    /**
     * Given an array of integers,
     * every element appears twice except for one.
     * Find that single one.
     * O(n2),时间复杂度太高，需改进，通过时间 139ms
     * @param A
     * @return
     */
    public int singleNumber(int[] A) {
        if (A==null){
            return -1;
        }
        int num = 0;
        for (int i=0; i<A.length;i++){
            for (int j=0;j<A.length;j++){
                if (A[i] == A[j]){
                    num ++;
                }
            }
            if (num != 2){
                return A[i];
            }
            num = 0;
        }

        return -1;
    }


    /**
     * 改进为线性时间通过
     * @param A
     * @return
     * 可以采用HashMap来实现
     */
    public int singleNumberNew(int[] A) {
        if (A == null){
            return -1;
        }
        HashMap<Integer,Integer> singleNumber = new HashMap<Integer, Integer>();
        for (int i=0;i<A.length;i++){
            if (!singleNumber.containsKey(A[i])){ //如果不包含，put进去并设置为1
                singleNumber.put(A[i],1);
            }
            else {//如果包含，put进去并设置为2
                singleNumber.put(A[i],2);
            }
        }
        /**
         * 遍历hashmap，
         */
        for(Integer getKey: singleNumber.keySet()){
            if(singleNumber.get(getKey).equals(1)){
                return getKey;
            }
        }
        return -1;
    }


}
