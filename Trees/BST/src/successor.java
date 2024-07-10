public class successor {
    public TreeNode inorderSuccessor(TreeNode root,TreeNode x)
    {
        //add code here.
        TreeNode success = null;
        while (root != null){
            if (x.val >= root.val ) root = root.right;
            else {
                success = root;
                root = root.left;
            }
        }
        return success;
    }
    public TreeNode inorderpressor(TreeNode root,TreeNode x)
    {
        //add code here.
        TreeNode pre = null;
        while (root != null){
            if (x.val >= root.val ) root = root.left;
            else {
                pre = root;
                root = root.right;
            }
        }
        return pre;
    }
}

