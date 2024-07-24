import java.util.*;
public class cycle_bfs {
    public static void main(String[] args) {

    }
    static class Solution
    {
        boolean checkForCycle(ArrayList<ArrayList<Integer>> adj, int s,
                              boolean[] vis, int[] parent)
        {
            Queue<Node> q =  new LinkedList<>(); //BFS
            q.add(new Node(s, -1));
            vis[s] =true;

            // until the queue is empty
            while(!q.isEmpty())
            {
                // source node and its parent node
                int node = q.peek().first;
                int par = q.peek().second;
                q.remove();

                // go to all the adjacent nodes
                for(Integer it: adj.get(node))
                {
                    if(!vis[it])
                    {
                        q.add(new Node(it, node));
                        vis[it] = true;
                    }

                    // if adjacent node is visited and is not its own parent node
                    else if(par != it) return true;
                }
            }

            return false;
        }

        // function to detect cycle in an undirected graph
        public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj)
        {
            boolean[] vis = new boolean[V];
            Arrays.fill(vis,false);
            int[] parent = new int[V];
            Arrays.fill(parent,-1);

            for(int i=0;i<V;i++)
                if(!vis[i])
                    if(checkForCycle(adj, i,vis, parent))
                        return true;

            return false;
        }
}
static class Node {
        int first;
        int second;
        public Node(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }
}