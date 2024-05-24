

public class word_search {
    public static void main(String[] args) {

    }
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        for (int i = 0 ; i < m ; i++){
            for (int j = 0 ; j < n ; j++){
                if (ischeck(board,word , m , n , i , j ,0))
                    return true;
            }
        }
        return false;
    }

    private boolean ischeck(char[][] board, String word, int m, int n, int i, int j, int cur) {
        if (cur >= word.length()) return true;
        if (i < 0 || j < 0 || i >= m || j >= n || board[i][j] != word.charAt(cur))
            return false;
        char temp = board[i][j];
        board[i][j] = '*';
        boolean res = (ischeck(board,word, m, n, i - 1, j, cur + 1) ||
                ischeck(board, word, m, n, i + 1, j, cur + 1) ||
                ischeck(board, word, m, n, i, j - 1, cur + 1) ||
                ischeck(board, word, m, n, i, j + 1, cur + 1));
        board[i][j] = temp;
        return res;
    }



}
