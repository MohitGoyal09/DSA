import java.util.*;
public class max_no_of_points_grid_queries {
    int[][] directions = {{0,1} , {0,-1} , {1,0} , {-1,0}};
    public int[] maxPoints(int[][] grid, int[] queries) {
        int n = grid[0].length;
        int m = grid.length;
        int Q = queries.length;
        int[] result = new int[Q];
        for (int i = 0 ; i < Q ; i++){
            result[i] = bfs(grid, queries[i] , m , n);
        }
        return result;
    }
    public int bfs(int[][] grid , int val , int m , int n ){
        boolean[][] visited = new boolean[m][n];
        visited[0][0] = true;
        Queue<int[]> que = new LinkedList<>();
        que.offer(new int[]{0,0});
        int points = 0;

        while(!que.isEmpty()){
            int N = que.size();
            while(N-- > 0){
                int[] curr = que.poll();
                int i = curr[0] , j = curr[1];
                if (grid[i][j] > val) continue;
                points++;
                for (int[] dir : directions){
                    int i_ = i + dir[0];
                    int j_ = j + dir[1];

                    if (i_ >= 0 && i_ < m && j_ >= 0 && j_ < n && !visited[i_][j_] && grid[i_][j_] < val) {
                        que.offer(new int[]{i_, j_});
                        visited[i_][j_] = true;
                    }
                }


            }
        }
        return points;
    }
    public int dfs(int[][] grid, int i, int j, int val, boolean[][] visited, int m, int n) {
        if (i < 0 || i >= m || j < 0 || j >= n || visited[i][j] || grid[i][j] >= val) {
            return 0;
        }

        visited[i][j] = true;
        int points = 1;

        for (int[] dir : directions) {
            int i_ = i + dir[0];
            int j_ = j + dir[1];
            points += dfs(grid, i_, j_, val, visited, m, n);
        }

        return points;
    }
    // Approach-3 (Optimal Approach using sorting and min-heap)
// T.C : O(QlogQ + m*nlog(m*n)) - Notice that we won't visit any cell more than once (we mark them visited). Total cells = m*n and heap can have m*n cells in worst case
// S.C : O(m*n)
    public int[] maxPoints2(int[][] grid, int[] queries) {
        int m = grid.length;
        int n = grid[0].length;
        int Q = queries.length;
        int[] result = new int[Q];

        int[][] sortedQ = new int[Q][2];
        for (int i = 0; i < Q; i++) {
            sortedQ[i][0] = queries[i];
            sortedQ[i][1] = i;
        }
        Arrays.sort(sortedQ, Comparator.comparingInt(a -> a[0]));

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        boolean[][] visited = new boolean[m][n];
        int points = 0;

        pq.offer(new int[]{grid[0][0], 0, 0});
        visited[0][0] = true;

        for (int i = 0; i < Q; i++) {
            int queryValue = sortedQ[i][0];
            int idx = sortedQ[i][1];

            while (!pq.isEmpty() && pq.peek()[0] < queryValue) {
                int[] top = pq.poll();
                int x = top[1], y = top[2];
                points++;

                for (int[] dir : directions) {
                    int i_ = x + dir[0];
                    int j_ = y + dir[1];
                    if (i_ >= 0 && i_ < m && j_ >= 0 && j_ < n && !visited[i_][j_]) {
                        pq.offer(new int[]{grid[i_][j_], i_, j_});
                        visited[i_][j_] = true;
                    }
                }
            }
            result[idx] = points;
        }

        return result;
    }
}
