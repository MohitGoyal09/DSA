import java.util.Arrays;

public class Main {
    class Solution {
        public int maxProfit(int[] prices) {
            int n = prices.length;
            if ( n == 0) return 0;
            int[][] dp = new int[n][2];
            for (int rows[] : dp) Arrays.fill(rows , -1);
            return solve(prices ,0,0, n , dp);
        }
        public int solve(int[] prices, int ind, int buy, int n, int[][] dp) {
            if (ind == n) return 0;
            if (dp[ind][buy] != -1) return dp[ind][buy];
            int profit = 0; // Initialize profit

            if (buy == 0) {
                // If we are in a state where we can buy
                profit = Math.max(solve(prices, ind + 1, 0, n, dp),
                        -prices[ind] + solve(prices, ind + 1, 1, n, dp));
            } else {
                // If we are in a state where we can sell
                profit = Math.max(prices[ind] + solve(prices, ind + 1, 0, n, dp),
                        solve(prices, ind + 1, 1, n, dp));
            }

            dp[ind][buy] = profit; // Store the result in dp array
            return profit;
        }
    }
    public int maxProfit(int[] prices) {
        int n = prices.length;
        if ( n == 0) return 0;
        int[][] dp = new int[n][2];
        for (int rows[] : dp) Arrays.fill(rows , -1);
        return solve(prices ,0,0, n , dp);
    }
    public int solve(int[] prices, int ind, int buy, int n, int[][] dp) {
        if (ind == n) return 0;
        if (dp[ind][buy] != -1) return dp[ind][buy];
        int profit = 0; // Initialize profit

        if (buy == 0) {
            // If we are in a state where we can buy
            profit = Math.max(solve(prices, ind + 1, 0, n, dp), -prices[ind] + solve(prices, ind + 1, 1, n, dp));
        } else {
            // If we are in a state where we can sell
            profit = Math.max(prices[ind] + solve(prices, ind + 1, 0, n, dp), solve(prices, ind + 1, 1, n, dp));
        }

        dp[ind][buy] = profit; // Store the result in dp array
        return profit;
    }

    public int profitmax(int[] Arr , int n){
        if ( n== 0) return 0;
        int[][] dp = new int[n+1][2];
        for (int[] row : dp){
            Arrays.fill(row , -1);
        }
        int profit = 0;
        dp[n][0] = dp[n][1] = 0;
        for ( int ind = n - 1 ; ind>= 0 ; ind--){
            for (int buy = 0 ; buy <= 1 ; buy++){
                if (buy == 0){
                    profit = Math.max(dp[ind + 1][0], -Arr[ind] + dp[ind + 1][1]);

                }
                if (buy == 1) { // We can sell the stock
                    profit = Math.max( dp[ind + 1][1], Arr[ind] + dp[ind + 1][0]);
                }

                dp[ind][buy] = profit;
            }
        }
        return dp[0][0];
    }
    static long getMaximumProfit(long[] Arr, int n) {
        // Create arrays 'ahead' and 'cur' to store the maximum profit ahead and current profit
        long[] ahead = new long[2];
        long[] cur = new long[2];

        // Base condition: If we have no stocks to buy or sell, profit is 0
        ahead[0] = ahead[1] = 0;

        long profit = 0;

        // Iterate through the array in reverse to calculate the maximum profit
        for (int ind = n - 1; ind >= 0; ind--) {
            for (int buy = 0; buy <= 1; buy++) {
                if (buy == 0) { // We can buy the stock
                    profit = Math.max(0 + ahead[0], -Arr[ind] + ahead[1]);
                }

                if (buy == 1) { // We can sell the stock
                    profit = Math.max(0 + ahead[1], Arr[ind] + ahead[0]);
                }
                cur[buy] = profit;
            }

            // Update the 'ahead' array with the current profit values
            System.arraycopy(cur, 0, ahead, 0, 2);
        }
        return cur[0]; // The maximum profit is stored in 'cur[0]'
    }
}