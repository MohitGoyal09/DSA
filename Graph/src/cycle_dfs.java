import java.util.*;
public class cycle_dfs {
    public boolean cycle(int V , ArrayList<ArrayList<Integer>> adj ){
        int[] vis = new int[V];
        for (int i = 0 ; i < V ; i++){
            if (vis[i] == 0){
                if ( dfs(i , -1 , adj , vis) == true)
                    return true;
            }
        }
        return false;
    }
    public boolean dfs(int node , int par , ArrayList<ArrayList<Integer>> adj , int[] vis){
        vis[node] = 1;
        for (int it : adj.get(node)){
            if (vis[it] == 0){
                if (dfs(it, node, adj, vis))
                    return true;
            }
            else if (it != par){
                return true;
            }
        }
        return false;
    }
}
