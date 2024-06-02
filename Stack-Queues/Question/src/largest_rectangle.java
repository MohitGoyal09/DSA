import java.util.Stack;

public class largest_rectangle {
    public static void main(String[] args) {

    }
    // ! Burutte Force
    static int largest(int arr[], int n) {
        int maxArea = 0;
        for (int i = 0; i < n; i++) {
            int minHeight = Integer.MAX_VALUE;
            for (int j = i; j < n; j++) {
                minHeight = Math.min(minHeight, arr[j]);
                maxArea = Math.max(maxArea, minHeight * (j - i + 1));
            }
        }
        return maxArea;
    }
    // ! Optimized Solution
    public static int area(int arr[]){
        int n = arr.length;
        int[] leftsmall = new int[n];
        int[] rightsmall = new int[n];
        Stack<Integer> st = new Stack<>();
        for (int i = 0 ; i < n ; i++){
            while (!st.isEmpty() && arr[st.peek()] >= arr[i]){
                st.pop();
            }
            if (st.isEmpty()) leftsmall[i] = 0;
            else leftsmall[i] = st.peek() + 1;
            st.push(i);
        }
        // * Clearning Stack for rightmax
        while (!st.isEmpty()) st.pop();
        for (int i = n - 1 ; i >= 0 ; i--){
            while (!st.isEmpty() && arr[st.peek()]>= arr[i]){
                st.pop();
            }
            if (st.isEmpty()) rightsmall[i] = n-1;
            else rightsmall[i] = st.peek() - 1;
            st.push(i);
        }
        int maxarea = 0;
        for (int i = 0 ; i < n ; i++){
            maxarea = Math.max(maxarea , (arr[i] * (rightsmall[i] - leftsmall[i] + 1)));
        }
        return maxarea;
    }
    // ! Optimzed
    public int largestRectangleArea(int[] heights) {
        Stack <Integer> st = new Stack <> ();
        int maxA = 0;
        int n = heights.length;
        for (int i = 0; i <= n; i++) {
            while (!st.empty() && (i == n || heights[st.peek()] >= heights[i])) {
                int height = heights[st.peek()];
                st.pop();
                int width;
                if (st.empty()) width = i;
                else width = i - st.peek() - 1;
                maxA = Math.max(maxA, width * height);
            }
            st.push(i);
        }
        return maxA;
    }
}


