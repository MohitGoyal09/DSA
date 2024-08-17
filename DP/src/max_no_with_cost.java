public class max_no_with_cost {
    class Solution {
        public long maxPoints(int[][] points) {
            int m = points.length, n = points[0].length;
            long[] prev = new long[n];
            for (int j = 0; j < n; j++) {
                prev[j] = points[0][j];
            }

            for (int i = 1; i < m; i++) {
                long[] left_max = new long[n];
                long[] right_max = new long[n];

                left_max[0] = prev[0];
                for (int j = 1; j < n; j++) {
                    left_max[j] = Math.max(left_max[j - 1] - 1, prev[j]);
                }

                right_max[n - 1] = prev[n - 1];
                for (int j = n - 2; j >= 0; j--) {
                    right_max[j] = Math.max(right_max[j + 1] - 1, prev[j]);
                }

                for (int j = 0; j < n; j++) {
                    prev[j] = points[i][j] + Math.max(left_max[j], right_max[j]);
                }
            }

            long maxPoints = 0;
            for (long pointsValue : prev) {
                maxPoints = Math.max(maxPoints, pointsValue);
            }

            return maxPoints;
        }
    }
}
