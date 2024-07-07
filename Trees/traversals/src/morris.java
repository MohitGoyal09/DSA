import java.util.ArrayList;

public class morris {
    public static void main(String[] args) {

    }
    static ArrayList<Integer> inorder(TreeNode root) {
        ArrayList<Integer> ans = new ArrayList<>();
        TreeNode curr = root;
        while (curr != null){
            TreeNode prev = curr.left;
            if (prev == null){
                ans.add(prev.val);
                curr = curr.right;
            }else {
                while (prev.right != null && prev.right != curr){
                    prev = prev.right;
                }
                if (prev.right == null){
                    prev.right = curr;
                    curr = curr.left;
                } else {
                    prev.right = null;
                    ans.add(curr.val);
                    curr = curr.left;
                }
            }
        }
        return ans;
    }

    static ArrayList<Integer> preorder(TreeNode root) {
        ArrayList<Integer> ans = new ArrayList<>();
        TreeNode curr = root;
        while (curr != null){
            TreeNode prev = curr.left;
            if (prev == null){
                ans.add(prev.val);
                curr = curr.right;
            }else {
                while (prev.right != null && prev.right != curr){
                    prev = prev.right;
                }
                if (prev.right == null){
                    prev.right = curr;
                    curr = curr.left;
                } else {
                    prev.right = null;
                    ans.add(curr.val);
                    curr = curr.left;
                }
            }
        }
        return ans;
    }
}
