import java.util.*;

public class mini_cost_cut_stick {
    class Solution {
        public int minCost(int n, int[] cuts) {
            int[] c = new int[cuts.length + 2];
            System.arraycopy(cuts, 0, c, 1, cuts.length);
            c[0] = 0;
            c[c.length - 1] = n;
            Arrays.sort(c);
            int[][] dp = new int[c.length][c.length];
            for (int[] row : dp) {
                Arrays.fill(row, -1);
            }
            return solve(0, c.length - 1, c, dp);
        }

        public int solve(int i, int j, int[] c, int[][] dp) {
            if (i + 1 >= j) return 0;
            if (dp[i][j] != -1) return dp[i][j];

            int min = Integer.MAX_VALUE;
            for (int ind = i + 1; ind < j; ind++) {
                int cost = c[j] - c[i] + solve(i, ind, c, dp) + solve(ind, j, c, dp);
                min = Math.min(cost, min);
            }
            return dp[i][j] = min;
        }
    }
    static int cost(int n, int c, ArrayList<Integer> cuts) {
        // Modify the cuts array
        cuts.add(n);
        cuts.add(0);
        Collections.sort(cuts);

        int[][] dp = new int[c + 2][c + 2];

        for (int[] row : dp) {
            Arrays.fill(row, 0);
        }

        for (int i = c; i >= 1; i--) {
            for (int j = 1; j <= c; j++) {
                if (i > j) continue;

                int mini = Integer.MAX_VALUE;

                for (int ind = i; ind <= j; ind++) {
                    int ans = cuts.get(j + 1) - cuts.get(i - 1) + dp[i][ind - 1] + dp[ind + 1][j];
                    mini = Math.min(mini, ans);
                }

                dp[i][j] = mini;
            }
        }

        return dp[1][c];
    }
}
