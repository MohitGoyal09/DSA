import java.util.ArrayList;
import java.util.List;

public class inorder {
    public static void main(String[] args) {
     // ! LEFT --> ROOT --> RIGHT
    }

    private static void inorder(Node root, List<Integer> arr) {
        // If the current node is NULL
        // (base case for recursion), return
        if (root == null) return;
        // Recursively traverse
        // the left subtree
        inorder(root.left, arr);
        // Push the current node's
        // value into the list
        arr.add(root.data);
        // Recursively traverse
        // the right subtree
        inorder(root.right, arr);
    }

    // Function to initiate inorder traversal
    // and return the resulting list
    static List<Integer> inOrder(Node root) {
        // Create an empty list to
        // store inorder traversal values
        List<Integer> arr = new ArrayList<>();
        // Call the inorder traversal function
        inorder(root, arr);
        // Return the resulting list
        // containing inorder traversal values
        return arr;
    }
}
