import java.util.Arrays;

public class stocks_3_way_2 {
    class Solution {
        private int f(int ind, int ts, int n, int[] prices, int[][] dp) {
            // base cases
            if (ind == n || ts == 4) return 0;
            if (dp[ind][ts] != -1) return dp[ind][ts];
            if (ts % 2 == 0) {
                return dp[ind][ts] = Math.max(-prices[ind] + f(ind + 1, ts + 1, n, prices, dp), f(ind + 1, ts, n, prices, dp));
            } else {
                return dp[ind][ts] = Math.max(prices[ind] + f(ind + 1, ts + 1, n, prices, dp), f(ind + 1, ts, n, prices, dp));
            }
        }

        public int maxProfit(int[] prices) {
            int n = prices.length;
            int[][] dp = new int[n][4];
            for (int[] row : dp) {
                Arrays.fill(row, -1);
            }
            return f(0, 0, n, prices, dp);
        }
    }
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n + 1][5];

        for (int i = 0; i <= 4; i++) {
            dp[n][i] = 0;
        }
        for (int i = 0; i <= n; i++) {
            dp[i][4] = 0;
        }

        for (int ind = n - 1; ind >= 0; ind--) {
            for (int ts = 3; ts >= 0; ts--) {
                if (ts % 2 == 0) {
                    dp[ind][ts] = Math.max(-prices[ind] + dp[ind + 1][ts + 1], dp[ind + 1][ts]);
                } else {
                    dp[ind][ts] = Math.max(prices[ind] + dp[ind + 1][ts + 1], dp[ind + 1][ts]);
                }
            }
        }
        return dp[0][0];
    }
    class Solution2 {
        public int maxProfit(int[] prices) {
            int n = prices.length;
            int[] ahead = new int[5];
            int[] cur = new int[5];

            Arrays.fill(ahead, 0);
            cur[4] = 0;

            for (int ind = n - 1; ind >= 0; ind--) {
                for (int ts = 3; ts >= 0; ts--) {
                    if (ts % 2 == 0) {
                        cur[ts] = Math.max(-prices[ind] + ahead[ts + 1], ahead[ts]);
                    } else {
                        cur[ts] = Math.max(prices[ind] + ahead[ts + 1], ahead[ts]);
                    }
                }
                ahead = cur.clone();
            }
            return ahead[0];
        }
    }

}
