import java.util.Stack;

public class binaray_matrix {
    public static void main(String[] args) {

    }
    class Solution {
        public void calIndexOfNSL(int[] heights, int[] indexOfNSL) {
            Stack<Integer> s = new Stack<>();
            int n = heights.length;
            for (int i = 0; i < n; i++) {
                while (!s.isEmpty() && heights[s.peek()] >= heights[i]) s.pop();
                indexOfNSL[i] = s.isEmpty() ? -1 : s.peek();
                s.push(i);
            }
        }

        public void calIndexOfNSR(int[] heights, int[] indexOfNSR) {
            Stack<Integer> s = new Stack<>();
            int n = heights.length;
            for (int i = n - 1; i >= 0; i--) {
                while (!s.isEmpty() && heights[s.peek()] >= heights[i]) s.pop();
                indexOfNSR[i] = s.isEmpty() ? n : s.peek(); // IMP
                s.push(i);
            }
        }

        public int maxheight(int[] heights) {
            int n = heights.length;

            int[] indexOfNSL = new int[n];
            int[] indexOfNSR = new int[n];

            calIndexOfNSL(heights, indexOfNSL);
            calIndexOfNSR(heights, indexOfNSR);

            int maxArea = Integer.MIN_VALUE;
            for (int i = 0; i < n; i++) {
                maxArea = Math.max(maxArea, heights[i] * (indexOfNSR[i] - indexOfNSL[i] - 1));
            }
            return maxArea;
        }

        public int maximalRectangle(char[][] arr) {
            int m = arr.length;
            if (m == 0) return 0; // edge case
            int n = arr[0].length;

            int[] heights = new int[n];
            for (int j = 0; j < n; j++) {
                if (arr[0][j] == '0')
                    heights[j] = 0;
                else
                    heights[j] = 1;
            }

            int maxArea = maxheight(heights);
            for (int i = 1; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (arr[i][j] == '1')
                        heights[j]++;
                    else
                        heights[j] = 0;
                }
                maxArea = Math.max(maxArea, maxheight(heights));
            }

            return maxArea;
        }
    }

}
