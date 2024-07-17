import java.util.LinkedList;
import java.util.Queue;
public class no_of_islands {
 // ! Aprroch
//    Certainly! Here are some short notes to help you revise the Number of Islands algorithm:
//
//    *       1.   Problem: Count connected components of '1's in a 2D grid.
//
// * 2. Approach: Use Breadth-First Search (BFS) to explore each island.
//
//          *  3. Key Components:
//            - `Pair` class: Stores row and column coordinates.
//   - `bfs` function: Explores and marks all cells of an island.
//            - `numIslands` function: Counts total islands.
//
// * 4. Algorithm Steps:
//    a. Iterate through the grid.
//    b. When an unvisited '1' is found, increment island count.
//    c. Perform BFS from that cell to mark entire island.
//    d. Repeat until all cells are checked.
//
//         *   5. BFS Implementation:
//            - Use a queue to store cells to visit.
//            - Use direction arrays for up, down, left, right movement.
//            - Mark cells as visited to avoid revisiting.
//
//  *6. Time Complexity: O(m * n), where m and n are grid dimensions.
//    Space Complexity: O(min(m, n)) for the queue in worst case.
//
//      *       7. Common Pitfalls:
//            - Ensure proper boundary checks.
//            - Correctly mark all connected '1's as visited.
//   - Remember to increment island count for each new island found.


    class Solution {
        // Helper class to store coordinates
        class Pair {
            int first, second;
            Pair(int first, int second) {
                this.first = first;
                this.second = second;
            }
        }

        // BFS function to explore and mark an entire island
        private void bfs(int row, int col, int[][] vis, char[][] grid) {
            vis[row][col] = 1; // Mark current cell as visited
            Queue<Pair> q = new LinkedList<>();
            q.add(new Pair(row, col));
            int n = grid.length;
            int m = grid[0].length;

            // Directions for moving up, down, left, right
            int[] delRow = {-1, 1, 0, 0};
            int[] delCol = {0, 0, -1, 1};

            while (!q.isEmpty()) {
                int curRow = q.peek().first;
                int curCol = q.peek().second;
                q.remove();

                // Explore all 4 directions
                for (int i = 0; i < 4; i++) {
                    int nrow = curRow + delRow[i];
                    int ncol = curCol + delCol[i];

                    // Check if the new cell is valid, unvisited, and part of the island
                    if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < m &&
                            grid[nrow][ncol] == '1' && vis[nrow][ncol] == 0) {
                        vis[nrow][ncol] = 1; // Mark as visited
                        q.add(new Pair(nrow, ncol)); // Add to queue for further exploration
                    }
                }
            }
        }

        // Main function to count number of islands
        public int numIslands(char[][] grid) {
            int n = grid.length;
            int m = grid[0].length;
            int[][] vis = new int[n][m]; // Visited array
            int count = 0; // Island counter

            // Iterate through each cell in the grid
            for (int row = 0; row < n; row++) {
                for (int col = 0; col < m; col++) {
                    // If cell is unvisited and part of an island
                    if (vis[row][col] == 0 && grid[row][col] == '1') {
                        count++; // Increment island count
                        bfs(row, col, vis, grid); // Explore the entire island
                    }
                }
            }
            return count;
        }



    }


}
