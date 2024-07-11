public class largest_bst {
    static class Data {
        int max, min, size;
        Data(int max, int min, int size) {
            this.max = max;
            this.min = min;
            this.size = size;
        }
    }
    class Node {
    int data;
    Node left, right;
     public Node(int d) {
         data = d;
         left = right = null;
     }
 }

    class Solution {
        static Data dfs(Node root) {
            if (root == null) {
                return new Data(Integer.MIN_VALUE, Integer.MAX_VALUE, 0);
            }

            Data leftSubtree = dfs(root.left);
            Data rightSubtree = dfs(root.right);

            // Check if the current node forms a BST with its subtrees
            if (root.data > leftSubtree.max && root.data < rightSubtree.min) {
                int curSize = leftSubtree.size + rightSubtree.size + 1;
                int maxval = Math.max(root.data, rightSubtree.max);
                int minval = Math.min(root.data, leftSubtree.min);
                return new Data(maxval, minval, curSize);
            }

            // If not a BST, return a sentinel value
            return new Data(Integer.MAX_VALUE, Integer.MIN_VALUE, Math.max(leftSubtree.size, rightSubtree.size));
        }

        static int largestBst(Node root) {
            Data ans = dfs(root);
            return ans.size;
        }
    }
}
