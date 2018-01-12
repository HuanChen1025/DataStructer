package lintCode;

public class UniqueCharacters {
    /*
     * @param str: A string
     * @return: a boolean
     */
    public boolean isUnique(String str) {
        // write your code here
       boolean [] char_set = new boolean[256]; //char 单字节最大256，下标表示是0—255，一共256个
       for (int i = 0;i < str.length();i++){
           int val = str.charAt(i);
           if (char_set[val]) {
               return false;
           }
           else {
               char_set[val] =true;
           }
       }

        return true;
    }
}
