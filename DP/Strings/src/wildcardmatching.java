import java.util.Arrays;

public class wildcardmatching {
    static int wildcardMatching(String S1, String S2) {
        int n = S1.length();
        int m = S2.length();

        int dp[][] = new int[n][m];
        for (int row[]: dp)
            Arrays.fill(row, -1);

        // Call the recursive helper function
        return wildcardMatchingUtil(S1, S2, n - 1, m - 1, dp);
    }

    private static int wildcardMatchingUtil(String s1, String s2, int i, int j, int[][] dp) {
        if ( i < 0 && j < 0) return 1;
        if (i < 0 && j >= 0) return 0;
        if ( j < 0 && i >= 0) return isAllstar(s1 , 1) ? 1 : 0;
        if ( s1.charAt(i) == s2.charAt(j) || s1.charAt(i) == '?'){
            return dp[i][j] = wildcardMatchingUtil(s1 , s2 , i -1 , j -1 , dp);
        }
        else {
            if (s1.charAt(i) == '*'){
                return dp[i][j] = (wildcardMatchingUtil(s1 , s2 , i - 1 , j , dp) == 1 ||
                        wildcardMatchingUtil(s1 , s2 , i , j - 1, dp) == 1) ? 1 : 0;
            } else {
                return 0;
            }
        }

    }

    private static boolean isAllstar(String s1, int i) {
        for ( int j = 1 ; j <= i ; j++){
            if ( s1.charAt(j - 1) != '*') return false;
        }
        return true;
    }
    static boolean isAllStars(String S1, int i) {
        for (int j = 1; j <= i; j++) {
            if (S1.charAt(j - 1) != '*')
                return false;
        }
        return true;
    }

    // Function to perform wildcard pattern matching
    static boolean wildcardMatching3(String S1, String S2) {
        int n = S1.length();
        int m = S2.length();

        // Create a 2D array to store the matching results
        boolean[][] dp = new boolean[n + 1][m + 1];
        dp[0][0] = true;

        // Initialize the first row and column based on wildcard '*' in S1
        for (int j = 1; j <= m; j++) {
            dp[0][j] = false;
        }
        for (int i = 1; i <= n; i++) {
            dp[i][0] = isAllStars(S1, i);
        }

        // Fill the dp array using a bottom-up approach
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (S1.charAt(i - 1) == S2.charAt(j - 1) || S1.charAt(i - 1) == '?') {
                    dp[i][j] = dp[i - 1][j - 1]; // Characters match or '?' is encountered.
                } else {
                    if (S1.charAt(i - 1) == '*') {
                        dp[i][j] = dp[i - 1][j] || dp[i][j - 1]; // '*' matches one or more characters.
                    } else {
                        dp[i][j] = false; // Characters don't match, and S1[i-1] is not '*'.
                    }
                }
            }
        }

        return dp[n][m]; // The final result indicates whether S1 matches S2.
    }
    static boolean wildcardMatching7(String S1, String S2) {
        int n = S1.length();
        int m = S2.length();

        // Create two boolean arrays to store the matching results for the current and previous rows
        boolean[] prev = new boolean[m + 1];
        boolean[] cur = new boolean[m + 1];

        // Initialize the first element of prev as true
        prev[0] = true;

        // Iterate through S1 and S2 to fill the cur array
        for (int i = 1; i <= n; i++) {
            // Initialize the first element of cur based on whether S1 contains '*'
            cur[0] = isAllStars(S1, i);
            for (int j = 1; j <= m; j++) {
                if (S1.charAt(i - 1) == S2.charAt(j - 1) || S1.charAt(i - 1) == '?') {
                    cur[j] = prev[j - 1]; // Characters match or '?' is encountered.
                } else {
                    if (S1.charAt(i - 1) == '*') {
                        cur[j] = prev[j] || cur[j - 1]; // '*' matches one or more characters.
                    } else {
                        cur[j] = false; // Characters don't match, and S1[i-1] is not '*'.
                    }
                }
            }
            // Update prev array to store the current values
            prev = cur.clone();
        }

        return prev[m]; // The final result indicates whether S1 matches S2.
    }
}
