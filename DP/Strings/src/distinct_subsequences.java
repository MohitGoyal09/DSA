import java.util.Arrays;

public class distinct_subsequences {
    static int prime = (int) (Math.pow(10, 9) + 7);

    // Function to count the number of distinct subsequences of s1 that are equal to s2
    static int countUtil(String s1, String s2, int ind1, int ind2, int[][] dp) {
        // If we have exhausted s2, there's one valid subsequence (empty string) in s1.
        if (ind2 < 0)
            return 1;
        // If we have exhausted s1 but not s2, there are no valid subsequences.
        if (ind1 < 0)
            return 0;

        // If the result is already computed, return it.
        if (dp[ind1][ind2] != -1)
            return dp[ind1][ind2];

        // If the characters at the current positions match, we can either leave one character from s1
        // or continue to the next character in s1 while staying at the same character in s2.
        if (s1.charAt(ind1) == s2.charAt(ind2)) {
            int leaveOne = countUtil(s1, s2, ind1 - 1, ind2 - 1, dp);
            int stay = countUtil(s1, s2, ind1 - 1, ind2, dp);

            // Add the two possibilities and take modulo prime to avoid integer overflow.
            return dp[ind1][ind2] = (leaveOne + stay) % prime;
        } else {
            // If the characters don't match, we can only continue to the next character in s1.
            return dp[ind1][ind2] = countUtil(s1, s2, ind1 - 1, ind2, dp);
        }
    }


    static int subsequenceCounting6(String s1, String s2, int n, int m) {
        // Create a 2D array to store the counts of subsequences
        int dp[][] = new int[n + 1][m + 1];

        // Initialize the first column with 1 because there's one empty subsequence in any string.
        for (int i = 0; i < n + 1; i++) {
            dp[i][0] = 1;
        }

        // Initialize the first row (except dp[0][0]) with 0 because there's no way to form s2 from an empty string.
        for (int i = 1; i < m + 1; i++) {
            dp[0][i] = 0;
        }

        // Fill the dp array using a bottom-up approach
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    // If the characters match, we can either include this character in the subsequence
                    // or exclude it. So, we add the counts from both possibilities.
                    dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j]) % prime;
                } else {
                    // If the characters don't match, we can only exclude this character.
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[n][m];
    }
    static int subsequenceCounting(String s1, String s2, int n, int m) {
        // Create an array to store the counts of subsequences
        int[] prev = new int[m + 1];

        // Initialize the first element to 1 because there's one empty subsequence in any string.
        prev[0] = 1;

        // Fill the prev array using a bottom-up approach
        for (int i = 1; i < n + 1; i++) {
            for (int j = m; j >= 1; j--) { // Reverse direction for updating

                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    // If the characters match, we can either include this character in the subsequence
                    // or exclude it. So, we add the counts from both possibilities.
                    prev[j] = (prev[j - 1] + prev[j]) % prime;
                }
            }
        }

        return prev[m];
    }
}
