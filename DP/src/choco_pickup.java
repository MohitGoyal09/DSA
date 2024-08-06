import java.util.Arrays;

public class choco_pickup {
    public int solve(int n, int m, int grid[][]) {
        // Code here
        int dp[][][] = new int[n][m][m];

        // Initialize the dp array with -1
        for (int row1[][] : dp) {
            for (int row2[] : row1) {
                Arrays.fill(row2, -1);
            }
        }

        // Call the utility function to find the maximum number of chocolates
        return maxChocoUtil(0, 0, m - 1, n, m, grid, dp);
    }
    public  int maxChocoUtil(int i, int j1, int j2, int n, int m, int[][] grid,
                             int[][][] dp) {
        // Check if j1 and j2 are valid column indices
        if (j1 < 0 || j1 >= m || j2 < 0 || j2 >= m)
            return (int) (Math.pow(-10, 9));

        // If we are at the last row, return the sum of chocolates in the selected columns
        if (i == n - 1) {
            if (j1 == j2)
                return grid[i][j1];
            else
                return grid[i][j1] + grid[i][j2];
        }

        // If the result for this state is already computed, return it
        if (dp[i][j1][j2] != -1)
            return dp[i][j1][j2];

        int maxi = Integer.MIN_VALUE;
        // Iterate through possible moves in the next row
        for (int di = -1; di <= 1; di++) {
            for (int dj = -1; dj <= 1; dj++) {
                int ans;
                // If j1 and j2 are the same, add chocolates from grid[i][j1] only
                if (j1 == j2)
                    ans = grid[i][j1] + maxChocoUtil(i + 1, j1 + di, j2 + dj, n, m, grid, dp);
                else
                    // Add chocolates from both j1 and j2
                    ans = grid[i][j1] + grid[i][j2] + maxChocoUtil(i + 1, j1 + di, j2 + dj, n, m, grid, dp);
                // Update maxi with the maximum result
                maxi = Math.max(maxi, ans);
            }
        }
        // Store the result in the dp array and return it
        return dp[i][j1][j2] = maxi;
    }
    public int solve3(int n , int m , int[][] grid){
        int dp[][][] = new int[n][m][m];
        for (int j1 = 0 ; j1 <= m ; j1++){
            for (int j2 = 0 ; j2<= m ; j2++){
                if (j1 == j2) dp[n-1][j1][j2] = grid[n-1][j1];
                else
                    dp[n - 1][j1][j2] = grid[n - 1][j1] + grid[n - 1][j2];
            }

        }
        for (int i = n-2 ; i >= 0 ; i--){
            for (int j1 = 0 ; j1  < m ; j1++){
                for (int j2 = 0 ; j2 < m ; j2++){
                   int maxi = Integer.MIN_VALUE;
                   for (int d1 = -1 ; d1 <= 1 ; d1++ ){
                       for (int d2 = -1 ; d2 <= 1 ; d2++){
                           int ans;

                           if (j1 == j2)
                               ans = grid[i][j1];
                           else
                               ans = grid[i][j1] + grid[i][j2];
                           if ((j1 + d1 < 0 || j1 + d1 >= m) || (j2 + d2 < 0 || j2 + d2 >= m))
                               ans += (int) Math.pow(-10, 9);
                           else
                               ans += dp[i + 1][j1 + d1][j2 + d2];

                           // Update maxi with the maximum result
                           maxi = Math.max(ans, maxi);
                       }
                   }
                    dp[i][j1][j2] = maxi;
                }
            }
        }
        return dp[0][0][m - 1];
    }

}
