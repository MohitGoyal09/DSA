import java.util.*;

// !               PRIM 'S ALGO
public class Main {
    static class Pair {
        int node;
        int distance;
        public Pair(int distance, int node) {
            this.node = node;
            this.distance = distance;
        }
    }
    class Solution {
        //Function to find sum of weights of edges of the Minimum Spanning Tree.
        static int spanningTree(int V,
                                ArrayList<ArrayList<ArrayList<Integer>>> adj) {
            PriorityQueue<Pair> pq =
                    new PriorityQueue<Pair>((x, y) -> x.distance - y.distance);

            int[] vis = new int[V];
            // {wt, node}
            pq.add(new Pair(0, 0));
            int sum = 0;
            while (!pq.isEmpty()) {
                int wt = pq.peek().distance;
                int node = pq.peek().node;
                pq.remove();

                if (vis[node] == 1) continue;
                // add it to the mst
                vis[node] = 1;
                sum += wt;

                for (int i = 0; i < adj.get(node).size(); i++) {
                    int edW = adj.get(node).get(i).get(1);
                    int adjNode = adj.get(node).get(i).get(0);
                    if (vis[adjNode] == 0) {
                        pq.add(new Pair(edW, adjNode));
                    }
                }
            }
            return sum;
        }
    }


}