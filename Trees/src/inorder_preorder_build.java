import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

public class inorder_preorder_build {

    // Function to build a binary tree
    // from preorder and inorder traversals
    public TreeNode buildTree(Vector<Integer> preorder, Vector<Integer> inorder) {
        // Create a map to store indices
        // of elements in the inorder traversal
        Map<Integer, Integer> inMap = new HashMap<>();

        // Populate the map with indices
        // of elements in the inorder traversal
        for (int i = 0; i < inorder.size(); i++) {
            inMap.put(inorder.get(i), i);
        }

        // Call the private helper function
        // to recursively build the tree
        TreeNode root = buildTree(preorder, 0, preorder.size() - 1, inorder, 0, inorder.size() - 1, inMap);

        return root;
    }

    // Recursive helper function to build the tree
    private TreeNode buildTree(Vector<Integer> preorder, int preStart, int preEnd,
                               Vector<Integer> inorder, int inStart, int inEnd, Map<Integer, Integer> inMap) {
        // Base case: If the start indices
        // exceed the end indices, return null
        if (preStart > preEnd || inStart > inEnd) {
            return null;
        }

        // Create a new TreeNode with value
        // at the current preorder index
        TreeNode root = new TreeNode(preorder.get(preStart));

        // Find the index of the current root
        // value in the inorder traversal
        int inRoot = inMap.get(root.val);

        // Calculate the number of
        // elements in the left subtree
        int numsLeft = inRoot - inStart;

        // Recursively build the left subtree
        root.left = buildTree(preorder, preStart + 1, preStart + numsLeft,
                inorder, inStart, inRoot - 1, inMap);

        // Recursively build the right subtree
        root.right = buildTree(preorder, preStart + numsLeft + 1, preEnd,
                inorder, inRoot + 1, inEnd, inMap);

        // Return the current root node
        return root;
    }

    // Function to print the
    // inorder traversal of a tree
    private void printInorder(TreeNode root) {
        if (root != null) {
            printInorder(root.left);
            System.out.print(root.val + " ");
            printInorder(root.right);
        }
    }

    // Function to print the
    // given vector
    private void printVector(Vector<Integer> vec) {
        for (int i = 0; i < vec.size(); i++) {
            System.out.print(vec.get(i) + " ");
        }
        System.out.println();
    }

}
