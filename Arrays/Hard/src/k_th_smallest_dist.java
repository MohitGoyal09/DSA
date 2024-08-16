import java.util.Arrays;

public class k_th_smallest_dist {
    class Solution {
        public int smallestDistancePair(int[] nums, int k) {
            int n = nums.length;
            Arrays.sort(nums);
            int maxd = nums[n-1] - nums[0];

            int left = 0, right = maxd;
            while (left < right) {
                int mid = left + (right - left) / 2;
                int count = 0, j = 0;
                for (int i = 0; i < n; i++) {
                    while (j < n && nums[j] - nums[i] <= mid) j++;
                    count += j - i - 1;
                }

                if (count >= k) right = mid;
                else left = mid + 1;
            }

            return left;
        }
    }
}
