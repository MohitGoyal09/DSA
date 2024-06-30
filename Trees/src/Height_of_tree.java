import java.util.LinkedList;
import java.util.Queue;

public class Height_of_tree {
    public static void main(String[] args) {

    }
    public int maxdepth(TreeNode root){
        if (root == null) return 0;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int height = 0;
        while (!q.isEmpty()){
            int size = q.size();
            for (int i = 0 ; i <size ; i++){
                TreeNode node = q.poll();
                if (node.left != null) q.add(node.left);
                if(node.right != null) q.add(node.right);
            }
            height++;
        }
        return height;
    }
}

