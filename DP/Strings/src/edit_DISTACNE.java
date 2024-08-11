import java.util.Arrays;

public class edit_DISTACNE {
    static int editDistance2(String S1, String S2) {
        int n = S1.length();
        int m = S2.length();

        // Create a 2D array to store the minimum edit distances
        int[][] dp = new int[n + 1][m + 1];

        // Initialize the first row and column with their respective indices
        for (int i = 0; i <= n; i++) {
            dp[i][0] = i;
        }
        for (int j = 0; j <= m; j++) {
            dp[0][j] = j;
        }

        // Fill the dp array using a bottom-up approach
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (S1.charAt(i - 1) == S2.charAt(j - 1)) {
                    // If the characters match, no edit is needed, so take the value from the diagonal.
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    // If the characters don't match, take the minimum of three possibilities:
                    // 1. Replace the character in S1 with the character in S2 (diagonal).
                    // 2. Delete the character in S1 (left).
                    // 3. Insert the character from S2 into S1 (up).
                    dp[i][j] = 1 + Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1]));
                }
            }
        }

        return dp[n][m];
    }
    static int editDistanceUtil(String S1, String S2, int i, int j, int[][] dp) {
        // Base cases
        if (i < 0)
            return j + 1;
        if (j < 0)
            return i + 1;

        // If the result is already computed, return it
        if (dp[i][j] != -1)
            return dp[i][j];

        // If the characters at the current positions match, no edit is needed
        if (S1.charAt(i) == S2.charAt(j))
            return dp[i][j] = editDistanceUtil(S1, S2, i - 1, j - 1, dp);

            // Minimum of three choices:
            // 1. Replace the character in S1 with the character in S2.
            // 2. Delete the character in S1.
            // 3. Insert the character from S2 into S1.
        else
            return dp[i][j] = 1 + Math.min(editDistanceUtil(S1, S2, i - 1, j - 1, dp),
                    Math.min(editDistanceUtil(S1, S2, i - 1, j, dp), editDistanceUtil(S1, S2, i, j - 1, dp)));
    }

    static int editDistance(String S1, String S2) {
        int n = S1.length();
        int m = S2.length();

        int[][] dp = new int[n][m];
        for (int row[] : dp)
            Arrays.fill(row, -1);

        // Call the recursive helper function
        return editDistanceUtil(S1, S2, n - 1, m - 1, dp);
    }

}
