import java.util.Arrays;

public class stock_cooldown {
    class Solution {
        public int maxProfit(int[] Arr) {
            int n = Arr.length;
            int[][] dp = new int[n][2];

            // Initialize dp array with -1 to mark states as not calculated yet
            for (int[] row : dp) {
                Arrays.fill(row, -1);
            }

            int ans = getAns(Arr, 0, 0, n, dp);
            return ans;
        }
        public int getAns(int[] Arr, int ind, int buy, int n, int[][] dp) {
            // Base case
            if (ind >= n) {
                return 0;
            }

            // If the result is already calculated, return it
            if (dp[ind][buy] != -1) {
                return dp[ind][buy];
            }

            int profit = 0;

            if (buy == 0) { // We can buy the stock
                profit = Math.max(0 + getAns(Arr, ind + 1, 0, n, dp),
                        -Arr[ind] + getAns(Arr, ind + 1, 1, n, dp));
            }

            if (buy == 1) { // We can sell the stock
                profit = Math.max(0 + getAns(Arr, ind + 1, 1, n, dp),
                        Arr[ind] + getAns(Arr, ind + 2, 0, n, dp));
            }

            // Store the result in dp and return it
            dp[ind][buy] = profit;
            return profit;
        }

    }
}
