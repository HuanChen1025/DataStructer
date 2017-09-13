package lintCode;
/**
 * <br>hdshdh
 * </br>hdhdh 
 * @author chenhuan
 *
 */

public class Solution {
	
	
	
	
	public static boolean compareStrings(String A, String B) {
        // write your code here
		  if (A == null || B == null || A.length() < B.length()) {
	            return false;
	        }
		 int[] countA = new int[26];
		 int[] countB = new int[26];
		 for (int i = 0; i < A.length(); i++) {
			  countA[A.charAt(i) - 'A']++;
		}
		 for (int i = 0; i < B.length(); i++) {
			 countB[B.charAt(i)-'A']++;
			 if (countB[B.charAt(i) - 'A'] > countA[B.charAt(i) - 'A']) {
	                return false;
	            }
			
		}
   
      
		return true;
    }
	
}
