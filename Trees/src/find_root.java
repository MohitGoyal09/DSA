import java.util.ArrayList;
import java.util.List;

public class find_root {
    public static void main(String[] args) {

    }
    public boolean getPath(TreeNode root, List<Integer> arr, int x) {
        // Base case: If the current
        // node is null, return false
        if (root == null) {
            return false;
        }

        // Add the current node's
        // value to the path list
        arr.add(root.val);

        // If the current node's value is equal
        // to the target value 'x', return true
        if (root.val == x) {
            return true;
        }

        // Recursively search for the target value
        // 'x' in the left and right subtrees
        if (getPath(root.left, arr, x) || getPath(root.right, arr, x)) {
            return true;
        }

        // If the target value 'x' is not found
        // in the current path, backtrack
        arr.remove(arr.size() - 1);
        return false;
    }

    // Function to find and return the path from
    // the root to a given node with value 'B'
    public List<Integer> solve(TreeNode A, int B) {
        // Initialize an empty
        // list to store the path
        List<Integer> arr = new ArrayList<>();

        // If the root node is null,
        // return the empty path list
        if (A == null) {
            return arr;
        }

        // Call the getPath function to find
        // the path to the node with value 'B'
        getPath(A, arr, B);

        // Return the path list
        return arr;
    }

}
