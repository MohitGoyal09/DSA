import com.sun.source.tree.Tree;

import java.util.*;


public class levelorder {
    public static void main(String[] args) {

    }

    public static List<List<Integer>> levelorder(TreeNode root){
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) return ans;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()){
            int size = q.size();
            List<Integer> level = new ArrayList<>();
            for (int i = 0 ; i < size ; i++){
                TreeNode curr = q.remove();
                level.add(curr.val);
                if (curr.left !=null ) q.add(curr.left);
                if (curr.right != null) q.add(curr.right);
            }
            ans.add(level);
        }
        return ans;
    }
}
class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int val){
        this.val = val;
        this.left = null;
        this.right = null;
    }
    TreeNode(){
       this.val = 0;
       this.left = null;
       this.right = null;
    }
    TreeNode(int val, TreeNode left, TreeNode right){
        this.val = val;
        this.left = left;
        this.right = right;
    }
}