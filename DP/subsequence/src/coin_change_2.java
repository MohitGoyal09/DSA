import java.util.Arrays;

public class coin_change_2 {
    class Solution {
        public int change(int amount, int[] coins) {
            int n = coins.length;
            int[][] dp = new int[n][amount + 1];
            for ( int row[] : dp){
                Arrays.fill(row , -1);
            }
            return countWaysToMakeChangeUtil(coins, n - 1, amount, dp);
        }
        static int countWaysToMakeChangeUtil(int[] arr, int ind, int T, int[][] dp) {
            // Base case: If the current index is 0
            if (ind == 0) {
                // If T is divisible by the first element of the array, return 1, else return 0
                if (T % arr[0] == 0)
                    return 1;
                else
                    return 0;
            }

            // If the result for this subproblem has already been calculated, return it
            if (dp[ind][T] != -1)
                return dp[ind][T];

            // Calculate the number of ways without taking the current element
            int notTaken = countWaysToMakeChangeUtil(arr, ind - 1, T, dp);

            // Initialize the number of ways taking the current element as 0
            int taken = 0;

            // If the current element is less than or equal to T, calculate 'taken'
            if (arr[ind] <= T)
                taken = countWaysToMakeChangeUtil(arr, ind, T - arr[ind], dp);

            // Store the result in the dp array and return it
            return dp[ind][T] = notTaken + taken;
        }
    }
    static long countWaysToMakeChange(int[] arr, int n, int T) {
        // Create a 2D array to store results of subproblems
        long dp[][] = new long[n][T + 1];

        // Initialize base condition for the first element of the array
        for (int i = 0; i <= T; i++) {
            if (i % arr[0] == 0)
                dp[0][i] = 1;
            // Else condition is automatically fulfilled, as dp array is initialized to zero
        }

        // Fill the dp array using dynamic programming
        for (int ind = 1; ind < n; ind++) {
            for (int target = 0; target <= T; target++) {
                long notTaken = dp[ind - 1][target];

                long taken = 0;
                if (arr[ind] <= target)
                    taken = dp[ind][target - arr[ind]];

                dp[ind][target] = notTaken + taken;
            }
        }

        return dp[n - 1][T];
    }
    static long countWaysToMakeChange3(int[] arr, int n, int T) {
        // Create an array to store results of subproblems for the previous element
        long[] prev = new long[T + 1];

        // Initialize base condition for the first element of the array
        for (int i = 0; i <= T; i++) {
            if (i % arr[0] == 0)
                prev[i] = 1;
            // Else condition is automatically fulfilled, as prev array is initialized to zero
        }

        // Fill the prev array using dynamic programming
        for (int ind = 1; ind < n; ind++) {
            // Create an array to store results of subproblems for the current element
            long[] cur = new long[T + 1];
            for (int target = 0; target <= T; target++) {
                long notTaken = prev[target];

                long taken = 0;
                if (arr[ind] <= target)
                    taken = cur[target - arr[ind]];

                cur[target] = notTaken + taken;
            }
            prev = cur;
        }

        return prev[T];
    }
}
