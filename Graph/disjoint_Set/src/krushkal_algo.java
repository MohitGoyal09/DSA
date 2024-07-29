import java.util.*;

public class krushkal_algo {
    static class Edge implements Comparable<Edge> {
        int src;
        int nbr;
        int wt;

        public Edge(int src, int nbr, int wt) {
            this.src = src;
            this.nbr = nbr;
            this.wt = wt;
        }

        public int compareTo(Edge E) {
            return this.wt - E.wt;
        }
    }

    static int spanningTree(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj) {
        List<Edge> edges = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < adj.get(i).size(); j++) {
                int nbr = adj.get(i).get(j).get(0);
                int wt = adj.get(i).get(j).get(1);
                edges.add(new Edge(i, nbr, wt));
            }
        }
        DisjointSet db = new DisjointSet(V);
        Collections.sort(edges);
        int sum = 0;
        for (Edge edge : edges) {
            int wt = edge.wt;
            int u = edge.src;
            int v = edge.nbr;
            if (db.findUPar(u) != db.findUPar(v)) {
                sum += wt;
                db.unionBySize(u, v);
            }
        }
        return sum;
    }
}



