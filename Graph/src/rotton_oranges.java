import java.util.*;
public class rotton_oranges {
    class Pair {
        int row;
        int col;
        int tm;
        public Pair(int row, int col, int tm) {
            this.row = row;
            this.col = col;
            this.tm = tm;
        }
    }

    class Solution {
        public int orangesRotting(int[][] grid) {
            int n = grid.length;
            int m = grid[0].length;
            Queue<Pair> q = new LinkedList<>();
            int[][] vis = new int[n][m];
            int count_fresh = 0;
            int cnt = 0;

            // Step 1: Initialize the queue with rotten oranges and count fresh oranges
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (grid[i][j] == 2) {
                        // Mark rotten orange as visited and add to queue
                        vis[i][j] = 2;
                        q.offer(new Pair(i, j, 0));
                    } else {
                        vis[i][j] = 0;
                    }
                    if (grid[i][j] == 1) count_fresh++; // Count fresh oranges
                }
            }

            // If no fresh oranges, return 0
            if (count_fresh == 0) return 0;

            int tmin = 0;
            // Define directions: left, up, right, down
            int[] dr = {0, -1, 1, 0};
            int[] dc = {-1, 0, 0, 1};

            // Step 2: BFS to rot fresh oranges
            while (!q.isEmpty()) {
                int row = q.peek().row;
                int col = q.peek().col;
                int t = q.peek().tm;
                tmin = Math.max(tmin, t); // Update max time
                q.remove();

                // Check all 4 adjacent cells
                for (int i = 0; i < 4; i++) {
                    int nrow = row + dr[i];
                    int ncol = col + dc[i];
                    // If adjacent cell is valid, fresh, and not visited
                    if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < m &&
                            grid[nrow][ncol] == 1 && vis[nrow][ncol] == 0) {
                        vis[nrow][ncol] = 2; // Mark as rotten
                        q.offer(new Pair(nrow, ncol, t + 1)); // Add to queue
                        cnt++; // Increment count of rotten oranges
                    }
                }
            }

            // Step 3: Check if all fresh oranges are rotten
            if (cnt != count_fresh) return -1;
            return tmin;
        }
    }

}
