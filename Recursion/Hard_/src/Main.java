import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

            }
    public static ArrayList<String> findpath(int[][] m , int n ){
        int vis[][] = new int[n][n];
        for (int i = 0 ; i < n ; i++){
            for (int j = 0 ;  j < n ; j++ ){
                vis[i][j] = 0;
            }
        }
        ArrayList<String> list = new ArrayList<>();
        if (m[0][0] == 1) solve(0,0,m,n,list,"",vis);
        return list;
    }

    private static void solve(int i, int j, int[][] m, int n, ArrayList<String> list, String move, int[][] vis) {
        if ( i == n-1 && j == n-1){
            list.add(move);
            return;
        }
        // * Downward
        if (i+1 < n  && vis[i+1][j] == 0 && m[i+1][j] == 1){
            vis[i+1][j] = 1;
            solve(i+1 , j , m , n , list , move +"D",vis);
            vis[i+1][j] = 0;
        }
        // * Leftward
        if (i-1 >= 0 && vis[i][j-1] == 0 && m[i][j-1] == 1){
            vis[i][j-1] = 1;
            solve(i , j-1 , m , n , list , move + "L" , vis);
            vis[i][j-1] = 0;
        }
        // * Rightward
        if ( j +1 < n && vis[i][j+1] == 0 && m[i][j+1] == 1){
            vis[i][j+1] = 1;
            solve(i , j+1 , m , n , list , move + "R" , vis);
            vis[i][j+1] = 0;
        }
        // * Upward
        if (i-1 >= 0 && vis[i-1][j] == 0 && m[i-1][j] == 1){
            vis[i-1][j] = 1;
            solve(i-1 , j , m , n , list , move + "U" , vis);
            vis[i-1][j] = 0;
        }
    }
    // ! More Optimized Approach
    public static ArrayList<String> findpath1(int[][] m , int n ){
        int vis[][] = new int[n][n];
        for (int i = 0 ; i < n ; i++){
            for (int j = 0 ;  j < n ; j++ ){
                vis[i][j] = 0;
            }
        }
        int di[] = {1, 0, 0, -1};
        int dj[] = {0, 1, -1, 0};
        ArrayList<String> list = new ArrayList<>();
        if (m[0][0] == 1) solve2(0,0,m,n,list,"",vis,di,dj);
        return list;
    }

    private static void solve2(int i, int j, int[][] m, int n, ArrayList<String> list, String move, int[][] vis, int[] di, int[] dj) {
        if ( i == n-1 && j == n-1){
            list.add(move);
            return;
        }
        String dir = "DLRU";
        for (int ind = 0 ; ind < 4 ; ind++){
            int nexti = i + di[ind];
            int nextj = j + dj[ind];
            if ( nexti >= 0 && nextj >= 0 && nexti < n && nextj < n && m[nexti][nextj] == 1 && vis[nexti][nextj] == 0){
                vis[i][j] = 1;
                solve2(nexti, nextj, m, n, list, move + dir.charAt(ind), vis, di, dj);
                vis[i][j] = 0;
            }
        }
    }
}