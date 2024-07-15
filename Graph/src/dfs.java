import java.util.ArrayList;

public class dfs {

    public ArrayList<Integer> dfseach(int V, ArrayList<ArrayList<Integer>> adj){

        ArrayList<Integer> ls = new ArrayList<>();
        boolean vis[] = new boolean[V];
        vis[0] = true;
        dfs(0 , adj , vis , ls);
        return ls;
    }
    public void dfs(int node , ArrayList<ArrayList<Integer>> adj , boolean vis[] , ArrayList<Integer> ls){
        vis[node] = true;
        ls.add(node);
        for (Integer it : adj.get(node)){
            if (!vis[it]){
                dfs(it , adj , vis , ls);
            }
        }
    }
}
