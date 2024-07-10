public class kth_smallest_largest_node {
    public static void main(String[] args) {

    }
    public int[] kth(TreeNode root , int k ){
        int[] kthsmallest = new int[]{Integer.MIN_VALUE};
        int[] kthlargest = new int[]{Integer.MIN_VALUE};

        int[] counter = new int[]{0};
        inorder(root , kthsmallest , counter , k);
        counter[0] = 0;
        reverseinorder(root , kthlargest , counter  , k);
        return new int[]{kthsmallest[0] , kthlargest[0]};
    }

    private void reverseinorder(TreeNode node, int[] kthlargest, int[] counter, int k) {
        if (node == null || counter[0] >= k) return;

        // Traverse left subtree
        inorder(node.right,kthlargest ,counter, k );

        // Increment counter after visiting left subtree
        counter[0]++;

        // Check if current node is the Kth smallest
        if (counter[0] == k) {
            kthlargest[0] = node.val;
            return;
        }

        // Traverse right subtree if
        // Kth smallest is not found yet
        inorder(node.left, kthlargest,counter, k );
    }

    private void inorder(TreeNode node, int[] kSmallest, int[] counter , int k ) {
        if (node == null || counter[0] >= k) return;

        // Traverse left subtree
        inorder(node.left,kSmallest ,counter, k );

        // Increment counter after visiting left subtree
        counter[0]++;

        // Check if current node is the Kth smallest
        if (counter[0] == k) {
            kSmallest[0] = node.val;
            return;
        }

        // Traverse right subtree if
        // Kth smallest is not found yet
        inorder(node.right, kSmallest,counter, k );
    }
}
