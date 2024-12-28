import java.util.*;
public class max_sum_three_non_overlaping_substrings {
    private int[][] dp = new int[20001][4];

    private int helper(int[] sums, int k, int idx, int rem) {
        if (rem == 0) return 0;
        if (idx >= sums.length) return Integer.MIN_VALUE;

        if (dp[idx][rem] != -1) {
            return dp[idx][rem];
        }

        int take = sums[idx] + helper(sums, k, idx + k, rem - 1);
        int notTake = helper(sums, k, idx + 1, rem);

        dp[idx][rem] = Math.max(take, notTake);
        return dp[idx][rem];
    }

    private void solve(int[] sums, int k, int idx, int rem, List<Integer> indices) {
        if (rem == 0 || idx >= sums.length) return;

        int take = sums[idx] + helper(sums, k, idx + k, rem - 1);
        int notTake = helper(sums, k, idx + 1, rem);

        if (take >= notTake) {
            indices.add(idx);
            solve(sums, k, idx + k, rem - 1, indices);
        } else {
            solve(sums, k, idx + 1, rem, indices);
        }
    }

    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        // Initialize the memoization array with -1
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        int n = nums.length - k + 1;
        int[] sums = new int[n];
        int windowSum = 0;
        int i = 0, j = 0;

        // Calculate window sums
        while (j < nums.length) {
            windowSum += nums[j];

            if (j - i + 1 == k) {
                sums[i] = windowSum;
                windowSum -= nums[i];
                i++;
            }
            j++;
        }

        List<Integer> indices = new ArrayList<>();
        solve(sums, k, 0, 3, indices);

        return indices.stream().mapToInt(Integer::intValue).toArray();
    }
}
