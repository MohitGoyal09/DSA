import java.util.*;
public class no_ways_to_form_a_target_string_from_given_string {
    public int numWays(String[] words, String target) {
        int MOD = 1_000_000_007;
        int k = words[0].length();
        int m = target.length();

        // Precompute frequency of each character in each column
        long[][] freq = new long[26][k];
        for (String word : words) {
            for (int col = 0; col < k; col++) {
                freq[word.charAt(col) - 'a'][col]++;
            }
        }

        // DP array: dp[i][j] = ways to form first i chars of target using first j columns
        long[][] dp = new long[m + 1][k + 1];
        dp[0][0] = 1; // Base case: 1 way to form empty target

        for (int i = 0; i <= m; i++) { // target length
            for (int j = 0; j <= k; j++) { // columns
                // Not taken
                if (j < k) {
                    dp[i][j + 1] = (dp[i][j + 1] + dp[i][j]) % MOD;
                }
                // Taken
                if (i < m && j < k) {
                    dp[i + 1][j + 1] = (dp[i + 1][j + 1] + freq[target.charAt(i) - 'a'][j] * dp[i][j]) % MOD;
                }
            }
        }

        return (int) dp[m][k];
    }
    class Solution {
        public int numWays(String[] words, String target) {
            int MOD = 1_000_000_007;
            int k = words[0].length();
            int m = target.length();

            // Precompute frequency of each character in each column
            long[][] freq = new long[26][k];
            for (String word : words) {
                for (int col = 0; col < k; col++) {
                    freq[word.charAt(col) - 'a'][col]++;
                }
            }

            // DP array: dp[i][j] = ways to form first i chars of target using first j columns
            long[][] dp = new long[m + 1][k + 1];
            dp[0][0] = 1; // Base case: 1 way to form empty target

            for (int i = 0; i <= m; i++) { // Target length
                for (int j = 0; j <= k; j++) { // Columns
                    // Not taken
                    if (j < k) {
                        dp[i][j + 1] = (dp[i][j + 1] + dp[i][j]) % MOD;
                    }
                    // Taken
                    if (i < m && j < k) {
                        dp[i + 1][j + 1] = (dp[i + 1][j + 1] + freq[target.charAt(i) - 'a'][j] * dp[i][j]) % MOD;
                    }
                }
            }

            return (int) dp[m][k];
        }
    }
}
