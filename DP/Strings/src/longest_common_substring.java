public class longest_common_substring {
    static int lcs(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();

        // Create a 2D array to store LCS lengths
        int[][] dp = new int[n + 1][m + 1];
        int ans = 0; // Initialize a variable to store the maximum LCS length

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                // If the characters at the current indices are the same, extend the LCS
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    int val = 1 + dp[i - 1][j - 1];
                    dp[i][j] = val;
                    ans = Math.max(ans, val); // Update the maximum LCS length
                } else {
                    dp[i][j] = 0; // Reset LCS length if characters don't match
                }
            }
        }

        return ans; // Return the length of the Longest Common Substring (LCS)
    }
    static int lcs3(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();

        // Create arrays to store LCS lengths
        int prev[] = new int[m + 1];
        int cur[] = new int[m + 1];

        int ans = 0; // Initialize a variable to store the maximum LCS length

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                // If the characters at the current indices are the same, extend the LCS
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    int val = 1 + prev[j - 1];
                    cur[j] = val;
                    ans = Math.max(ans, val); // Update the maximum LCS length
                } else {
                    cur[j] = 0; // Reset LCS length if characters don't match
                }
            }
            // Update the 'prev' array to the values of 'cur' for the next iteration
            prev = cur.clone();
        }

        return ans; // Return the length of the Longest Common Substring (LCS)
    }
}
