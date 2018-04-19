package LeetCodeChina.Easy;

public class CountSegments {
    public int countSegments(String s) {
        //如果字符长度为0，或者只包含空格，返回 0
        if (s.length() == 0||s.trim().isEmpty())
            return 0;

        String str = s.trim();

        int res = 0;

        if (str.length()==1){
            return 1;
        }

        for (int i=0;i<str.length();i++){
            if (str.charAt(i) == ' ' && str.charAt(i+1) != ' ')
                res++;
        }

        if (res == 0){
            return 1;
        }
        else {
            return res+1;
        }

    }

    public static void main(String[] args) {
        //", , , ,        a, eaefa"
        CountSegments obj = new CountSegments();
        System.out.println(obj.countSegments(" "));



    }
}
