public class balanced_bst {
    public static void main(String[] args) {

    }
    public static int dfs(TreeNode root){
        // Base case: if the current node is NULL,
        // return 0 (height of an empty tree)
        if (root == null) return 0;

        // Recursively calculate the
        // height of the left subtree
        int leftHeight = dfs(root.left);

        // If the left subtree is unbalanced,
        // propagate the unbalance status
        if (leftHeight == -1)
            return -1;

        // Recursively calculate the
        // height of the right subtree
        int rightHeight = dfs(root.right);

        // If the right subtree is unbalanced,
        // propagate the unbalance status
        if (rightHeight == -1)
            return -1;

        // Check if the difference in height between
        // left and right subtrees is greater than 1
        // If it's greater, the tree is unbalanced,
        // return -1 to propagate the unbalance status
        if (Math.abs(leftHeight - rightHeight) > 1)
            return -1;

        // Return the maximum height of left and
        // right subtrees, adding 1 for the current node
        return Math.max(leftHeight, rightHeight) + 1;
    }
}
