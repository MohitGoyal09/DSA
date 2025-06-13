import java.util.*;
public class count_parition_with_max_min_difference {
    /* Approach 1 : Recursion + Memo (TLE)
1. Try every possible partition starting from current index
possible partition: max - min <=k
2. Maintain max and min to check for possible partition
Memoize overlapping states using dp
Time: O(n ^ 2)
Space: O(n)
*/
    public int countPartition(int[] nums , int k)
    {
        int n = nums.length;
        int[] dp = new int[n+1];
        Arrays.fill(dp,-1);
        return f(0, nums , k , dp);
    }
    public int f(int i , int[] nums , int k , int[] dp){
        if (i == nums.length) return 1;
        if (dp[i] != -1) return dp[i];
        int count = 0;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int j = i ; j < nums.length ; j++){
            max = Math.max(max , nums[j]);
            min = Math.min(min , nums[j]);
            if (max - min <= k){
                count += f(j + 1, nums, k, dp);
            }
        }
        return dp[i] = count;
    }

    /* Approach 2: Sliding Window + DP + Prefix Sum + Multiset
dp[i] = number of ways to partition the first i elements with given constraints
To compute dp[i], we look back to all positions j where a new segment could start
and the condition max - min ≤ k is satisfied in the subarray nums[j..i-1]. Then:
dp[i] = dp[j] + dp[j+1] + ... + dp[i-1]
For efficient calcualtion:
1. We use Multiset to keep track of the min and max in the current window in O(log n).
2. Prefix Sum (ps[i]) for dp array is used to compute the sum of a range of dp[] values in O (1)
dp[i] = sum of dp[j] to dp[i-1] = ps[i-1] - ps[j-1]
Note:
We set dp[0] = 1 to represent one valid way to partition an empty array
Time: O(n log n)    // each multiset operation is log n
Space: O(n)         // dp, prefix, multiset
*/

    public int countPartitions(int[] nums, int k) {
        final int MOD = 1_000_000_007;
        int n  = nums.length;
        int[] dp = new int[n+1];
        int[] pre = new int[n+1];
        dp[0] = pre[0] = 1;
        TreeMap<Integer, Integer> multiset = new TreeMap<>();
        int l = 0;

        for (int r = 1 ; r <= n ; r++){
            multiset.put(nums[r - 1], multiset.getOrDefault(nums[r - 1], 0) + 1);
            while (multiset.lastKey() - multiset.firstKey() > k) {
                int count = multiset.get(nums[l]);
                if (count == 1) {
                    multiset.remove(nums[l]);
                } else {
                    multiset.put(nums[l], count - 1);
                }
                l++;
            }
            int prev = (l > 0) ? pre[l-1] : 0;
            dp[r] = (pre[r-1] - prev + MOD ) % MOD;
            pre[r] = (pre[r-1] + dp[r]) % MOD;
        }
        return dp[n];
    }
}
