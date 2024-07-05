import java.util.*;
public class inorder_postorder_build {

    public TreeNode buildTree(Vector<Integer> inorder, Vector<Integer> postorder) {
        if (inorder.size() != postorder.size()) {
            return null;
        }

        // Create a map to store the indices
        // of elements in the inorder traversal
        Map<Integer, Integer> hm = new HashMap<>();
        for (int i = 0; i < inorder.size(); i++) {
            hm.put(inorder.get(i), i);
        }

        // Call the recursive function
        // to build the binary tree
        return buildTreePostIn(inorder, 0, inorder.size() - 1, postorder, 0,
                postorder.size() - 1, hm);
    }

    public TreeNode buildTreePostIn(Vector<Integer> inorder, int is, int ie,
                                    Vector<Integer> postorder, int ps, int pe, Map<Integer, Integer> hm) {

        // Base case: If the subtree
        // is empty, return null
        if (ps > pe || is > ie) {
            return null;
        }

        // Create a new TreeNode
        // with the root value from postorder
        TreeNode root = new TreeNode(postorder.get(pe));

        // Find the index of the root
        // value in inorder traversal
        int inRoot = hm.get(postorder.get(pe));

        // Number of nodes in the left subtree
        int numsLeft = inRoot - is;

        // Recursively build the
        // left and right subtrees
        root.left = buildTreePostIn(inorder, is, inRoot - 1, postorder,
                ps, ps + numsLeft - 1, hm);

        root.right = buildTreePostIn(inorder, inRoot + 1, ie, postorder,
                ps + numsLeft, pe - 1, hm);

        // Return the root of
        // the constructed subtree
        return root;
    }
}

