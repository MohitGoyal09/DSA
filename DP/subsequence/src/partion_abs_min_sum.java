import java.util.ArrayList;

public class partion_abs_min_sum {
    // Function to calculate the minimum absolute difference of two subsets
    static int minSubsetSumDifference(ArrayList<Integer> arr, int n) {
        int totSum = 0;

        // Calculate the total sum of the array elements
        for (int i = 0; i < n; i++) {
            totSum += arr.get(i);
        }

        // Create a DP table to store subset sum information
        boolean[][] dp = new boolean[n][totSum + 1];

        // Initialize the DP table for the first row
        for (int i = 0; i < n; i++) {
            dp[i][0] = true;
        }

        // Initialize the DP table for the first column
        if (arr.get(0) <= totSum) {
            dp[0][totSum] = true;
        }

        // Fill in the DP table using bottom-up dynamic programming
        for (int ind = 1; ind < n; ind++) {
            for (int target = 1; target <= totSum; target++) {
                // Calculate if the current element is not taken
                boolean notTaken = dp[ind - 1][target];

                // Calculate if the current element is taken
                boolean taken = false;
                if (arr.get(ind) <= target) {
                    taken = dp[ind - 1][target - arr.get(ind)];
                }

                // Update the DP table for the current element and target sum
                dp[ind][target] = notTaken || taken;
            }
        }

        int mini = Integer.MAX_VALUE;

        // Find the minimum absolute difference between two subsets
        for (int i = 0; i <= totSum; i++) {
            if (dp[n - 1][i]) {
                int diff = Math.abs(i - (totSum - i));
                mini = Math.min(mini, diff);
            }
        }
        return mini;
    }
}
