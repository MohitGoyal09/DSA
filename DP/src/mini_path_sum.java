import java.util.Arrays;

public class mini_path_sum {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        int[][] dp = new int[n][m];
        for (int[] row : dp)
            Arrays.fill(row, Integer.MAX_VALUE);

        int mini = Integer.MAX_VALUE;

        // For each starting column, find the minimum path sum and update mini
        for (int j = 0; j < m; j++) {
            mini = Math.min(mini, getMinUtil(0, j, matrix, dp));
        }

        return mini;
    }

    private static int getMinUtil(int i, int j, int[][] matrix, int[][] dp) {
        // Base cases
        if (j < 0 || j >= matrix[0].length)
            return Integer.MAX_VALUE;

        if (i == matrix.length - 1)
            return matrix[i][j];

        // If we've already computed this state
        if (dp[i][j] != Integer.MAX_VALUE)
            return dp[i][j];

        // Recursive cases
        int down = getMinUtil(i + 1, j, matrix, dp);
        int leftDiagonal = getMinUtil(i + 1, j - 1, matrix, dp);
        int rightDiagonal = getMinUtil(i + 1, j + 1, matrix, dp);

        // Store the minimum of the three options
        int minPath = Math.min(down, Math.min(leftDiagonal, rightDiagonal));

        // Add current cell value only if minPath is not MAX_VALUE to avoid overflow
        return dp[i][j] = (minPath == Integer.MAX_VALUE) ? minPath : matrix[i][j] + minPath;
    }
    public static int solve(int[][] matrix){
        int n = matrix.length;
        int m = matrix[0].length;
        int[][] dp = new int[n][m];
        for ( int j = 0 ; j < m ; j++){
            dp[n-1][j] = matrix[n-1][j];
        }
        for (int i = 1 ; i < n ; i++){
            for ( int j = 0 ; j < m ; j++){
                int up = matrix[i][j] + dp[i-1][j];
                int leftDiagonal = matrix[i][j];
                if (j - 1 >= 0) {
                    leftDiagonal += dp[i - 1][j - 1];
                } else {
                    leftDiagonal += (int) Math.pow(-10, 9);
                }
                int rightDiagonal = matrix[i][j];
                if (j + 1 < m) {
                    rightDiagonal += dp[i - 1][j + 1];
                } else {
                    rightDiagonal += (int) Math.pow(-10, 9);
                }
                dp[i][j] = Math.max(up, Math.min(leftDiagonal, rightDiagonal));
            }
        }
        int maxi = Integer.MIN_VALUE;
        for (int j = 0; j < m; j++) {
            maxi = Math.max(maxi, dp[n - 1][j]);
        }

        return maxi;
    }
}
