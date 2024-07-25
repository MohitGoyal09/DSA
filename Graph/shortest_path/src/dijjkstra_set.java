import java.util.*;
public class dijjkstra_set {


    class Solution {
        static class Pair {
            int distance;
            int node;

            public Pair(int distance, int node) {
                this.distance = distance;
                this.node = node;
            }
        }

        static int[] dijkstra(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int S) {
            Set<Pair> set = new HashSet<>();
            int[] dist = new int[V];
            for(int i = 0; i < V; i++) dist[i] = (int)(1e9);

            dist[S] = 0;
            set.add(new Pair(0, S));

            while(!set.isEmpty()) {
                Pair current = findMinDistancePair(set);
                set.remove(current);
                int dis = current.distance;
                int node = current.node;

                for(ArrayList<Integer> edge : adj.get(node)) {
                    int adjNode = edge.get(0);
                    int edgeWeight = edge.get(1);

                    if(dis + edgeWeight < dist[adjNode]) {
                        // If node is already in set, remove it
                        set.remove(new Pair(dist[adjNode], adjNode));

                        dist[adjNode] = dis + edgeWeight;
                        set.add(new Pair(dist[adjNode], adjNode));
                    }
                }
            }
            return dist;
        }

        private static Pair findMinDistancePair(Set<Pair> set) {
            Pair minPair = null;
            int minDistance = Integer.MAX_VALUE;
            for (Pair pair : set) {
                if (pair.distance < minDistance) {
                    minDistance = pair.distance;
                    minPair = pair;
                }
            }
            return minPair;
        }
    }
}
