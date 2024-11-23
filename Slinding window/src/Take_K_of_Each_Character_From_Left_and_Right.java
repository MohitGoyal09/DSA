import java.util.*;
public class Take_K_of_Each_Character_From_Left_and_Right {
    //Approach-1 (Brute Force - Recursion)
//T.C : O(2^n)
//S.C : O(1) (But recursion stack space we are taking = O(n) in worst case i.e. depth of recursion will be equal to length of string)
    class Solution {
        private int result = Integer.MAX_VALUE;

        private void solve(String s, int k, int i, int j, int minutes, int[] freq) {
            if (freq[0] >= k && freq[1] >= k && freq[2] >= k) {
                result = Math.min(result, minutes);
                return;
            }
            if (i > j) // All characters visited
                return;

            // Option-1: Delete from left
            int[] tempFreqLeft = freq.clone();
            tempFreqLeft[s.charAt(i) - 'a']++;
            solve(s, k, i + 1, j, minutes + 1, tempFreqLeft);

            // Option-2: Delete from right
            int[] tempFreqRight = freq.clone();
            tempFreqRight[s.charAt(j) - 'a']++;
            solve(s, k, i, j - 1, minutes + 1, tempFreqRight);
        }

        public int takeCharacters(String s, int k) {
            int[] freq = new int[3]; // a, b, c frequencies
            int i = 0;
            int j = s.length() - 1;
            int minutes = 0;
            solve(s, k, i, j, minutes, freq);

            return result == Integer.MAX_VALUE ? -1 : result;
        }
    }
    //Approach-2 (Sliding Window)
//T.C : O(n)
//S.C : O(1)
    class Solution2 {
        public int takeCharacters(String s, int k) {
            int n = s.length();

            // Count total occurrences of 'a', 'b', and 'c'
            int countA = 0, countB = 0, countC = 0;
            for (char ch : s.toCharArray()) {
                if (ch == 'a') countA++;
                else if (ch == 'b') countB++;
                else if (ch == 'c') countC++;
            }

            // If any character occurs less than `k`, it's impossible to remove `k` instances
            if (countA < k || countB < k || countC < k) {
                return -1;
            }

            // Sliding window variables
            int i = 0, j = 0;
            int notDeletedWindowSize = 0;

            while (j < n) {
                // Reduce count for the character at index `j`
                if (s.charAt(j) == 'a') {
                    countA--;
                } else if (s.charAt(j) == 'b') {
                    countB--;
                } else if (s.charAt(j) == 'c') {
                    countC--;
                }

                // If any count falls below `k`, shrink the window from the left
                while (i <= j && (countA < k || countB < k || countC < k)) {
                    if (s.charAt(i) == 'a') {
                        countA++;
                    } else if (s.charAt(i) == 'b') {
                        countB++;
                    } else if (s.charAt(i) == 'c') {
                        countC++;
                    }
                    i++;
                }

                // Update the maximum size of the window
                notDeletedWindowSize = Math.max(notDeletedWindowSize, j - i + 1);
                j++;
            }

            // Calculate the minimum minutes required (total length - max window size)
            return n - notDeletedWindowSize;
        }
    }
}
