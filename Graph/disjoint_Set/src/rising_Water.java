import java.util.PriorityQueue;

public class rising_Water {
    class Solution {

        class Tuple{
            int maxWt;
            int x;
            int y;

            public Tuple(int maxWt, int x, int y){
                this.maxWt = maxWt;
                this.x = x;
                this.y = y;
            }
        }

        public int swimInWater(int[][] grid) {
            int n = grid.length;

            PriorityQueue<Tuple> pq = new PriorityQueue<>((a, b) -> {
                return a.maxWt - b.maxWt;
            });
            int[][] visited = new int[n][n];

            pq.add(new Tuple(grid[0][0], 0, 0));

            while(!pq.isEmpty()){
                Tuple t = pq.poll();
                int x = t.x;
                int y = t.y;
                int wt = t.maxWt;

                if(visited[x][y] == 1){
                    continue;
                }

                visited[x][y] = 1;

                if(x == n-1 && y == n-1){
                    return wt;
                }

                if(x > 0 && visited[x - 1][y] == 0){
                    int currWt = Math.max(wt, grid[x-1][y]);
                    pq.add(new Tuple(currWt, x-1, y));
                }
                if(y > 0 && visited[x][y - 1] == 0){
                    int currWt = Math.max(wt, grid[x][y-1]);
                    pq.add(new Tuple(currWt, x, y-1));
                }
                if(x < n-1 && visited[x + 1][y] == 0){
                    int currWt = Math.max(wt, grid[x+1][y]);
                    pq.add(new Tuple(currWt, x+1, y));
                }
                if(y < n-1 && visited[x][y + 1] == 0){
                    int currWt = Math.max(wt, grid[x][y+1]);
                    pq.add(new Tuple(currWt, x, y+1));
                }
            }

            return 0;
        }
    }
}
