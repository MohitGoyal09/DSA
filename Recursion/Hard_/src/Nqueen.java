import java.util.*;

public class Nqueen {
    public static void main(String[] args) {
        int N = 4;
        List < List < String >> queen = solveNQueens(N);
        int i = 1;
        for (List< String > it: queen) {
            System.out.println("Arrangement " + i);
            for (String s: it) {
                System.out.println(s);
            }
            System.out.println();
            i += 1;
        }
    }

    private static List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        for (int i = 0 ; i < n ; i++){
            for (int j = 0 ; j < n ; j++){
                board[i][j] = '.';
            }
        }
        List<List<String>> res = new ArrayList<List < String >>();
        df(board , 0 , res);
        return res;
    }

    private static void df(char[][] board, int col, List<List<String>> res) {
        if (col == board.length){
            res.add(construct(board));
            return;
        }
        for (int row = 0 ; row < board.length ; row++){
            if (isSafe(board , row , col)){
                board[row][col] = 'Q';
                df(board , col + 1 , res);
                board[row][col] = '.';
            }
        }
    }

    private static boolean isSafe(char[][] board, int row, int col) {
        int duprow = row;
        int dupcol = col;
        while (row >= 0 && col >= 0){
            if (board[row][col] == 'Q') return false;
            row--;
            col--;
        }
        row = duprow;
        col = dupcol;
        while (col >= 0){
            if (board[row][col] == 'Q') return false;
            col--;
        }
        row = duprow;
        col = dupcol;
        while (col >= 0 && row < board.length){
            if (board[row][col] == 'Q') return false;
            col--;
            row++;
        }
        return true;
    }

    static List < String > construct(char[][] board) {
        List < String > res = new LinkedList < String > ();
        for (int i = 0; i < board.length; i++) {
            String s = new String(board[i]);
            res.add(s);
        }
        return res;
    }

}
