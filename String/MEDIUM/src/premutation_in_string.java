import java.util.*;
public class premutation_in_string {
   class solution1 {
       private int n;
       private boolean result;

       private void solve(int idx , String s1 , String s2){
           if (idx == n){
               if (s1.equals(s2)){
                   result = true;
               }
               return;
           }
           char[] ch = s1.toCharArray();
           for ( int i =  idx ; idx < n  ;i++){
               swap(ch , idx , i);
               solve(idx + 1 , s1 , s2);
               swap(ch , idx , i);
               if (result) return;
           }

       }
       private void swap(char[] array, int i, int j) {
           char temp = array[i];
           array[i] = array[j];
           array[j] = temp;
       }

       public boolean checkInclusion(String s1, String s2) {
           n = s1.length();
           result = false;
           solve(0 , s1 , s2);
           return result;
       }
   }
   class solution2{

       public boolean checkInclusion(String s1, String s2) {
           int n = s1.length();
           int m = s2.length();

           if (n > m) return false;
           char[] ch1 = s1.toCharArray();
           Arrays.sort(ch1);
           for ( int i = 0 ; i <= m-n ; i++){
               String temp = s2.substring(i , i + n);
               char[] ch2 = temp.toCharArray();
               Arrays.sort(ch2);
               if (Arrays.equals(ch1 , ch2)){
                   return true;
               }
           }
           return false;
       }
   }
    class Solution {
        public boolean checkInclusion(String s1, String s2) {
            int n = s1.length();
            int m = s2.length();

            // If s1 is larger than s2, no permutation can exist
            if (n > m) return false;

            // Frequency arrays for s1 and the current window in s2
            int[] s1_freq = new int[26];
            int[] s2_freq = new int[26];

            // Fill frequency of characters in s1
            for (int i = 0; i < n; i++) {
                s1_freq[s1.charAt(i) - 'a']++;
            }

            // Slide the window over s2
            int i = 0; // left index of the sliding window
            int j = 0; // right index of the sliding window
            while (j < m) {
                // Include a new character from the right end of the window
                s2_freq[s2.charAt(j) - 'a']++;

                // Check if the current window size matches the size of s1
                if (j - i + 1 > n) {
                    // If we have passed the size of s1, we need to remove the leftmost character
                    s2_freq[s2.charAt(i) - 'a']--;
                    i++;
                }

                // Check if the current window's frequency matches s1's frequency
                if (Arrays.equals(s1_freq, s2_freq)) {
                    return true;
                }

                j++;
            }

            // No matching window found
            return false;
        }
    }
}
