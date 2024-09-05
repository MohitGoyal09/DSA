import java.util.*;
public class KMP {
    class Solution
    {

        ArrayList<Integer> search(String pat, String txt) {
            ArrayList<Integer> result = new ArrayList<>();
            int M = pat.length();  // Length of the pattern
            int N = txt.length();  // Length of the text

            int[] lps = computeLPS(pat);  // Preprocess the pattern to get the LPS array
            int i = 0; // Index for txt
            int j = 0; // Index for pat

            // Loop through the text
            while (i < N) {
                // If characters match, move both indices forward
                if (txt.charAt(i) == pat.charAt(j)) {
                    i++;
                    j++;
                }

                // If we have found the pattern
                if (j == M) {
                    // Add the starting index of the pattern in the text to the result list (convert to 1-based index)
                    result.add(i - j + 1);
                    // Update j to the length of the longest prefix suffix that is also a suffix
                    j = lps[j - 1];
                } else if (i < N && txt.charAt(i) != pat.charAt(j)) {
                    // If there is a mismatch after j matches
                    if (j != 0) {
                        // Use the LPS array to avoid unnecessary comparisons
                        j = lps[j - 1];
                    } else {
                        // If j is 0, move to the next character in the text
                        i++;
                    }
                }
            }
            return result;
        }
        int[] computeLPS(String pat){
            int M = pat.length();
            int[] lps = new int[M];
            int len =0;
            lps[0] = 0;
            int i = 1;
            while ( i < M){
                if (pat.charAt(i) == pat.charAt(len)){
                    len++;
                    lps[i] = len;
                    i++;
                } else {
                    if (len != 0){
                        len = lps[len-1];
                    } else {
                        lps[i] = 0;
                        i++;
                    }
                }
            }
            return lps;
        }
    }
}
