import java.util.*;
public class mini_after_merging_two_trees {
    class Solution {
        public int minimumDiameterAfterMerge(int[][] edges1, int[][] edges2) {
            // Step 1: Construct adjacency lists for tree1 and tree2
            int n1 = edges1.length + 1; // Number of nodes in tree1
            ArrayList<ArrayList<Integer>> tree1 = new ArrayList<>();
            for (int i = 0; i < n1; i++) {
                tree1.add(new ArrayList<>());
            }
            for (int[] edge : edges1) {
                int u = edge[0];
                int v = edge[1];
                tree1.get(u).add(v);
                tree1.get(v).add(u);
            }

            int n2 = edges2.length + 1; // Number of nodes in tree2
            ArrayList<ArrayList<Integer>> tree2 = new ArrayList<>();
            for (int i = 0; i < n2; i++) {
                tree2.add(new ArrayList<>());
            }
            for (int[] edge : edges2) {
                int u = edge[0];
                int v = edge[1];
                tree2.get(u).add(v);
                tree2.get(v).add(u);
            }

            // Step 2: Calculate diameters of tree1 and tree2
            int diameter1 = findDiameter(tree1, n1);
            int diameter2 = findDiameter(tree2, n2);

            // Step 3: Calculate the merged tree's diameter
            int totalDiameter = (int) Math.ceil(diameter1 / 2.0) + (int) Math.ceil(diameter2 / 2.0) + 1;

            // Step 4: Return the maximum of the two diameters and the merged diameter
            return Math.max(Math.max(diameter1, diameter2), totalDiameter);
        }

        // Method to find the diameter of a tree
        int findDiameter(ArrayList<ArrayList<Integer>> tree, int n) {
            // First DFS to find the farthest node from any node (e.g., node 0)
            boolean[] visited1 = new boolean[n];
            int[] res1 = new int[2]; // Stores farthest node and its distance
            dfs(0, 0, tree, visited1, res1);

            // Second DFS from the farthest node found
            int farthestNode = res1[0];
            boolean[] visited2 = new boolean[n];
            int[] res2 = new int[2]; // Stores farthest distance
            dfs(farthestNode, 0, tree, visited2, res2);

            // Return the farthest distance (diameter)
            return res2[1];
        }

        // Recursive DFS to find the farthest node and distance
        void dfs(int node, int distance, ArrayList<ArrayList<Integer>> tree, boolean[] visited, int[] res) {
            visited[node] = true;

            // Update the farthest distance and node if necessary
            if (distance > res[1]) {
                res[0] = node;
                res[1] = distance;
            }

            // Traverse all unvisited neighbors
            for (int neighbor : tree.get(node)) {
                if (!visited[neighbor]) {
                    dfs(neighbor, distance + 1, tree, visited, res);
                }
            }
        }
    }
}
