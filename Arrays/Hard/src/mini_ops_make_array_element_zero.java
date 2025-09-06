class Solution {
    /**
     * For each query [l, r], calculate the minimum number of operations needed.
     * The result for each query is (steps + 1) / 2, where steps is calculated by the solve() method.
     */
    public long minOperations(int[][] queries) {
        long result = 0 ;
        for (int[] query : queries){
            int l = query[0];
            int r = query[1];
            // Calculate the total steps required for the range [l, r]
            long steps = solve(l, r);
            // Each operation can affect two elements, so we need (steps + 1) / 2 operations
            result += (steps + 1) / 2;
        }
        return result;
    }

    /**
     * The solve method calculates the total number of "steps" needed for the range [l, r].
     * The approach is based on dividing the range into segments of the form [L, R] where:
     *   - L starts at 1 and is multiplied by 4 each iteration (L = 1, 4, 16, ...)
     *   - R = 4*L - 1, so the segment is [L, R]
     *   - S is the step count for the current segment, starting at 1 and incremented each time
     * For each segment, we find the overlap with [l, r] and add (end - start + 1) * S to the total steps.
     */
    public long solve(int l , int r){
        long L = 1; // Start of current segment
        long S = 1; // Step count for current segment
        long steps = 0;
        while (L <= r){
            long R = 4 * L - 1; // End of current segment
            // Find overlap between [L, R] and [l, r]
            long start = Math.max(L, (long) l);
            long end = Math.min(R, (long) r);
            if (start <= end ){
                // Add the number of elements in the overlap times the step count
                steps += (end - start + 1) * S;
            }
            S += 1;      // Increment step count for next segment
            L = L * 4;   // Move to next segment
        }
        return steps;
    }
}