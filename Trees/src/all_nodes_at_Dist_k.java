import java.util.ArrayList;
import java.util.*;

public class all_nodes_at_Dist_k {
    public static List<Integer> distanceK(TreeNode root, int target, int k) {
        Map<TreeNode, TreeNode> parent = new HashMap<>();
        markParents(root, null, parent);

        Queue<TreeNode> queue = new LinkedList<>();
        Set<TreeNode> visited = new HashSet<>();
        TreeNode tgt = findNode(target , root);
        queue.offer(tgt);
        visited.add(tgt);

        int level = 0;
        while (!queue.isEmpty()) {
            if (level == k) break;
            int size = queue.size();
            level++;
            for (int i = 0; i < size; i++) {
                TreeNode current = queue.poll();
                if (current.left != null && !visited.contains(current.left)) {
                    queue.offer(current.left);
                    visited.add(current.left);
                }
                if (current.right != null && !visited.contains(current.right)) {
                    queue.offer(current.right);
                    visited.add(current.right);
                }
                TreeNode parentNode = parent.get(current);
                if (parentNode != null && !visited.contains(parentNode)) {
                    queue.offer(parentNode);
                    visited.add(parentNode);
                }
            }
        }

        List<Integer> result = new ArrayList<>();
        while (!queue.isEmpty()) {
            result.add(queue.poll().val);
        }
        Collections.sort(result);
        return result;
    }

    public static  void markParents(TreeNode root, TreeNode par, Map<TreeNode, TreeNode> parent) {
        if (root == null) return;
        parent.put(root, par);
        markParents(root.left, root, parent);
        markParents(root.right, root, parent);
    }
    static TreeNode findNode(int val , TreeNode root){
        if(root==null) return null;
        if(root.val == val) return root;
        TreeNode left = findNode(val , root.left);
        TreeNode right = findNode(val , root.right);
        if(left==null) return right;
        if(right == null) return left;
        return null;
    }
}

