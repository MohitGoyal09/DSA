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
    static int knapSack2(int N, int W, int[] val, int[] wt)
    {
        // code here
        int[] prev = new int[W + 1];
        for ( int w = wt[0] ; w <= W ; w++) prev[w] = val[0];
        for ( int ind = 1 ; ind < N ; ind++){
            for ( int w = 0 ; w <= W ; w++){
                int notTaken = prev[w];
                int taken = Integer.MIN_VALUE;
                if (wt[ind] <= w) taken = val[ind] + prev[w - wt[ind]];
                prev[w] = Math.max(notTaken , taken);
            }
        }
        return prev[W];
    }
}
