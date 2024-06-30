import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class iterative_postorder_2_stack {
    public static void main(String[] args) {

    }
    public static List<Integer> postorder(TreeNode root){
        Stack<TreeNode> st1 = new Stack<>();
        Stack<TreeNode> st2 = new Stack<>();
       List<Integer> list = new ArrayList<>();
        if (root == null) return list;
        st1.push(root);
        while(!st1.isEmpty()){
            root = st1.pop();
            st2.push(root);
            if (root.left != null) st1.push(root.left);
            if (root.right != null) st1.push(root.right);
        }
        while (!st2.isEmpty()){
            list.add(st2.pop().val);
        }
        return list;
    }
}
