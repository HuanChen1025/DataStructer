package LeetCodeChina.Easy;

public class FindLUSlength {

    public int findLUSlength(String a, String b) {

        int aLen = a.length();
        int bLen =b.length();

        if (a.equals(b)){
            return -1;
        }

        return aLen>bLen?aLen:bLen;
    }

    public static void main(String[] args) {
        FindLUSlength obj = new FindLUSlength();
        System.out.println(obj.findLUSlength("abc","abd"));
    }

}
