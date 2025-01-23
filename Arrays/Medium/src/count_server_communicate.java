import java.util.Arrays;
public class count_server_communicate {
    public int countServers(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[] colServerCount = new int[n];
        int[] rowAkelaServerCol = new int[m];
        Arrays.fill(rowAkelaServerCol, -1);

        int resultServers = 0;

        for (int row = 0; row < m; row++) {
            int countServersRow = 0;
            for (int col = 0; col < n; col++) {
                if (grid[row][col] == 1) {
                    countServersRow++;
                    colServerCount[col]++;
                    rowAkelaServerCol[row] = col;
                }
            }

            if (countServersRow > 1) {
                resultServers += countServersRow;
                rowAkelaServerCol[row] = -1; // no akela server in this row
            }
        }

        // Check Akela servers in each row
        for (int row = 0; row < m; row++) {
            if (rowAkelaServerCol[row] != -1) {
                int col = rowAkelaServerCol[row];
                if (colServerCount[col] > 1) {
                    resultServers++;
                }
            }
        }

        return resultServers;
    }

    // Approach - 2 (Better Approach)
// T.C : O(m*n)
// S.C : O(m+n)
    class Solution {
        public int countServers(int[][] grid) {
            int m = grid.length;
            int n = grid[0].length;

            int[] indexColCount = new int[n];
            int[] indexRowCount = new int[m];

            // Preprocessing
            for (int row = 0; row < m; row++) {
                for (int col = 0; col < n; col++) {
                    if (grid[row][col] == 1) { // found a server at grid[row][col]
                        indexColCount[col]++;
                        indexRowCount[row]++;
                    }
                }
            }

            int resultServers = 0;
            for (int row = 0; row < m; row++) {
                for (int col = 0; col < n; col++) {
                    if (grid[row][col] == 1 && (indexColCount[col] > 1 || indexRowCount[row] > 1)) {
                        resultServers++;
                    }
                }
            }
            return resultServers;
        }
    }

}
