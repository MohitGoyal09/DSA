import java.util.*;
public class real_State {
    class Solution {
        private boolean dfsCheck(int node, List<List<Integer>> adj, int vis[], int pathVis[], int check[]) {
            vis[node] = 1;
            pathVis[node] = 1;


            for (int it : adj.get(node)) {
                if (vis[it] == 0) {
                    if (dfsCheck(it, adj, vis, pathVis, check)) {
                        check[node] = 0;
                        return true;
                    }
                } else if (pathVis[it] == 1) {
                    check[node] = 0;
                    return true;
                }
            }
            check[node] = 1;
            pathVis[node] = 0;
            return false;
        }

        List<Integer> eventualSafeNodes(int V, List<List<Integer>> adj) {
            int[] vis = new int[V];
            int[] pathVis = new int[V];
            int[] check = new int[V];

            for (int i = 0; i < V; i++) {
                if (vis[i] == 0) {
                    dfsCheck(i, adj, vis, pathVis, check);
                }
            }

            List<Integer> safeNodes = new ArrayList<>();
            for (int j = 0; j < V; j++) {
                if (check[j] == 1) {
                    safeNodes.add(j);
                }
            }

            return safeNodes;
        }
    }
    // ! BFS
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        List<List<Integer>> rev = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            rev.add(new ArrayList<>());
        }

        int[] indegree = new int[n];
        for (int i = 0; i < n; i++) {
            for (int node : graph[i]) {
                rev.get(node).add(i);
                indegree[i]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) {
                q.offer(i);
            }
        }

        boolean[] safe = new boolean[n];
        while (!q.isEmpty()) {
            int node = q.poll();
            safe[node] = true;

            for (int neighbor : rev.get(node)) {
                if (--indegree[neighbor] == 0) {
                    q.offer(neighbor);
                }
            }
        }

        List<Integer> safeNodes = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (safe[i]) {
                safeNodes.add(i);
            }
        }

        return safeNodes;
    }
}
