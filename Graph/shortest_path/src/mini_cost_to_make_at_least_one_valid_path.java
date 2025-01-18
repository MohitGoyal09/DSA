import java.util.*;
public class mini_cost_to_make_at_least_one_valid_path {
    // ! TIME LIMIT EXCEEDED
    //* T.C : O(4^(m*n))
//* S.C : O(m*n)
    class Solution {
        int[][] dir = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        int m, n;

        public int minCost(int[][] grid) {
            m = grid.length;
            n = grid[0].length;
            boolean[][] visited = new boolean[m][n];
            return dfs(0, 0, grid, visited, 0);
        }

        private int dfs(int i, int j, int[][] grid, boolean[][] visited, int cost) {
            if (i == m - 1 && j == n - 1) { // reached destination
                return cost;
            }

            visited[i][j] = true;

            int minCost = Integer.MAX_VALUE;
            for (int dir_i = 0; dir_i <= 3; dir_i++) {
                int i_ = i + dir[dir_i][0];
                int j_ = j + dir[dir_i][1];

                if (i_ >= 0 && i_ < m && j_ >= 0 && j_ < n && !visited[i_][j_]) {
                    int nextCost = cost + ((grid[i][j] - 1 != dir_i) ? 1 : 0);
                    minCost = Math.min(minCost, dfs(i_, j_, grid, visited, nextCost));
                }
            }

            visited[i][j] = false;
            return minCost;
        }
    }
   // ! DIJKSTRA
    //* T.C : O(m*n*log(m*n))
//* S.C : O(m*n)
    public int minCost(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;

        int[][] minCost=new int[m][n];
        for(int i=0; i<m; i++){
            Arrays.fill(minCost[i], Integer.MAX_VALUE);
        }

        Deque<int[]> dque=new ArrayDeque<>();
        dque.offerFirst(new int[]{0,0});
        minCost[0][0]=0;

        int[][] direction={ {0,1}, {0,-1}, {1,0}, {-1,0} };

        while(!dque.isEmpty()){
            int[] arr=dque.pollFirst();
            int r=arr[0];
            int c=arr[1];

            //Visited adjacent cells
            for(int i=0; i<4; i++){
                int nr=r+direction[i][0];
                int nc=c+direction[i][1];
                int cost=(grid[r][c]!=(i+1))?1:0;

                if( nr>=0 && nr<m && nc>=0 && nc<n && minCost[r][c]+cost<minCost[nr][nc]){
                    minCost[nr][nc]=minCost[r][c]+cost;

                    if(cost==1){
                        dque.offerLast(new int[]{nr,nc});
                    }else{
                        dque.offerFirst(new int[]{nr,nc});
                    }
                }
            }
        }

        return minCost[m-1][n-1];
    }
}
