import java.util.*;
// ! Time & Space Complexity: O(m x n)
public class spiral_matrix {

    public static void main(String[] args) {
        int[][] arr = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
        List<Integer> ans = spiral(arr);
        System.out.println(ans);
    }



    static List<Integer> spiral(int[][] matrix){
        int left = 0;
        int n = matrix.length;
        int m = matrix[0].length;
        int bottom = n-1;
        int right = m-1;
        int top = 0;
        List<Integer> ans = new ArrayList<>();
        while ( top <= bottom && left <= right) {

           // left to right
            for (int i = left; i <= right; i++) {
                ans.add(matrix[top][i]);
            }
            top++;
            // top to bottom
            for (int i = top; i <= bottom; i++) {
                ans.add(matrix[i][right]);
            }
            right--;
            // right to left
            if ( top <= bottom) {
                for (int i = right; i >= left; i--) {
                    ans.add(matrix[bottom][i]);
                }

                bottom--;
            }
            //  bottom to top
            if ( left <= right) {
                for (int i = bottom; i >= top; i--) {
                    ans.add(matrix[i][left]);
                }
                left++;
            }
        }



        return ans;
    }


}
