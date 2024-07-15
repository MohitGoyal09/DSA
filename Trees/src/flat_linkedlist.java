import java.util.Stack;

public class flat_linkedlist {
    public static void main(String[] args) {

    }
    // Initialize a global variable
    // 'prev' to keep track of the
    // previously processed node.
    TreeNode prev = null;

    // Function to flatten a binary tree
    // to a right next Linked List structure
    public void flatten(TreeNode root) {
        // Base case: If the current
        // node is null, return.
        if (root == null) {
            return;
        }

        // Recursive call to
        // flatten the right subtree
        flatten(root.right);

        // Recursive call to
        // flatten the left subtree
        flatten(root.left);

        // At this point, both left and right
        // subtrees are flattened, and 'prev'
        // is pointing to the rightmost node
        // in the flattened right subtree.

        // Set the right child of
        // the current node to 'prev'.
        root.right = prev;

        // Set the left child of the
        // current node to null.
        root.left = null;

        // Update 'prev' to the current
        // node for the next iteration.
        prev = root;
    }

    public void flatten2(TreeNode root) {
        // Base case: If the current
        // node is null, return.
        if (root == null) {
            return;
        }
        // Use a stack for
        // iterative traversal.
        Stack<TreeNode> st = new Stack<>();
        // Push the root node
        // onto the stack.
        st.push(root);

        // Continue the loop until
        // the stack is empty.
        while (!st.empty()) {
            // Get the top node from the stack.
            TreeNode cur = st.pop();

            if (cur.right != null) {
                // Push the right child
                // onto the stack.
                st.push(cur.right);
            }

            if (cur.left != null) {
                // Push the left child
                // onto the stack.
                st.push(cur.left);
            }

            if (!st.empty()) {
                // Connect the right child to
                // the next node in the stack.
                cur.right = st.peek();
            }

            // Set the left child to null to
            // form a right-oriented linked list.
            cur.left = null;
        }
    }

    // Function to flatten a binary tree
    // to a right next Linked List structure
    public void flatten3(TreeNode root) {
        // Initialize a pointer
        // 'curr' to the root of the tree
        TreeNode curr = root;

        // Iterate until 'curr'
        // becomes NULL
        while (curr != null) {
            // Check if the current
            // node has a left child
            if (curr.left != null) {
                // If yes, find the rightmost
                // node in the left subtree
                TreeNode pre = curr.left;
                while (pre.right != null) pre = pre.right;

                // Connect the rightmost node in
                // the left subtree to the current
                // node's right child
                pre.right = curr.right;

                // Move the entire left subtree to the
                // right child of the current node
                curr.right = curr.left;

                // Set the left child of
                // the current node to NULL
                curr.left = null;
            }
            // Move to the next node
            // on the right side
            curr = curr.right;
        }
    }
   }

