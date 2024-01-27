public class zero_matrix {
    public static void main(String[] args) {
        int[][]  matrix = new int[][]{{1,1,1,1},{1,0,1,1},{1,1,0,1},{0,1,1,1}};
        matrix = optimal(matrix);
        print2DArray(matrix);
    }


    // ? Burute Force
    /*  Time Complexity : Time Complexity: O((N*M)*(N + M)) + O(N*M),
    where N = no. of rows in the matrix and M = no. of columns in the matri */
    // ! Space Complexity : O(1)

    static int[][] zero(int[][] arr){
        int n = arr.length;
        int m = arr[0].length;
        for ( int i  = 0 ; i < n ; i++){
            for ( int  j = 0 ; j < m ; j++){
                if (arr[i][j] == 0){
                    markcol(arr , n , m , j);
                    markrow(arr , n , m , i);
                }
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++) {
                if (arr[i][j] == -1) {
                    arr[i][j] = 0;
                }
            }
        }
        return arr;
    }

    static void markcol(int[][] arr , int n , int m , int j){
        for (int i = 0 ; i < n ; i++){
            if (arr[i][j] !=0){
                arr[i][j] = -1;
            }
        }
    }

    static void markrow(int[][] arr , int n , int m , int i){
        for (int j = 0 ; j < m ; j++){
            if (arr[i][j] !=0){
                arr[i][j] = -1;
            }
        }
    }

    public static void print2DArray(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }


    // ? Better Approach
    // ! Time Complexity : O(2*(N*M)), where N = no. of rows in the matrix and M = no. of columns in the matrix.
    // ! Space Complexity : O(n) + O(m)
    static int[][] better(int[][] a){
        int n = a.length;
        int m = a[0].length;
        int[] row = new int[n];
        int[] col = new int[m];
        for ( int i = 0 ; i < n ; i++){
            for ( int j = 0; j < m ; j++){
                if (a[i][j] == 0){
                    row[i] = 1;
                    col[j] = 1;
                }
            }
        }
        for ( int i = 0 ; i < n ; i++){
            for ( int j  = 0 ; j < m ; j++){
                if (row[i] == 1 || col[j] == 1){
                    a[i][j] = 0;
                }
            }
        }
        return a;
    }

    static int[][] optimal(int[][] a){
        int n = a.length;
        int m = a[0].length;
        // int[] roo = new int[n]; --> matrix[..][0]
        // int[] col = new int[m]; --> matrix[0][..]
        boolean fr = false,fc = false;
        for ( int i = 0; i < n ; i++){
            for ( int j = 0; j < m ;j++){
                if (a[i][j] == 0) {
                    if(i == 0) fr = true;
                    if(j == 0) fc = true;
                    // mark the j-th column
                    a[0][j] = 0;
                    // mark the i-th row
                    a[i][0] = 0;
                }
            }
        }
        for ( int i = 1; i < n ; i++){
            for (int j = 1 ; j < m ; j++){
                if(a[i][0] == 0 || a[0][j] == 0){
                    a[i][j] = 0;
                }
            }
        }
        if(fr) {
            for(int j = 0; j < a[0].length; j++) {
                a[0][j] = 0;
            }
        }
        if(fc) {
            for(int i = 0; i < a.length; i++) {
                a[i][0] = 0;
            }
        }

        return a;
    }
}

