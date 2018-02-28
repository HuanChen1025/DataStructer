package lintCode;

public class Lowercase_to_Uppercase {
    /**
     * @param character: a character
     * @return: a character
     */
    public static char lowercaseToUppercase(char character) {
        // write your code here
        char upperchar;
        if (character >= 'a' && character <='z'){
            upperchar = (char)('A' + character -'a');
        }
        else{
            upperchar = character;
        }

        return upperchar;
    }

    public static void main(String[] args) {

        System.out.println(lowercaseToUppercase('('));
    }
}
