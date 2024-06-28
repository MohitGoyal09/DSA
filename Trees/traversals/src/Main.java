import java.util.*;

public class Main {
    public static void main(String[] args) {
      // ! ROOT --> LEFT --> RIGHT
    }
    // Function to initiate preorder traversal
    // and return the resulting list
    static List<Integer> preOrder(Node root) {
        // Create an empty list to
        // store preorder traversal values
        List<Integer> arr = new ArrayList<>();
        // Call the preorder traversal function
        preorder(root, arr);
        // Return the resulting list
        // containing preorder traversal values
        return arr;
    }

    private static void preorder(Node root, List<Integer> arr) {
        // If the current node is NULL
        // (base case for recursion), return
        if (root == null) return;
        // Push the current node's
        // value into the list
        arr.add(root.data);
        // Recursively traverse
        // the left subtree
        preorder(root.left, arr);
        // Recursively traverse
        // the right subtree
        preorder(root.right, arr);
    }
}
class Node {
    int data;
    Node left;
    Node right;
    public Node(int key){
        data = key;
        left = null;
        right = null;
    }
}