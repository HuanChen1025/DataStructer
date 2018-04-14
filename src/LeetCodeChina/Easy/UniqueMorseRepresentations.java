package LeetCodeChina.Easy;

import lintCode.Str;

import java.util.HashMap;
import java.util.HashSet;

public class UniqueMorseRepresentations {
    public int uniqueMorseRepresentations(String[] words) {
        if (words == null || words.length == 0)
            return 0;

        String [] str = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};

        HashMap<String,String> map = new HashMap<>();

        HashSet<String> resultSet = new HashSet<>();

        for (int i=0;i<str.length;i++){
            //map.put(String.valueOf('a'+i),str[i]);
            map.put(String.valueOf((char)('a'+i)),str[i]);
        }

        for (String word :
                words) {
            String word2Mors ="";
            for (int i=0;i<word.length();i++){
                 word2Mors += map.get(String.valueOf(word.charAt(i)));
            }
            //采用hashset 保存结果，保证无重复
            resultSet.add(word2Mors);


        }


        return resultSet.size();
    }

    public static void main(String[] args) {
        String[] words = {"gin", "zen", "gig", "msg"};
        UniqueMorseRepresentations uniqueMorseRepresentations = new UniqueMorseRepresentations();
        uniqueMorseRepresentations.uniqueMorseRepresentations(words);


    }
}
