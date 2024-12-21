import java.util.*;
public class max_numner_of_k_divisible_compoenents {

 // ! Algo :
    // 1. Create a graph with n nodes and edges.
    // 2. Create an array to store inDegree of each node.
    // 3. Create an array to store the value of each node.
    // 4. Initialize the value of each node with the given values.
    // 5. For each edge, add the edge to the graph, increment the inDegree of both nodes.
    // 6. Create a queue and add nodes with inDegree == 1 to the queue.
    // 7. For each node in the queue, update the value of the node with the remainder of the value divided by k.
    // 8. If the updated value is 0, increment the component count.
    // 9. For each neighbour of the node, decrement the inDegree of the neighbour, add the updated value to the neighbour's value.
    // 10. If the inDegree of the neighbour is 1, add the neighbour to the queue.
    // 11. Return the component count
    class Solution {
        public int maxKDivisibleComponents(int n, int[][] edges, int[] values, int k) {
            if (n < 2) return 1;

            List<List<Integer>> gr = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                gr.add(new ArrayList<>());
            }

            int[] inDegree = new int[n];
            long[] nodeValues = new long[n];
            for (int i = 0; i < n; i++) {
                nodeValues[i] = values[i];
            }

            for (int[] edge : edges) {
                int u = edge[0], v = edge[1];
                gr.get(u).add(v);
                gr.get(v).add(u);
                inDegree[u]++;
                inDegree[v]++;
            }

            Queue<Integer> q = new LinkedList<>();
            for (int i = 0; i < n; i++) {
                if (inDegree[i] == 1) q.add(i);
            }

            int component = 0;
            while (!q.isEmpty()) {
                int cur = q.poll();
                inDegree[cur]--;
                long addValue = (nodeValues[cur] % k == 0) ? 0 : nodeValues[cur];
                if (addValue == 0) component++;

                for (int neighbour : gr.get(cur)) {
                    if (inDegree[neighbour] > 0) {
                        inDegree[neighbour]--;
                        nodeValues[neighbour] += addValue;
                        if (inDegree[neighbour] == 1) q.add(neighbour);
                    }
                }
            }

            return component;
        }
    }

}
