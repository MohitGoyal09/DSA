public class no_of_days_disconncet {
    class Solution {
        public int minDays(int[][] grid) {
            if (countIslands(grid) != 1) return 0;

            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[0].length; j++) {
                    if (grid[i][j] == 1) {
                        grid[i][j] = 0;
                        if (countIslands(grid) != 1) return 1;
                        grid[i][j] = 1;
                    }
                }
            }

            return 2;
        }

        private int countIslands(int[][] grid) {
            boolean[][] seen = new boolean[grid.length][grid[0].length];
            int islands = 0;

            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[0].length; j++) {
                    if (grid[i][j] == 1 && !seen[i][j]) {
                        islands++;
                        dfs(grid, i, j, seen);
                    }
                }
            }
            return islands;
        }

        private void dfs(int[][] grid, int r, int c, boolean[][] seen) {
            seen[r][c] = true;
            int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
            for (int[] dir : directions) {
                int nr = r + dir[0], nc = c + dir[1];
                if (nr >= 0 && nr < grid.length && nc >= 0 && nc < grid[0].length && grid[nr][nc] == 1 && !seen[nr][nc]) {
                    dfs(grid, nr, nc, seen);
                }
            }
        }
    }
}
