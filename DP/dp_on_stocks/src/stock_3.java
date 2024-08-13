import java.util.Arrays;

public class stock_3 {

    public int maxProfit3(int[] prices) {
        int n = prices.length;
        int[][][] dp = new int[n][2][3];
        // Initialize the dp array with -1
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 2; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }

        // Calculate and return the maximum profit
        return getAns(prices, n, 0, 0, 2, dp);
    }
    public int getAns(int[] Arr, int n, int ind, int buy, int cap, int[][][] dp) {
        // Base case: If we have processed all stocks or have no capital left, return 0 profit
        if (ind == n || cap == 0)
            return 0;

        // If the result for this state is already calculated, return it
        if (dp[ind][buy][cap] != -1)
            return dp[ind][buy][cap];

        int profit = 0;

        if (buy == 0) { // We can buy the stock
            profit = Math.max(getAns(Arr, n, ind + 1, 0, cap, dp),
                    -Arr[ind] + getAns(Arr, n, ind + 1, 1, cap, dp));
        }

        else  { // We can sell the stock
            profit = Math.max(getAns(Arr, n, ind + 1, 1, cap, dp),
                    Arr[ind] + getAns(Arr, n, ind + 1, 0, cap - 1, dp));
        }

        // Store the calculated profit in the dp array and return it
        return dp[ind][buy][cap] = profit;
    }
    static int maxProfit(int[] prices) {
        int n = prices.length;

        // Creating a 3D dp array of size [n+1][2][3] initialized to 0
        int[][][] dp = new int[n + 1][2][3];

        // Loop through the dp array, starting from the second last stock (ind=n-1)
        for (int ind = n - 1; ind >= 0; ind--) {
            for (int buy = 0; buy <= 1; buy++) {
                for (int cap = 1; cap <= 2; cap++) {

                    if (buy == 0) { // We can buy the stock
                        dp[ind][buy][cap] = Math.max(dp[ind + 1][0][cap],
                                -prices[ind] + dp[ind + 1][1][cap]);
                    }

                    if (buy == 1) { // We can sell the stock
                        dp[ind][buy][cap] = Math.max(dp[ind + 1][1][cap],
                                prices[ind] + dp[ind + 1][0][cap - 1]);
                    }
                }
            }
        }

        // The maximum profit with 2 transactions is stored in dp[0][0][2]
        return dp[0][0][2];
    }

    static int prices(int[] prices){
        int n = prices.length;
        int ahead[][] = new int[2][3];
        int[][] cur = new int[2][3];

        for (int ind = n - 1 ; ind >= 0 ; ind--){
            for (int buy = 0 ; buy <= 1 ; buy++){
                for ( int cap = 1 ; cap <= 2 ; cap++){
                    if (buy == 0) { // We can buy the stock
                        cur[buy][cap] = Math.max(ahead[0][cap],
                                -prices[ind] + ahead[1][cap]);
                    }

                    if (buy == 1) { // We can sell the stock
                        cur[buy][cap] = Math.max(ahead[1][cap],
                                prices[ind] + ahead[0][cap - 1]);
                    }
                }
                for (int i = 0; i < 2; i++) {
                    for (int j = 1; j < 3; j++) {
                        ahead[i][j] = cur[i][j];
                    }
                }
            }
        }
        return ahead[0][2];
    }
}
