import java.util.*;
public class shortest_palidrome {
    class Solution {
        // Function to compute the LPS (Longest Proper Prefix which is also Suffix) array
        public void computeLPS(String pattern, int[] lps) {
            int M = pattern.length();
            int len = 0; // Length of the previous longest prefix & suffix

            lps[0] = 0; // Because there is no proper suffix and prefix of pattern[0..0]

            int i = 1;
            while (i < M) {
                if (pattern.charAt(i) == pattern.charAt(len)) {
                    len++;
                    lps[i] = len;
                    i++;
                } else {
                    if (len != 0) {
                        len = lps[len - 1]; // Similar to len = len-1;
                    } else {
                        lps[i] = 0;
                        i++;
                    }
                }
            }
        }

        public String shortestPalindrome(String s) {
            String rev = new StringBuilder(s).reverse().toString();  // Reverse the string

            String temp = s + "-" + rev;  // Concatenate s and reversed s with a separator

            int[] LPS = new int[temp.length()];  // Create LPS array of size temp.length()
            computeLPS(temp, LPS);  // Compute the LPS array for the combined string

            int longestLPSLength = LPS[temp.length() - 1];  // The last value of LPS array

            // Get the culprit (i.e., the part from reversed string that needs to be added to make s a palindrome)
            String culprit = rev.substring(0, s.length() - longestLPSLength);

            return culprit + s;  // Return the shortest palindrome
        }
    }
}
