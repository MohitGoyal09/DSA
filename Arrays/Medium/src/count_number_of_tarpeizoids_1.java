import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;
/*
Intuition:
A trapezoid is defined by two parallel sides and two non-parallel sides. Given only points, if we 
select two points on one horizontal line (same y-coordinate), 
and two points on another horizontal line (different y-coordinate), those four points can be 
connected to form a trapezoid where the parallel sides are those lines!
So, for each y-coordinate with at least 2 points, count the number of ways to choose 2 points (nC2).
For each pair of different y-levels, select 2 points from each:
Total trapezoids = sum for all pairs of levels of (#ways from level1) * (#ways from level2).
We can accumulate the values efficiently.

Approach:
1. Count how many points are present at each y-coordinate.
2. For every y having at least 2 points, compute nC2 (number of ways to form a base).
3. Store all such nC2s in a list.
4. The answer is sum over all unordered pairs: sum_{i<j} vals[i]*vals[j] = (totalSum^2 - sum of squares)/2
   But we can also accumulate dynamically while iterating.
5. Take care of modulo constraints.

Time Complexity: O(N), where N = number of points (for counting and for building the height list).
Space Complexity: O(U), where U = #distinct y-levels (<= N).


Code:
*/
class Solution {
    /**
     * Counts the number of trapezoids that can be formed from a set of points
     * where each trapezoid is formed by selecting two pairs of points; each pair
     * having the same y-coordinate, and the y-coordinates are distinct.
     *
     * @param points List of points [x, y]
     * @return Number of trapezoids modulo 1e9+7
     */
    public int countTrapezoids(int[][] points) {
        long mod = 1_000_000_007L;

        // Count number of points at each y-coordinate
        HashMap<Integer, Integer> freq = new HashMap<>();
        for (int[] p : points) {
            int y = p[1];
            freq.put(y, freq.getOrDefault(y, 0) + 1);
        }

        // For each y with at least 2 points, compute nC2
        List<Long> pairsAtLevel = new ArrayList<>();
        for (int cnt : freq.values()) {
            if (cnt >= 2) {
                long ways = ((long) cnt * (cnt - 1) / 2) % mod;
                pairsAtLevel.add(ways);
            }
        }

        // Total number of trapezoids is sum over all unordered pairs
        // Efficiently compute sum_{i < j} pairsAtLevel[i] * pairsAtLevel[j]
        long ans = 0, prefixSum = 0;
        for (long val : pairsAtLevel) {
            ans = (ans + (val * prefixSum) % mod) % mod;
            prefixSum = (prefixSum + val) % mod;
        }
        return (int) ans;
    }
}