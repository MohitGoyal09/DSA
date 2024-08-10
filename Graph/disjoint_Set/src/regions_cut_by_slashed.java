import java.util.*;
//Detailed Steps:
//Grid Representation:
//
//The grid is represented as a collection of points in a (n+1) x (n+1) matrix, where n is the length of the grid. This ensures that every cell in the grid corresponds to points in this matrix.
//Boundary Handling:
//
//All boundary points (points on the edges of the grid) are connected to a virtual root (point (0, 0)) to represent the infinite external region. This is crucial for counting enclosed regions formed by slashes.
//Union-Find Operations:
//
//As you traverse the grid, you perform union operations between specific points based on whether the character is a slash / or backslash \.
//If the current grid cell contains a slash /, the points (i+1, j) and (i, j+1) are connected.
//If the grid cell contains a backslash \, the points (i, j) and (i+1, j+1) are connected.
//If a union operation tries to connect two points that are already connected, it implies the formation of a new region, so the count is incremented.
//Counting Regions:
//
//The count variable keeps track of the number of regions formed. Initially set to 1 (since we start with one external region), it is incremented whenever a union operation connects points that are already in the same set, indicating an additional region.
//Complexity Analysis:
//Time Complexity:
//
//Union-Find Operations: Each union and find operation has an amortized time complexity of (O(alpha(N^2))), where (alpha) is the inverse Ackermann function, which grows very slowly.
//Total Operations: Since there are (O(n^2)) cells in the grid, and each may result in a constant number of union-find operations, the total time complexity is (O(N^2*alpha(N^2))), where (N = n+1).
//Space Complexity:
//
//Disjoint Set Data Structure: The space complexity is (O(N^2)) to store the parent and size arrays for all points in the grid.
//The space complexity primarily depends on the size of the grid, resulting in (O((n+1)^2)) space usage.
//Summary:
//This approach efficiently counts the number of regions formed by slashes and backslashes in a grid using a Union-Find data structure. The algorithm effectively handles the boundary cases and correctly identifies when a new region is formed, providing an optimal solution in both time and space complexity for this problem.
public class regions_cut_by_slashed {
    class DisjointSet {
        List<Integer> parent = new ArrayList<>();
        List<Integer> size = new ArrayList<>();
        int count;

        public DisjointSet(int n) {
            for (int i = 0; i < n; i++) {
                parent.add(i);
                size.add(1);
            }
            count=1;
        }

        public int find_parent(int node) {
            if (node == parent.get(node)) return node;
            int root = find_parent(parent.get(node));
            parent.set(node, root);
            return root;
        }

        public void unionBySize(int u, int v) {
            int rootU = find_parent(u);
            int rootV = find_parent(v);

            if (rootU == rootV) {
                // Increment count if both nodes are already in the same set
                count++;
                return;
            }

            if (size.get(rootU) < size.get(rootV)) {
                parent.set(rootU, rootV);
                size.set(rootV, size.get(rootV) + size.get(rootU));
            } else {
                parent.set(rootV, rootU);
                size.set(rootU, size.get(rootU) + size.get(rootV));
            }
        }
    }

    class Solution {
        public int regionsBySlashes(String[] grid) {
            int n = grid.length;
            int N = n + 1;
            DisjointSet ds = new DisjointSet(N * N);


            for(int i=0;i<n+1;i++){
                for(int j=0;j<n+1;j++){
                    if(i==0||j==0||i==n||j==n){
                        int col = (n+1)*i+j;
                        if(col!=0)
                            ds.unionBySize(0,col);
                    }
                }
            }

            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    if(grid[i].charAt(j)=='/'){
                        int p1 = (i+1)*(n+1) + j;
                        int p2 = i*(n+1) + j+1;
                        ds.unionBySize(p1,p2);

                    }
                    else if(grid[i].charAt(j)=='\\'){
                        int p1 = i*(n+1) + j;
                        int p2 = (i+1)*(n+1) + j+1;
                        ds.unionBySize(p1,p2);
                    }
                }
            }

            return ds.count;
        }
    }

}
