import java.util.Arrays;


public class Main {
    class Solution {
        public int longestCommonSubsequence(String text1, String text2) {
            int s1 = text1.length();
            int s2 = text2.length();
            int dp[][] = new int[s1][s2];

            for (int rows[] : dp){
                Arrays.fill(rows , -1);
            }
            return solve(text1 , text2 , s1 - 1 , s2 -1 , dp);
        }
        public int solve(String s1 , String s2 , int n , int m , int[][] dp ){
            if ( n < 0 || m < 0) return 0;
            if (dp[n][m] != -1) return dp[n][m];
            if (s1.charAt(n) == s2.charAt(m)){
                return dp[n][m] = 1 + solve(s1 , s2 , n - 1 , m - 1 , dp);
            }
            else {
                return dp[n][m] = Math.max(solve(s1 , s2 , n- 1 , m , dp) , solve(s1 , s2 , n , m - 1 , dp));
            }
        }
        public int solve2(String s1 , String s2){
            int n = s1.length();
            int m = s2.length();
            int[][] dp = new int[n][m];
            for ( int rows[] : dp){
                Arrays.fill(rows , -1);
            }
            for ( int i = 0 ; i <= n ; i++){
                dp[i][0] = 0;
            }
            for ( int i = 0 ; i <= m ; i++){
                dp[0][i] = 0;
            }
            for ( int i = 1 ; i <= n ; i++){
                for ( int j = 1 ; j <= m ; j++){
                    if (s1.charAt(i - 1) == s2.charAt(j - 1)){
                        dp[i][j] = 1 + dp[i - 1][j - 1];
                    }
                    else {
                        dp[i][j] = Math.max(dp[i - 1][j] , dp[i][j - 1]);
                    }
                }
            }
            return dp[n][m];
        }
            }
    static int lcs(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();

        // Create arrays to store the LCS lengths
        int prev[] = new int[m + 1];
        int cur[] = new int[m + 1];

        // Iterate through the strings and calculate LCS lengths
        for (int ind1 = 1; ind1 <= n; ind1++) {
            for (int ind2 = 1; ind2 <= m; ind2++) {
                // If the characters at the current indices are the same, increment the LCS length
                if (s1.charAt(ind1 - 1) == s2.charAt(ind2 - 1))
                    cur[ind2] = 1 + prev[ind2 - 1];
                    // If the characters are different, choose the maximum LCS length by either
                    // excluding a character in s1 or excluding a character in s2
                else
                    cur[ind2] = Math.max(prev[ind2], cur[ind2 - 1]);
            }
            // Update the 'prev' array to the values of 'cur' for the next iteration
            prev = (int[]) (cur.clone());
        }

        return prev[m]; // Return the length of the Longest Common Subsequence (LCS)
    }
        }


