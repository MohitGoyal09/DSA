import java.util.Stack;

public class two_sum_bst {
    public static void main(String[] args) {

    }
    class BSTiterator{
        private Stack<TreeNode> st= new Stack<TreeNode>();
        private boolean isreverse = true;
        public BSTiterator(TreeNode root , boolean reverse){
            isreverse = reverse;
            pushAll(root);
        }
        private void pushAll(TreeNode node){
            while (node != null){
                st.push(node);
                if (isreverse) node = node.right;
                else node = node.left;
            }
        }
        public boolean hasNext(){
            return !st.isEmpty();
        }
        public int next(){
            TreeNode temp = st.pop();
            pushAll(isreverse ? temp.left : temp.right);
            return temp.val;
        }
    }
    public boolean findTarget(TreeNode root, int k) {
        if (root == null) return false;
        BSTiterator l = new BSTiterator(root , false);
        BSTiterator r = new BSTiterator(root , true);
        int i = l.next();
        int j = r.next();
        while (i < j){
            if ( i + j == k) return true;
            if ( i + j < k ) i = l.next();
            else j = r.next();
        }
        return false;
    }
}
