import java.util.*;


public class triangle {
    // Function to find the minimum path sum in the triangle using dynamic programming
    static int minimumPathSumUtil(int i, int j, int[][] triangle, int n, int[][] dp) {
        // Check if the result for the current position (i, j) is already calculated
        if (dp[i][j] != -1)
            return dp[i][j];

        // If we are at the bottom row, return the value in the triangle
        if (i == n - 1)
            return triangle[i][j];

        // Calculate the minimum path sum by recursively considering two possible paths: down and diagonal
        int down = triangle[i][j] + minimumPathSumUtil(i + 1, j, triangle, n, dp);
        int diagonal = triangle[i][j] + minimumPathSumUtil(i + 1, j + 1, triangle, n, dp);

        // Store the result in the dp array and return the minimum of the two paths
        return dp[i][j] = Math.min(down, diagonal);
    }

    // Function to find the minimum path sum in the triangle
    static int minimumPathSum(int[][] triangle, int n) {
        // Create a 2D array to store computed results, initialize with -1
        int dp[][] = new int[n][n];
        for (int row[] : dp)
            Arrays.fill(row, -1);

        // Call the utility function to find the minimum path sum starting from the top
        return minimumPathSumUtil(0, 0, triangle, n, dp);
    }
    static int tabular( int[][] triangle , int n , int[][] dp ){
        for ( int j = 0 ; j < n ; j++){
            dp[n-1][j] = triangle[n-1][j];
        }
        for ( int i = n - 2 ; i >= 0 ; i--){
            for (int j = i ; j>= 0 ; j--){
                int down = triangle[i][j] + dp[i+1][j];
                int diagonal = triangle[i][j] + dp[i+1][j+1];
                dp[i][j] = Math.min(down,diagonal);
            }
        }

        return dp[0][0];
    }
    static int minimumPathSum4(int[][] triangle, int n) {
        // Create two arrays to store intermediate results: front and cur
        int[] front = new int[n]; // Stores the results for the current row
        int[] cur = new int[n];   // Stores the results for the next row

        // Initialize the front array with the values from the bottom row of the triangle
        for (int j = 0; j < n; j++) {
            front[j] = triangle[n - 1][j];
        }

        // Starting from the second to last row, calculate the minimum path sum for each element
        for (int i = n - 2; i >= 0; i--) {
            for (int j = i; j >= 0; j--) {
                // Calculate the two possible paths: moving down or moving diagonally
                int down = triangle[i][j] + front[j];
                int diagonal = triangle[i][j] + front[j + 1];

                // Store the minimum of the two paths in the cur array
                cur[j] = Math.min(down, diagonal);
            }

            // Update the front array with the values from the cur array for the next row
            front = cur.clone();
        }

        // The result is stored at the top of the front array
        return front[0];
    }
}
