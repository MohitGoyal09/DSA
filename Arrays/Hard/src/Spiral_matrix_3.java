public class Spiral_matrix_3 {
    class Solution {
        public int[][] spiralMatrixIII(int rows, int cols, int rStart, int cStart) {
            int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}}; // East, South, West, North
            int[][] result = new int[rows * cols][2];
            int steps = 0, d = 0, len = 0;

            result[0] = new int[]{rStart, cStart};
            int count = 1;

            while (count < rows * cols) {
                if (d == 0 || d == 2) steps++; // Increase step size after moving East or West

                for (int i = 0; i < steps; i++) {
                    rStart += directions[d][0];
                    cStart += directions[d][1];

                    if (rStart >= 0 && rStart < rows && cStart >= 0 && cStart < cols) {
                        result[count++] = new int[]{rStart, cStart};
                    }

                    if (count == rows * cols) return result;
                }

                d = (d + 1) % 4; // Change direction
            }

            return result;
        }
    }
}
