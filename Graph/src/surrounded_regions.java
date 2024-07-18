public class surrounded_regions {
    class Solution {
        public void solve(char[][] board) {
            int n = board.length;
            int m = board[0].length;
            int[][] vis = new int[n][m];
            int[] delrow = { -1 , 0 , 0 ,1};
            int[] delcol = { 0 , -1 , 1 , 0};

            // Check first and last row
            for (int i = 0 ; i < m ; i++){
                if (board[0][i] == 'O' && vis[0][i] == 0){
                    dfs(0 , i , vis , board , delrow , delcol);
                }
                if (board[n-1][i] == 'O' && vis[n-1][i] == 0){
                    dfs(n - 1 , i , vis , board , delrow , delcol);
                }
            }

            // Check first and last column
            for(int j = 0; j < n; j++) {
                if(vis[j][0] == 0 && board[j][0] == 'O') {
                    dfs(j, 0, vis, board, delrow, delcol);
                }

                if(vis[j][m-1] == 0 && board[j][m-1] == 'O') {
                    dfs(j, m-1, vis, board, delrow, delcol);
                }
            }

            // Change unvisited 'O's to 'X's
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < m; j++) {
                    if(vis[i][j] == 0 && board[i][j] == 'O')
                        board[i][j] = 'X';
                }
            }
        }

        public void dfs(int row , int col , int[][] vis , char[][] mat , int[] delrow , int[] delcol){
            vis[row][col] = 1;
            int n = mat.length;
            int m = mat[0].length;

            // check for top, right, bottom, left
            for(int i = 0; i < 4; i++) {
                int nrow = row + delrow[i];
                int ncol = col + delcol[i];
                // check for valid coordinates and unvisited Os
                if(nrow >= 0 && nrow < n && ncol >= 0 && ncol < m
                        && vis[nrow][ncol] == 0 && mat[nrow][ncol] == 'O') {
                    dfs(nrow, ncol, vis, mat, delrow, delcol);
                }
            }
        }
    }

}
