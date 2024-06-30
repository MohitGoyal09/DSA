import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class iterative_inorder {
    public static void main(String[] args) {

    }
    static List<Integer> inorder(TreeNode root){
        List<Integer> inorder =  new ArrayList<>();
        Stack<TreeNode> st  = new Stack<TreeNode>();
        TreeNode node = root;
        while(true){
            if (node != null){
                st.push(node);
                node = node.left;
            } else {
                if(st.isEmpty()) break;
                node = st.pop();
                inorder.add(node.val);
                node = node.right;
            }
        }
        return inorder;
    }
}
