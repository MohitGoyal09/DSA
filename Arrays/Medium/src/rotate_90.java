public class rotate_90 {
    public static void main(String[] args) {
        int arr[][] =  {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int n = arr.length;
        int[][] ans = burutte(arr , n);
        System.out.println("Rotated Image");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(ans[i][j] + " ");
            }
            System.out.println();
        }
    }

    // ? Brutte Force
    // ! Time Complexity : O(N^2)
    // ! Space Complexity : O(N^2)
    static int[][] burutte( int[][] matrix , int n){
        int[][] ans = new int[n][n];
        for (int i = 0 ; i  < n ; i++){
            for ( int j = 0 ; j < n ; j++){
                ans[j][n-i-1] = matrix[i][j];
            }
        }
        return ans;
    }

    // ? Optimal Approach
    // * 1. Transpose matrix
    // * 2. Reverse each row
    // ! Time Complexity : O(N*N) + O(N*N)
    // ! Space Complexity : O(1)
    static int[][] optimal(int[][] matrix , int n){

        // Transpose matrix
        for ( int i = 0 ; i < matrix.length ; i++ ){
            for ( int j = i ; j < matrix[0].length ; j++ ){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        // Reverseing Individual Rows
        for ( int i = 0 ; i < matrix.length ; i++){
            for ( int j = 0 ; j < matrix.length/2 ; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][matrix.length-1-j];
                matrix[i][matrix.length-1-j] = temp;
            }
        }
        return matrix;
    }
}
