public class longest_subaaray_with_max_Bitwise_AND {
    class Solution {
        public int longestSubarray(int[] nums) {
            int maxBitwiseAnd = Integer.MIN_VALUE;

            // Find the maximum value in the array
            for (int num : nums) {
                maxBitwiseAnd = Math.max(maxBitwiseAnd, num);
            }

            int maxi = 1;
            int count = 0;
            int i = 0;

            while (i < nums.length) {
                if (nums[i] == maxBitwiseAnd) {
                    while (i < nums.length && nums[i++] == maxBitwiseAnd) {
                        count++;
                    }
                    maxi = Math.max(maxi, count);
                    count = 0;
                } else {
                    i++;
                }
            }

            return maxi;
        }
    }
}
