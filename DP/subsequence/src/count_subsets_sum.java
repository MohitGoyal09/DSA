import java.util.Arrays;

public class count_subsets_sum {
    class Solution {
        public int perfectSum(int num[], int n, int sum) {
            int dp[][] = new int[n][sum + 1];
            for (int row[] : dp) {
                Arrays.fill(row, -1);
            }
            return findWaysUtil(n - 1, sum, num, dp);
        }

        public int findWaysUtil(int ind, int target, int[] arr, int[][] dp) {
            if (target == 0) return 1;
            if (ind == 0) return arr[0] == target ? 1 : 0;
            if (dp[ind][target] != -1) return dp[ind][target];

            // Calculate the number of ways when the current element is not taken
            int notTaken = findWaysUtil(ind - 1, target, arr, dp);

            // Calculate the number of ways when the current element is taken
            int taken = 0;
            if (arr[ind] <= target) {
                taken = findWaysUtil(ind - 1, target - arr[ind], arr, dp);
            }

            // Store and return the result for the current state
            return dp[ind][target] = notTaken + taken;
        }

        public int perfectSum2(int num[],int n, int k)
        {
            // Your code goes here
            int[][] dp = new int[n][k + 1];

            // for every target 0 fill 1
            for (int i = 0; i < dp.length; i++) {
                dp[i][0] = 1;
            }
            if (num[0] <= k) {
                dp[0][num[0]] = 1;
            }

            // special case if array contains 0 at first element
            if (num[0] == 0) {
                dp[0][0] = 2;
            }

            // form nested loops
            for (int i = 1; i < n; i++) {
                for (int j = 0; j <= k; j++) {
                    int notPick = dp[i - 1][j] % (int) (1e9 + 7);
                    int pick = 0;
                    if (num[i] <= j) {
                        pick = dp[i - 1][j - num[i]] % (int) (1e9 + 7);
                    }
                    dp[i][j] = (notPick + pick) % (int) (1e9 + 7);
                }
            }
            return dp[n - 1][k];
        }
    }

}
