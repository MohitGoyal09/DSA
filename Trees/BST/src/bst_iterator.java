import java.util.Stack;

public class bst_iterator {
    class BSTIterator {
        private Stack<TreeNode> st = new Stack<TreeNode>();
        public BSTIterator(TreeNode root) {
            pushAll(root);
        }

        public int next() {
            TreeNode temp = st.pop();
            pushAll(temp.right);
            return temp.val;
        }

        public boolean hasNext() {
            return !st.isEmpty();
        }
        private void pushAll(TreeNode root){
            for ( ; root != null ; st.push(root) , root = root.left);
        }
    }
}
