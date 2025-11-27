/*
    Approach: Application of Kadane's Algorithm
    ---------
    The goal is to find the maximum sum of subarrays whose lengths are multiples of k (i.e., subarray lengths: k, 2k, 3k, ...).

    1. Compute the prefix sum of the array for O(1) range sum queries.
    2. For each possible starting index `start` in the first `k` elements:
       - Iterate over all subarrays of length k starting at positions `start, start + k, start + 2k, ...` (these will be non-overlapping and each will have length k).
       - Use prefix sums to efficiently compute the sum of each such subarray.
       - At each step, use dynamic programming-style update: take previous sum or start new at this block, whichever is larger.
       - Track the global maximum sum.
    3. Return the overall maximum found.

    Time complexity: O(n)
    Space complexity: O(n)
*/

class Solution {
    public long maxSubarraySumDivisibleByK(int[] nums, int k) {
        int n = nums.length;
        int result = Integer.MIN_VALUE;
        int[] prefixSum = new int[n];
        prefixSum[0] = nums[0];
        // Build prefix sum array
        for (int i = 1 ; i < n ;i++) prefixSum[i] = prefixSum[i-1] + nums[i];

        // Try starting position for each possible offset within 0 to k-1
        for (int start =  0 ; start < k ; start++){
            int curSum = 0;
            int i = start;
            // For each sequence starting with this offset, check sums of blocks of length k
            while ( i < n && i + k - 1 < n){
                int j = i + k - 1;
                // Compute sum of current block [i, j]
                long SubSum = prefixSum[j] - (i > 0 ? prefixSum[i - 1] : 0);
                // Either continue by adding this block or restart from this block
                curSum = Math.max(curSum , SubSum + curSum);
                result = Math.max(result , curSum);
                i += k;
            }
        }
        return result;
    }
}
