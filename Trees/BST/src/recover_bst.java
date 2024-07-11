public class recover_bst {
    class Solution {
        private TreeNode first;
        private TreeNode prev;
        private TreeNode middle;
        private TreeNode last;
        public void recoverTree(TreeNode root) {
            first = middle = last = null;
            prev = new TreeNode(Integer.MIN_VALUE);
            inorder(root);
            if (first != null && last !=null){
                int t = first.val;
                first.val = last.val;
                last.val = t;
            } else if (first != null && middle != null){
                int t = first.val;
                first.val = middle.val;
                middle.val = t;
            }

        }
        public void inorder(TreeNode root){
            if (root == null) return ;
            inorder(root.left);
            if (prev != null && root.val < prev.val){
                if (first == null){
                    first = prev;
                    middle = root;
                }else last = root;
            }
            prev = root;
            inorder(root.right);
        }
    }
}
