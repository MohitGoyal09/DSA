public class magic_square {
    class Solution {
        public int numMagicSquaresInside(int[][] grid) {
            int count = 0;
            int rows = grid.length;
            int cols = grid[0].length;

            // *  Iterate through each possible 3x3 subgrid
            for (int i = 0; i <= rows - 3; i++) {
                for (int j = 0; j <= cols - 3; j++) {
                    if (isMagicSquare(grid, i, j)) {
                        count++;
                    }
                }
            }
            return count;
        }

        private boolean isMagicSquare(int[][] grid, int rowStart, int colStart) {
            // * Check if the 3x3 grid contains all numbers from 1 to 9
            boolean[] seen = new boolean[10];
            for (int i = rowStart; i < rowStart + 3; i++) {
                for (int j = colStart; j < colStart + 3; j++) {
                    int num = grid[i][j];
                    if (num < 1 || num > 9 || seen[num]) {
                        return false;
                    }
                    seen[num] = true;
                }
            }

            // * Calculate the sum of the first row
            int sum = grid[rowStart][colStart] + grid[rowStart][colStart + 1] + grid[rowStart][colStart + 2];

            // * Check rows
            for (int i = rowStart; i < rowStart + 3; i++) {
                if (grid[i][colStart] + grid[i][colStart + 1] + grid[i][colStart + 2] != sum) {
                    return false;
                }
            }

            // * Check columns
            for (int j = colStart; j < colStart + 3; j++) {
                if (grid[rowStart][j] + grid[rowStart + 1][j] + grid[rowStart + 2][j] != sum) {
                    return false;
                }
            }

            // * Check diagonals
            if (grid[rowStart][colStart] + grid[rowStart + 1][colStart + 1] + grid[rowStart + 2][colStart + 2] != sum) {
                return false;
            }
            return grid[rowStart][colStart + 2] + grid[rowStart + 1][colStart + 1] + grid[rowStart + 2][colStart] == sum;
        }
    }
}
