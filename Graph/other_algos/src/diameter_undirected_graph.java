import java.util.*;

// ! Trick:
// * Select the random Node (U) and find the farthest node from it (V).
// * Now, find the farthest node from V (say W).
// * The distance between V and W is the diameter of the graph.
public class diameter_undirected_graph {
        public static void main(String[] args) {
            int[][] edges = {{0, 1}, {1, 2}, {2, 3}, {1, 4}, {4, 5}};
            diameter_undirected_graph obj = new diameter_undirected_graph();
            System.out.println(obj.treeDiamter(edges));
        }
     public int treeDiamter(int[][] edges){
         int n = edges.length + 1;
         Map<Integer , List<Integer>> adj = new HashMap<>();
         for (int edge[]: edges){
             adj.computeIfAbsent(edge[0], k -> new ArrayList<>()).add(edge[1]);
             adj.computeIfAbsent(edge[1], k -> new ArrayList<>()).add(edge[0]);
         }
         return diameter(n , adj);
     }

     private int diameter(int n ,Map<Integer , List<Integer>> adj ){
           int[] farthestNodeResult = findFarthestNode(n , adj , 0);
           int[] result = findFarthestNode(n , adj , farthestNodeResult[0]);
           return result[1];
     }
    // BFS helper function to find the farthest node and its distance from the source
    private int[] findFarthestNode(int n, Map<Integer, List<Integer>> adj, int sourceNode) {
        Queue<Integer> que = new LinkedList<>();
        boolean[] visited = new boolean[n];

        // Push source node into the queue
        que.add(sourceNode);
        visited[sourceNode] = true;

        int maximumDistance = 0;
        int farthestNode = sourceNode;

        // Explore neighbors
        while (!que.isEmpty()) {
            int size = que.size();
            for (int i = 0; i < size; i++) {
                int currentNode = que.poll();
                // Update farthest node
                farthestNode = currentNode;

                for (int neighbor : adj.getOrDefault(currentNode, new ArrayList<>())) {
                    if (!visited[neighbor]) {
                        visited[neighbor] = true;
                        que.add(neighbor);
                    }
                }
            }
            if (!que.isEmpty()) maximumDistance++;
        }

        // Return an array with farthest node and its distance
        return new int[]{farthestNode, maximumDistance};
    }
}
