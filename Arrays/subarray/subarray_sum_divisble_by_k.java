/*
    Approach:
    -----------
    We use the prefix sum and modular arithmetic to efficiently count the number of subarrays whose sum is divisible by k.

    1. Maintain a running prefix sum as we iterate through the array.
    2. For each prefix sum, compute its remainder (modulo k). (If negative, convert to positive.)
    3. Track the frequency of each possible remainder in a HashMap.
    4. If we've seen a remainder before, each previous occurrence represents a starting point for a subarray that ends at the current index and has a sum divisible by k.
    5. The answer is the total number of such pairs found during the iteration.

    Time Complexity: O(n)
    Space Complexity: O(k) (since at most k different remainders)
*/

class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1); // One way to have a prefix sum divisible by k at the start

        int count = 0;
        int prefixSum = 0;

        for (int num : nums) {
            prefixSum += num;
            // Find current mod; if negative, convert to equivalent positive mod
            int mod = prefixSum % k;
            if (mod < 0) mod += k;

            // If the remainder has been seen, all subarrays ending here that start after a previous matching remainder
            // have sums divisible by k
            if (map.containsKey(mod)) {
                count += map.get(mod); // Add the number of previous occurrences
                map.put(mod, map.get(mod) + 1); // Increment occurrence
            } else {
                map.put(mod, 1); // First time we see this mod
            }
        }

        return count;
    }
}