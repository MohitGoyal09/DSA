// ! https://leetcode.com/problems/minimize-maximum-component-cost

// ! Time Complexity : O((E + V) * log W) , where W is maximum edge weight
// Space complexity: O(E+V)

// * Intuition
// 1. Problem Understanding
// You are given a connected undirected graph with weighted edges.

// You can remove any number of edges, but after removal, the graph must have at most k connected components.

// The cost of a component is the maximum edge weight within it (or 0 if no edges).

// Your goal: minimize the maximum component cost across all components.

// 2. High-Level Strategy
// Binary search on the answer: the max edge weight allowed in any component (mid).

// For a given mid, simulate removing all edges with weight > mid.

// Count how many connected components remain.

// If number of components ≤ k, it's a valid threshold → try smaller mid.

// Otherwise, try larger mid.

// 3. Graph Construction (graph)
// Store the original graph using vector<vector<pair<int,int>>>: graph[u].push_back({v, weight})

// This keeps both neighbors and edge weights for filtering.

// 4. Binary Search Logic
// Initialize:

// low = 0 (smallest possible edge weight)

// high = max edge weight among all edges

// ans = 0 (to store final result)

// While low <= high:

// Compute mid = (low + high) / 2

// If check(graph, mid, k) is true:

// Update ans = mid

// Search left: high = mid - 1

// Else:

// Search right: low = mid + 1
// 5. Threshold Validation (check function)
// a. Filter Graph
// Create a temporary adj list (vector<vector>) that includes only edges with weight ≤ mid.

// This simulates what the graph would look like after removing all heavier edges.

// b. Count Components using DFS
// Initialize visited array of size n.

// For each unvisited node:

// Increment component counter.

// Run DFS to visit all reachable nodes in that component.

// If component count exceeds k, return false.

// Otherwise, return true.
class Solution {
    public int minCost(int n, int[][] edges, int k) {
        List<List<int[]>> graph = new ArrayList<>();
        for (int i = 0 ; i < n  ;i++) graph.add(new ArrayList<>());

        int low = 0 , high = 0 , ans = 0;
        for (int[] edge : edges){
            int u = edge[0] , v = edge[1] , w  = edge[2];
            graph.get(u).add(new int[]{v , w});
            graph.get(v).add(new int[]{u , w});
            high = Math.max(high , w);
        }
        while (low <= high){
            int mid = (low + high)/2;
            if (check(graph , mid , k)){
                ans = mid;
                high = mid -1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }
    private boolean check(List<List<int[]>> graph , int mid , int k ){
        int n =  graph.size();
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0 ; i < n  ;i++) adj.add(new ArrayList<>());
        for (int u = 0 ; u < n ; u++){
            for (int [] edge : graph.get(u)){
                int v = edge[0] , w = edge[1];
                if (w<= mid) adj.get(u).add(v);
             }
        }
        boolean[] visited = new boolean[n];
        int components = 0;
        for (int i = 0 ; i < n ;i++){
            if (!visited[i]){
                components++;
                if (components > k) return false;
                dfs(i , adj , visited);
            }
        }
        return true;
    }
    
     private void dfs(int node, List<List<Integer>> adj, boolean[] visited) {
        visited[node] = true;
        for (int neighbor : adj.get(node)) {
            if (!visited[neighbor]) {
                dfs(neighbor, adj, visited);
            }
        }
}
}