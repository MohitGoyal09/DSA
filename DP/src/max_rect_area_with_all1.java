import java.util.*;
public class max_rect_area_with_all1 {


    class Solution {
        public int maximalAreaOfSubMatrixOfAll1(int[][] mat, int n, int m) {
            int maxArea = 0;
            int[] height = new int[m];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (mat[i][j] == 1) {
                        height[j]++;
                    } else {
                        height[j] = 0;
                    }
                }
                int area = largestRectangleArea(height);
                maxArea = Math.max(maxArea, area);
            }

            return maxArea;
        }

        public int largestRectangleArea(int[] heights) {
                Stack<Integer> stack = new Stack<>();
                int maxArea = 0;
                int n = heights.length;

                for (int i = 0; i <= n; i++) {
                    int h = (i == n) ? 0 : heights[i];

                    while (!stack.isEmpty() && h < heights[stack.peek()]) {
                        int height = heights[stack.pop()];
                        int width = stack.isEmpty() ? i : i - stack.peek() - 1;
                        maxArea = Math.max(maxArea, width * height);
                    }

                    stack.push(i);
                }

                return maxArea;
            }


    }

}
