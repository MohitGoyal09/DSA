import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class directed_cycle_bfs {
    static boolean toposort(int V , ArrayList<ArrayList<Integer>> adj){
        int indgress[] = new int[V];
        for (int i = 0 ; i < V ; i++){
            for (int it : adj.get(i)){
                indgress[it]++;
            }
        }
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0 ; i < V ; i++){
            if (indgress[i] == 0){
                q.add(i);
            }
        }
        int cnt = 0;
        int i = 0;
        while (!q.isEmpty()){
            int node = q.peek();
            q.remove();
            cnt++;
            // node is in your topo sort
            // so please remove it from the indegree
            for (int it : adj.get(node)){
                indgress[i]--;
                if (indgress[it] == 0) q.add(it);
            }
        }
        if (cnt == V) return false;
        return true;
    }
}
