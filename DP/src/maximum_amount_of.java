public class maximum_amount_of {
        int m, n;
        Integer[][][] dp;
        int NEG = Integer.MIN_VALUE;
        public int maximumAmount(int[][] coins) {
            m = coins.length; n = coins[0].length;
            dp = new Integer[m][n][3];
            return solve(0, 0, 2, coins);
        }

        int solve(int i, int j, int k, int[][] coins) {
            if (i < 0 || j < 0 || i >= m || j >= n) return NEG;
            if (dp[i][j][k] != null) return dp[i][j][k];
            if (i == m - 1 && j == n - 1) {
                int c = coins[i][j];
                if (c >= 0) dp[i][j][k] = c;
                else {
                    if (k > 0) dp[i][j][k] = Math.max(c, 0);
                    else dp[i][j][k] = c;
                }
                return dp[i][j][k];
            }

            int c = coins[i][j];
            int down = solve(i + 1, j, k, coins);
            int right = solve(i, j + 1, k, coins);
            int best = Math.max(down, right);
            if (c >= 0) {
                dp[i][j][k] = c + best;
            } else {
                int pay = c + best;
                int skip = NEG;
                if (k > 0) {
                    int d2 = solve(i + 1, j, k - 1, coins);
                    int r2 = solve(i, j + 1, k - 1, coins);
                    skip = Math.max(d2, r2);
                }
                dp[i][j][k] = Math.max(pay, skip);
            }
            return dp[i][j][k];
        }

}
