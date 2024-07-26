import java.util.*;
public class Dijkstra_algo {
    static int[] dijkstra(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int S) {
        PriorityQueue<Pair> pq = new PriorityQueue<>( (x,y) -> x.distance - y.distance);
        int[] dist = new int[V];
        for (int i = 0 ; i < V ; i++) dist[i] = (int) 1e9;
        dist[S] = 0;
        pq.add(new Pair(0, S));
        while (!pq.isEmpty()){
            int dis = pq.peek().distance;
            int node = pq.peek().node;
            pq.remove();
            for (int i = 0 ; i < adj.get(node).size() ; i++){
                int adjNode = adj.get(node).get(i).get(0);
                int wt = adj.get(node).get(i).get(1);
                if (dis + wt < dist[adjNode]){
                    dist[adjNode] = dis + wt;
                    pq.add(new Pair(dist[adjNode], adjNode));
                }
            }
        }
        return dist;
    }
}
