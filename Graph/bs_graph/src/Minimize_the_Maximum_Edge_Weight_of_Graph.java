import java.util.*;
public class Minimize_the_Maximum_Edge_Weight_of_Graph {

        boolean isPossible(int n, int[][] edges, int maxWeight) {
            List<List<Integer>> revGraph = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                revGraph.add(new ArrayList<>());
            }

            for (int[] e : edges) {
                if (e[2] <= maxWeight) {
                    revGraph.get(e[1]).add(e[0]);
                }
            }

            boolean[] visited = new boolean[n];
            Queue<Integer> q = new LinkedList<>();
            q.offer(0);
            visited[0] = true;
            int count = 1;

            while (!q.isEmpty()) {
                int cur = q.poll();
                for (int nxt : revGraph.get(cur)) {
                    if (!visited[nxt]) {
                        visited[nxt] = true;
                        q.offer(nxt);
                        count++;
                    }
                }
            }

            return count == n;
        }

        public int minMaxWeight(int n, int[][] edges, int threshold) {
            int minW = Integer.MAX_VALUE, maxW = 0;
            for (int[] e : edges) {
                minW = Math.min(minW, e[2]);
                maxW = Math.max(maxW, e[2]);
            }
            int ans = -1, l = minW, h = maxW;
            while (l <= h) {
                int mid = l + (h - l) / 2;
                if (isPossible(n, edges, mid)) {
                    ans = mid;
                    h = mid - 1;
                } else {
                    l = mid + 1;
                }
            }

            return ans;
        }

}
