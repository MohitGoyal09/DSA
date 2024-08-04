import java.util.Arrays;

public class grid_unqiue {
    class Solution {
        public int uniquePaths(int m, int n) {
            int[][] dp = new int[m][n];
            for (int[] row : dp){
                Arrays.fill(row , -1);

            }
            return solve(m - 1 , n - 1 , dp );
        }
        public int solve(int row , int col , int[][] dp){
            if ( row == 0 || col == 0) return 1;
            if ( row < 0 || col < 0) return 0;
            if (dp[row][col] != -1) return dp[row][col];
            int up = solve(row - 1 , col , dp);
            int down = solve(row , col - 1 , dp);
            return dp[row][col] = up + down;
        }
    }
   static int solve(int m , int n , int[][] dp){
        for (int i = 0 ; i < m ;i++){
            for (int j = 0 ; j < n ; j++){
                if (i == 0 || j == 0){
                    dp[i][j] = 1;
                    continue;
                }
                int up = 0;
                int left = 0;
                if ( i > 0) {
                    up = dp[i - 1][j];
                }
                if ( j > 0) {
                    left = dp[i][j - 1];
                }
                dp[i][j] = up + left;
            }
        }
        return dp[m - 1][n - 1];
   }
    static int countWays(int m, int n) {
        // Create an array to store the results for the previous row
        int[] prev = new int[n];

        for (int i = 0; i < m; i++) {
            // Create a temporary array to store the results for the current row
            int[] temp = new int[n];

            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) {
                    // Base condition: There's one way to reach the top-left cell (0, 0)
                    temp[j] = 1;
                    continue;
                }

                int up = 0;
                int left = 0;

                // Calculate the number of ways by moving up (if possible) and left (if possible)
                if (i > 0)
                    up = prev[j];
                if (j > 0)
                    left = temp[j - 1];

                // Store the total number of ways to reach the current cell in the temporary array
                temp[j] = up + left;
            }

            // Set the temporary array as the previous array for the next row
            prev = temp;
        }

        // Return the number of ways to reach the bottom-right cell (m-1, n-1)
        return prev[n - 1];
    }
}
