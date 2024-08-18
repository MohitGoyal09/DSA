import java.util.*;
public class burst_ballons {
    static int maxCoins(int i, int j, ArrayList<Integer> a, int[][] dp) {
        if (i > j) return 0;
        if (dp[i][j] != -1) return dp[i][j];
        int maxi = Integer.MIN_VALUE;
        for (int ind = i; ind <= j; ind++) {
            int cost = a.get(i - 1) * a.get(ind) * a.get(j + 1)
                    + maxCoins(i, ind - 1, a, dp) + maxCoins(ind + 1, j, a, dp);
            maxi = Math.max(maxi, cost);
        }
        return dp[i][j] = maxi;
    }

    // Wrapper function to calculate the maximum coins
    static int maxCoins(ArrayList<Integer> a) {
        int n = a.size();
        a.add(1);
        a.add(0, 1);
        int[][] dp = new int[n + 2][n + 2];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return maxCoins(1, n, a, dp);
    }
    static int maxCoin(ArrayList<Integer> a) {
        int n = a.size();

        // Add 1 to the beginning and end of the array
        a.add(0, 1);
        a.add(1);

        // Create a 2D DP array
        int[][] dp = new int[n + 2][n + 2];

        // Iterate from the end to the beginning
        for (int i = n; i >= 1; i--) {
            for (int j = 1; j <= n; j++) {
                if (i > j) continue;
                int maxi = Integer.MIN_VALUE;

                // Iterate through possible indices to split the array
                for (int ind = i; ind <= j; ind++) {
                    int cost = a.get(i - 1) * a.get(ind) * a.get(j + 1) +
                            dp[i][ind - 1] + dp[ind + 1][j];
                    maxi = Math.max(maxi, cost);
                }
                dp[i][j] = maxi;
            }
        }
        return dp[1][n];
    }
    class Solution {
        public int maxCoins(int[] nums) {
            int n = nums.length;
            int[] a = new int[n + 2];
            a[0] = 1;
            a[n + 1] = 1;

            // Copy nums into a
            for (int i = 0; i < n; i++) {
                a[i + 1] = nums[i];
            }

            int[][] dp = new int[n+2][n+2];
            for (int[] row : dp) {
                Arrays.fill(row, -1);
            }
            return f(1, n, a, dp);
        }

        public int f(int i, int j, int[] a, int[][] dp) {
            if (i > j) return 0;
            if (dp[i][j] != -1) return dp[i][j];
            int max = Integer.MIN_VALUE;
            for (int ind = i; ind <= j; ind++) {
                int cost = (a[i - 1] * a[ind] * a[j + 1]) + f(i, ind - 1, a, dp) + f(ind + 1, j, a, dp);
                max = Math.max(cost, max);
            }
            return dp[i][j] = max;
        }
    }

}
