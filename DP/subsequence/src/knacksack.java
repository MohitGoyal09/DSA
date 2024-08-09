import java.util.Arrays;

public class knacksack {
    static int knapSack(int N, int W, int[] val, int[] wt)
    {
        // code here
        int[][] dp = new int[N][W + 1];
        for ( int[] row : dp){
            Arrays.fill(row , -1);
        }
        return knapsackUtil(wt , val , N - 1 , W , dp);
    }
    static int knapsackUtil(int[] wt, int[] val, int ind, int W, int[][] dp) {
        // Base case: If there are no more items to consider
        if (ind == 0) {
            // Calculate and return the maximum value possible
            return ((int) (W / wt[0])) * val[0];
        }

        // If the result for this subproblem has already been calculated, return it
        if (dp[ind][W] != -1)
            return dp[ind][W];

        // Calculate the maximum value when the current item is not taken
        int notTaken = knapsackUtil(wt, val, ind - 1, W, dp);

        // Initialize the maximum value when the current item is taken as the minimum integer value
        int taken = Integer.MIN_VALUE;

        // If the weight of the current item is less than or equal to the available capacity (W),
        // calculate the maximum value when the current item is taken
        if (wt[ind] <= W)
            taken = val[ind] + knapsackUtil(wt, val, ind - 1, W - wt[ind], dp);

        // Store the result in the dp array and return it
        return dp[ind][W] = Math.max(notTaken, taken);
    }
    static int knapSack3(int N, int W, int[] val, int[] wt)
    {
        // code here
        int[][] dp = new int[N][W + 1];
        for (int w = wt[0] ; w <= W ; w++) dp[0][w] = val[0];
        for ( int ind = 1 ; ind < N ; ind++){
            for ( int w = 0 ; w <= W ; w++){
                int notTaken = dp[ind - 1][w];
                int taken = Integer.MIN_VALUE;
                if (wt[ind] <= w) taken = val[ind] + dp[ind - 1][w - wt[ind]];
                dp[ind][w] = Math.max(notTaken , taken);
            }
        }
        return dp[N - 1][W];
    }

    // ! Space optimization
    static int unboundedKnapsack(int n, int W, int[] val, int[] wt) {
        // Create an array to store the maximum value for each capacity from 0 to W
        int cur[] = new int[W + 1];

        // Base condition: Initialize the cur array for the first item
        for (int i = wt[0]; i <= W; i++) {
            cur[i] = ((int) i / wt[0]) * val[0];
        }

        // Fill the cur array using dynamic programming
        for (int ind = 1; ind < n; ind++) {
            for (int cap = 0; cap <= W; cap++) {
                // Calculate the maximum value when the current item is not taken
                int notTaken = cur[cap];

                // Initialize the maximum value when the current item is taken as the minimum integer value
                int taken = Integer.MIN_VALUE;

                // If the weight of the current item is less than or equal to the current capacity (cap),
                // calculate the maximum value when the current item is taken
                if (wt[ind] <= cap)
                    taken = val[ind] + cur[cap - wt[ind]];

                // Store the result in the cur array
                cur[cap] = Math.max(notTaken, taken);
            }
        }

        return cur[W]; // Return the maximum value that can be obtained with the given capacity W
    }
}
