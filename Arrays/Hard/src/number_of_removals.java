import java.util.*;
public class number_of_removals {
    // Longest Increasing Subsequence (LIS) Solution from both directions

    class Solution {
        // Helper function to calculate LIS lengths for each position
        private List<Integer> lisLength(int[] nums) {
            // Start with first element
            List<Integer> lis = new ArrayList<>();
            lis.add(nums[0]);
            // Track LIS length ending at each position
            List<Integer> lisLen = new ArrayList<>();
            for (int i = 0; i < nums.length; i++) {
                lisLen.add(1);
            }

            for (int i = 1; i < nums.length; i++) {
                // If current element is larger than last LIS element, extend the sequence
                if (nums[i] > lis.get(lis.size() - 1)) {
                    lis.add(nums[i]);
                } else {
                    // Replace the smallest element that's >= current element
                    // This maintains the potential for longer sequences
                    int index = Collections.binarySearch(lis, nums[i]);
                    if (index < 0) {
                        index = -(index + 1);
                    }
                    lis.set(index, nums[i]);
                }
                // Store length of LIS up to current position
                lisLen.set(i, lis.size());
            }
            return lisLen;
        }

        public int minimumMountainRemovals(int[] nums) {
            int n = nums.length;

            // Get LIS lengths from left to right (increasing part)
            List<Integer> lis = lisLength(nums);

            // Get LIS lengths from right to left (decreasing part)
            int[] reversed = new int[n];
            for (int i = 0; i < n; i++) {
                reversed[i] = nums[n - 1 - i];
            }
            List<Integer> lds = lisLength(reversed);
            Collections.reverse(lds);

            int removals = Integer.MAX_VALUE;

            // For each potential peak position
            for (int i = 0; i < n; i++) {
                // Valid mountain needs both sides to have length > 1
                if (lis.get(i) > 1 && lds.get(i) > 1) {
                    // Calculate removals needed:
                    // Total length - (increasing length + decreasing length - 1)
                    // -1 because peak is counted twice
                    removals = Math.min(removals, n + 1 - lis.get(i) - lds.get(i));
                }
            }

            return removals;
        }
    }
}
