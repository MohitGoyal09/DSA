public class same_tree {
    public static void main(String[] args) {

    }
    // Function to check if two
    // binary trees are identical
    public boolean isIdentical(Node node1, Node node2) {
        // If both nodes are NULL,
        // they are identical
        if (node1 == null && node2 == null) {
            return true;
        }
        // If only one of the nodes is
        // NULL, they are not identical
        if (node1 == null || node2 == null) {
            return false;
        }
        // Check if the current nodes
        // have the same data value
        // and recursively check their
        // left and right subtrees
        return ((node1.data == node2.data)
                && isIdentical(node1.left, node2.left)
                && isIdentical(node1.right, node2.right));
    }
}
