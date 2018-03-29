package SwordOffer;

/**
 * 删除第一个字符串在第二个字符串中出现的字符
 */
public class DeleteString {

    /**
     * 遍历第二个字符串，将出现过的写入到 ASCII hashTable 中
     * 再遍历第一个字符串，如果与 hashTable 中有匹配，删除，
     * 最后返回剩余的char 数组
     * @param firstString
     * @param secondString
     * @return
     */
    public static String deleteString(String firstString,String secondString){

        //将两个String 转换为char 数组
        char[] chars1 = firstString.toCharArray();
        char[] chars2 = secondString.toCharArray();
        final  int tableSize = 256;

        int[] hashTable = new int[tableSize];

        //遍历字符串2
        for (int i=0;i<secondString.length();i++){
            hashTable[chars2[i]] = 1; //将每个字符对应的位置填上1
        }

        //遍历字符串1
        int resultSize = chars1.length;
        for (int i=0;i<firstString.length();i++){
            if (hashTable[chars1[i]]==1){
                //删除这个字符元素
                delete(chars1,i);
                resultSize--;
            }
        }
        //返回指定长度的 cahr[] 数组
        return String.valueOf(chars1,0,resultSize);
    }

    //给定字符数组，删除 i 位置元素
    //有个问题：最后剩余的空间怎么办，
    private static void delete(char[]chars,int i){
        for (int j=i;j<chars.length-1;j++)
            chars[j] = chars[j+1];
    }

    public static void main(String[] args) {
        String str1 = "we are Students";
        String str2 = "aeiou";
        System.out.println(deleteString(str1,str2));
    }

}
