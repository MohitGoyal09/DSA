import java.util.*;
public class Delete_Nodes_And_Return_Forest {
    class Solution {
        public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
            HashSet<Integer> delete = new HashSet<>();
            ArrayList<TreeNode> list = new ArrayList<>();
            for (int i = 0; i < to_delete.length; i++) {
                delete.add(to_delete[i]);
            }
            helper(root, delete, list, true);
            return list;
        }

        public TreeNode helper(TreeNode root, HashSet<Integer> delete, ArrayList<TreeNode> list, boolean isRoot) {
            if (root == null) return null;

            boolean deleted = delete.contains(root.val);

            if (isRoot && !deleted) {
                list.add(root);
            }

            root.left = helper(root.left, delete, list, deleted);
            root.right = helper(root.right, delete, list, deleted);

            return deleted ? null : root;
        }
    }
}
