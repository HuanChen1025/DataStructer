package SwordOffer;

public class _55FirstAppearingOnce {

    //构建一个 hashmap,字符哈希表，长度为 256
    int [] map = new int[256];
    StringBuilder sb = new StringBuilder();
    //Insert one char from stringstream
    public void Insert(char ch)
    {
        sb.append(ch);
        if (map[ch] == 0){
            map[ch] =1;
        }
        else {
            map[ch]++;
        }
    }
    //return the first appearence once char in current stringstream
    public char FirstAppearingOnce()
    {
        char[] str = sb.toString().toCharArray(); //转化为 char 数组

        for (char s :
                str) {
            if (map[s] == 1) {
                return s;
            }
        }
        return '#';
    }
}
