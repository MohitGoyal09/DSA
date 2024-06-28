import java.util.ArrayList;
import java.util.List;

public class postorder {
    public static void main(String[] args) {
        // ! LEFT --> RIGHT --> ROOT
    }
    // Function to perform postorder
    // traversal recursively
    static void postorder(Node root, List<Integer> arr){
        // Base case: if root is null, return
        if(root == null){
            return;
        }
        // Traverse left subtree
        postorder(root.left, arr);
        // Traverse right subtree
        postorder(root.right, arr);
        // Visit the node
        // (append node's data to the array)
        arr.add(root.data);
    }

    // Function to get the postorder
    // traversal of a binary tree
    static List<Integer> postOrder(Node root){
        // Create a list to
        // store the traversal result
        List<Integer> arr = new ArrayList<>();
        // Perform postorder traversal
        // starting from the root
        postorder(root, arr);
        // Return the postorder
        // traversal result
        return arr;
    }
}
