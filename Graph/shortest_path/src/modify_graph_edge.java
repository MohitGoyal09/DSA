import java.util.*;
public class modify_graph_edge {
    class Solution {
        public int[][] modifiedGraphEdges(int n, int[][] edges, int source, int destination, int target) {
            List<int[]>[] adjacencyList = new ArrayList[n];
            for (int i = 0; i < n; i++) {
                adjacencyList[i] = new ArrayList<>();
            }
            for (int i = 0; i < edges.length; i++) {
                int nodeA = edges[i][0], nodeB = edges[i][1];
                adjacencyList[nodeA].add(new int[]{nodeB, i});
                adjacencyList[nodeB].add(new int[]{nodeA, i});
            }

            int[][] distances = new int[n][2];
            Arrays.fill(distances[source], 0);
            for (int i = 0; i < n; i++) {
                if (i != source) {
                    distances[i][0] = distances[i][1] = Integer.MAX_VALUE;
                }
            }

            runDijkstra(adjacencyList, edges, distances, source, 0, 0);
            int difference = target - distances[destination][0];
            if (difference < 0) return new int[][]{};
            runDijkstra(adjacencyList, edges, distances, source, difference, 1);
            if (distances[destination][1] < target) return new int[][]{};

            for (int[] edge : edges) {
                if (edge[2] == -1) edge[2] = 1;
            }
            return edges;
        }

        private void runDijkstra(List<int[]>[] adjacencyList, int[][] edges, int[][] distances, int source, int difference, int run) {
            int n = adjacencyList.length;
            PriorityQueue<int[]> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
            priorityQueue.add(new int[]{source, 0});
            distances[source][run] = 0;

            while (!priorityQueue.isEmpty()) {
                int[] current = priorityQueue.poll();
                int currentNode = current[0];
                int currentDistance = current[1];

                if (currentDistance > distances[currentNode][run]) continue;

                for (int[] neighbor : adjacencyList[currentNode]) {
                    int nextNode = neighbor[0], edgeIndex = neighbor[1];
                    int weight = edges[edgeIndex][2];

                    if (weight == -1) weight = 1; // Initially consider -1 as 1

                    if (run == 1 && edges[edgeIndex][2] == -1) {

                        int newWeight = difference + distances[nextNode][0] - distances[currentNode][1];
                        if (newWeight > weight) {
                            edges[edgeIndex][2] = weight = newWeight;
                        }
                    }

                    if (distances[nextNode][run] > distances[currentNode][run] + weight) {
                        distances[nextNode][run] = distances[currentNode][run] + weight;
                        priorityQueue.add(new int[]{nextNode, distances[nextNode][run]});
                    }
                }
            }
        }
    }
}
