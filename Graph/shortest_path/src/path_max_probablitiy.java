public class path_max_probablitiy {
//    Approach 🚀
//  1️⃣Initialize an array dist where dist[i] holds the maximum probability to reach node i from
//    the start node. Set dist[start] = 1 since the probability of starting at the start node is 1.
//  2️⃣ Perform up to n-1 iterations, where n is the number of nodes. In each
//       iteration, check each edge and update the probability of reaching the neighboring nodes.
//  3️⃣ For each edge (u, v), if the probability of reaching v through u
//            (i.e., dist[u] * succProb[i]) is greater than the current known probability to reach v (dist[v]),
//    update dist[v]. Similarly, update dist[u] if the probability of reaching u through v is greater.
//  4️⃣  After completing the iterations, dist[end] will contain the maximum probability of reaching the
//    end node from the start node. If there's no path, it will remain 0.
    class Solution {
        public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
            double[] maxProb = new double[n];
            maxProb[start_node] = 1.0;

            for (int i = 0; i < n - 1; i++) {
                boolean updated = false;
                for (int j = 0; j < edges.length; j++) {
                    int u = edges[j][0];
                    int v = edges[j][1];
                    double prob = succProb[j];

                    if (maxProb[u] * prob > maxProb[v]) {
                        maxProb[v] = maxProb[u] * prob;
                        updated = true;
                    }
                    if (maxProb[v] * prob > maxProb[u]) {
                        maxProb[u] = maxProb[v] * prob;
                        updated = true;
                    }
                }
                if (!updated) break;
            }

            return maxProb[end_node];
        }
    }
}
