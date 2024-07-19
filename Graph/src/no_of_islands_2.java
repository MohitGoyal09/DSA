import java.util.*;
class Pair {
    int first;
    int second;
    public Pair(int first, int second) {
        this.first = first;
        this.second = second;
    }
}
public class no_of_islands_2 {
    class Solution {
        private void bfs(int ro, int co, int[][] vis, char[][] grid) {
            vis[ro][co] = 1;
            Queue<Pair> q = new LinkedList<Pair>();
            q.add(new Pair(ro, co));
            int n = grid.length;
            int m = grid[0].length;

            // until the queue becomes empty
            while(!q.isEmpty()) {
                int row = q.peek().first;
                int col = q.peek().second;
                q.remove();

                // traverse in the neighbours and mark them if its a land
                for(int delrow = -1; delrow<=1;delrow++) {
                    for(int delcol = -1; delcol <= 1; delcol++) {
                        int nrow = row + delrow;
                        int ncol = col + delcol;
                        // check if neighbour row and column is valid, and is an unvisited land
                        if(nrow >= 0 && nrow < n && ncol >= 0 && ncol < m
                                && grid[nrow][ncol] == '1' && vis[nrow][ncol] == 0) {
                            vis[nrow][ncol] = 1;
                            q.add(new Pair(nrow, ncol));
                        }
                    }
                }
            }
        }

        // Function to find the number of islands.
        public int numIslands(char[][] grid) {
            int n = grid.length;
            int m = grid[0].length;
            int[][] vis = new int[n][m];
            int cnt = 0;
            for(int row = 0; row < n ; row++) {
                for(int col = 0; col < m ;col++) {
                    // if not visited and is a land
                    if(vis[row][col] == 0 && grid[row][col] == '1') {
                        cnt++;
                        bfs(row, col, vis, grid);
                    }
                }
            }
            return cnt;
        }
}
}
