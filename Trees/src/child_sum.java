public class child_sum {
    public static void main(String[] args) {

    }
    int isSumProperty(Node node)
    {
         int[] arr = new int[20];
         int n = arr.length;
        /* left_data is left child data and right_data is
           for right child data*/
        int left_data = 0, right_data = 0;

        /* If node is NULL or it's a leaf node then
        return true */
        if (node == null || (node.left == null && node.right == null)) return 1;
        else {

            /* If left child is not present then 0 is used
               as data of left child */
            if (node.left != null) left_data = node.left.data;

            /* If right child is not present then 0 is used
               as data of right child */
            if (node.right != null) right_data = node.right.data;

            /* if the node and both of its children satisfy
               the property return 1 else 0*/
            if ((node.data == left_data + right_data) && (isSumProperty(node.left) != 0)
                    && isSumProperty(node.right) != 0)
                return 1;
            else return 0;
        }
    }
    public void changeTree(TreeNode root) {
        // Base case: If the current node
        // is null, return and do nothing.
        if (root == null) return;


        // Calculate the sum of the values of
        // the left and right children, if they exist.
        int child = 0;
        if (root.left != null) {
            child += root.left.val;
        }
        if (root.right != null) {
            child += root.right.val;
        }

        // Compare the sum of children with
        // the current node's value and update
        if (child >= root.val) {
            root.val = child;
        } else {
            // If the sum is smaller, update the
            // child with the current node's value.
            if (root.left != null) {
                root.left.val = root.val;
            } else if (root.right != null) {
                root.right.val = root.val;
            }
        }

        // Recursively call the function
        // on the left and right children.
        changeTree(root.left);
        changeTree(root.right);

        // Calculate the total sum of the
        // values of the left and right
        // children, if they exist.
        int tot = 0;
        if (root.left != null) {
            tot += root.left.val;
        }
        if (root.right != null) {
            tot += root.right.val;
        }

        // If either left or right child
        // exists, update the current node's
        // value with the total sum.
        if (root.left != null || root.right != null) {
            root.val = tot;
        }
    }
}
