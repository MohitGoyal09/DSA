import java.util.*;
public class Main {
    static boolean subsetSumUtil(int ind, int target, int[] arr, int[][] dp) {
        // If the target sum is achieved, return true
        if (target == 0)
            return true;

        // If we have considered all elements but haven't reached the target, return false
        if (ind == 0)
            return arr[0] == target;

        // If the result for this subproblem has already been calculated, return it
        if (dp[ind][target] != -1)
            return dp[ind][target] == 0 ? false : true;

        // Try not taking the current element
        boolean notTaken = subsetSumUtil(ind - 1, target, arr, dp);

        // Try taking the current element if it doesn't exceed the target
        boolean taken = false;
        if (arr[ind] <= target)
            taken = subsetSumUtil(ind - 1, target - arr[ind], arr, dp);

        // Store the result in the DP table and return whether either option was successful
        dp[ind][target] = notTaken || taken ? 1 : 0;
        return notTaken || taken;
    }

    // Main function to check if there exists a subset with a given target sum
    static boolean subsetSumToK(int n, int k, int[] arr) {
        // Create a DP table with dimensions [n][k+1]
        int dp[][] = new int[n][k + 1];

        // Initialize DP table with -1 (unprocessed)
        for (int row[] : dp)
            Arrays.fill(row, -1);

        // Call the recursive helper function
        return subsetSumUtil(n - 1, k, arr, dp);
    }
    static boolean opt(int n , int k , int[] arr){
        boolean[][] dp = new boolean[n][k+1];

        for (int i = 0 ; i < n ; i++){
            dp[i][0] = true;
        }
        if (arr[0] <= k)  dp[0][arr[0]] = true;
        for (int ind = 1 ; ind < n ; ind++){
            for (int target = 1 ; target <= k ; target++){
                Boolean notTaken = dp[ind - 1][target];
                Boolean taken = false;
                if (arr[ind] <= target) taken = dp[ind - 1][target - arr[ind]];
                dp[ind][target] = notTaken || taken;

            }
        }
        return dp[n-1][k];
    }
    static boolean subsetSumToK3(int n, int k, int[] arr) {
        // Create an array to store the previous row of the DP table
        boolean prev[] = new boolean[k + 1];

        // Initialize the first row of the DP table
        prev[0] = true;

        // Initialize the first column of the DP table
        if (arr[0] <= k) {
            prev[arr[0]] = true;
        }

        // Fill in the DP table using bottom-up approach
        for (int ind = 1; ind < n; ind++) {
            // Create an array to store the current row of the DP table
            boolean cur[] = new boolean[k + 1];

            // Initialize the first column of the current row
            cur[0] = true;

            for (int target = 1; target <= k; target++) {
                // Calculate if the current target can be achieved without taking the current element
                boolean notTaken = prev[target];

                // Calculate if the current target can be achieved by taking the current element
                boolean taken = false;
                if (arr[ind] <= target) {
                    taken = prev[target - arr[ind]];
                }

                // Store the result in the current row of the DP table
                cur[target] = notTaken || taken;
            }

            // Update the previous row with the current row
            prev = cur;
        }

        // The final result is stored in the last cell of the previous row
        return prev[k];
    }
}