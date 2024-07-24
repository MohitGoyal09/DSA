import java.util.ArrayList;

public class undirected_cycle {
    public boolean isCyclic(int V , ArrayList<ArrayList<Integer>> adj){
        int[] vist = new int[V];
        int[] pathVist = new int[V];
        for (int i = 0 ; i < V ;i++){
            if (vist[i] == 0){
                if (dfs(i, adj, vist, pathVist)) return true;
            }
        }
        return false;
    }

    public boolean dfs(int node , ArrayList<ArrayList<Integer>> adj , int[] vis , int[] pathvist){
        vis[node] = 1;
        pathvist[node] = 1;

        for (int it : adj.get(node)){
            if (vis[it] == 0){
                if (dfs(it, adj, vis, pathvist)) return true;
            }
            else if (pathvist[it] == 1 ) return true;
        }
        pathvist[node] = 0;
        return false;
    }
}
