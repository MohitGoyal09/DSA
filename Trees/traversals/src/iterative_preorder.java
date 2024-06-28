import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class iterative_preorder {
    public static void main(String[] args) {

    }
    public static List<Integer> iterativePreorder(TreeNode root){
        List<Integer> preorder = new ArrayList<>();
        if (root == null) return preorder;
        Stack<TreeNode> st = new Stack<>();
        st.push(root);
        while (!st.isEmpty()){
            root = st.pop();
            preorder.add(root.val);
            if (root.right != null) st.push(root.right);
            if (root.left != null) st.push(root.left);
        }
      return preorder;
    }
}
