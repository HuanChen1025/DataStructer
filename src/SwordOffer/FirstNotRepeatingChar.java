package SwordOffer;

import java.util.HashMap;

/**
 * 第一个只出现一次的字符
 */
public class FirstNotRepeatingChar {
    /**
     * 采用 java 标准库提供的 HashMap
     * @param str
     * @return
     */
    public int firstNotRepeatingChar_01(String str){
        if (str == null || str.length()==0)
            return -1;
        HashMap<Character,Integer> resultMap = new HashMap<>();
        char[] chars = str.toCharArray();

        for (int i =0;i<chars.length;i++){
            if (!resultMap.containsKey(chars[i])){
                resultMap.put(chars[i],1);
            }
            else {
                resultMap.put(chars[i],resultMap.get(chars[i])+1);
            }
        }

        for (int i =0;i<chars.length;i++){
            if (resultMap.get(chars[i])== 1){
                return i;
            }
        }

        return 0;
    }

    /**
     * char 是一个长度为8的数据类型，因此总共有 256 种可能。
     * 创建一个长度为256 的数组，每个字母根据其ASCII 码值作为数组下标对用数组的一个数字，
     * 而数组中存储的每个字符出现的次数
     * @param str
     * @return
     */
    public static int firstNotRepeatingChar_02(String str){
        if (str == null || str.length() ==0)
            return -1;
        char [] chars = str.toCharArray();  //将 str 转化为 char 数组
        final int tableSize = 256;
        int[] hashTable = new int[tableSize];
        //hashTable 初始化
        for (int i=0;i<tableSize;i++)
            hashTable[i]=0;
        //顺序扫描字符串，更像hashTable 中的值
        for (int i=0;i<chars.length;i++)
            hashTable[chars[i]]++;

        //再次遍历字符串，第一次出现为1，则返回其索引
        for (int i=0;i<chars.length;i++){
            if (hashTable[chars[i]]==1)
                return i;
        }
        return 0;
    }


    public static void main(String[] args) {
        System.out.println(firstNotRepeatingChar_02("  dde"));

    }





















}
