import java.util.*;
public class Redundant_Connection {
    class DSU {
        int[] parent;
        int[] rank;

        public DSU(int n){
            parent = new int[n+1];
            rank = new int[n+1];
            for (int i = 1 ; i < n ; i++){
                parent[i] = i;
                rank[i] = 0;
            }

        }
        public int find(int x) {
            if (x != parent[x]) {
                parent[x] = find(parent[x]); // path compression
            }
            return parent[x];
        }
        public void union(int x, int y) {
            int x_parent = find(x);
            int y_parent = find(y);

            if (x_parent == y_parent) return;

            if (rank[x_parent] > rank[y_parent]) {
                parent[y_parent] = x_parent;
            } else if (rank[y_parent] > rank[x_parent]) {
                parent[x_parent] = y_parent;
            } else {
                parent[y_parent] = x_parent;
                rank[x_parent]++;
            }
        }
    }
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        DSU dsu = new DSU(n);

        for (int[] edge : edges) {
            int u = edge[0], v = edge[1];
            if (dsu.find(u) == dsu.find(v)) {
                return edge;
            }
            dsu.union(u, v);
        }
        return new int[0];
    }
}
