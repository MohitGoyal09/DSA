import java.util.*;

public class largest_divisble_subset {
    class Solution {
        public List<Integer> largestDivisibleSubset(int[] nums) {
            int n = nums.length;
            Arrays.sort(nums);  // Sort the array first
            int[] dp = new int[n];
            int[] hash = new int[n];
            Arrays.fill(dp, 1);  // Initialize with 1 as each number is divisible by itself
            Arrays.fill(hash, -1);

            int maxLen = 1, lastIndex = 0;

            for (int i = 1; i < n; i++) {
                for (int j = 0; j < i; j++) {
                    if (nums[i] % nums[j] == 0 && dp[i] < dp[j] + 1) {
                        dp[i] = dp[j] + 1;
                        hash[i] = j;
                        if (dp[i] > maxLen) {
                            maxLen = dp[i];
                            lastIndex = i;
                        }
                    }
                }
            }

            List<Integer> result = new ArrayList<>();
            while (lastIndex != -1) {
                result.add(nums[lastIndex]);
                lastIndex = hash[lastIndex];
            }

            Collections.reverse(result);
            return result;
        }

    }
}
