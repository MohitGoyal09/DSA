// The 2D Difference Array Concept
// Now, we have extra dimention to care about: [rows,cols].

// To add a value to rectangle [row1,col1] to [row2,col2]:

// Add +1 at (row1,col1) (top-left corner)
// Add −1 at (row2+1,col1) (below bottom-left)
// Add −1 at (row1,col2+1) (right of top-right)
// Add +1 at (row2+1,col2+1) (diagonal from bottom-right)
// This marks the boundaries using the inclusion-exclusion principle.

// We can reconstruct the final matrix using the computed boundaries.

// The inclusion-exclusion principle ensures we don't double-count the diagonal cell.

//T.C : O(q*n + n*n)
//S.C : O(n*n) if we consider space of the result 2D Array , else O(1)
class Solution {
    public int[][] rangeAddQueries(int n, int[][] queries) {
        int[][] diff = new int[n][n];

        // Step 1: Process queries (Difference Array Technique)
        for (int[] q : queries) {
            int row1 = q[0];
            int col1 = q[1];
            int row2 = q[2];
            int col2 = q[3];

            for (int i = row1; i <= row2; i++) {
                diff[i][col1] += 1;
                if (col2 + 1 < n) {
                    diff[i][col2 + 1] -= 1;
                }
            }
        }

        // Step 2: Row-wise prefix sums
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < n; j++) {
                diff[i][j] += diff[i][j - 1];
            }
        }

        return diff;
    }
}