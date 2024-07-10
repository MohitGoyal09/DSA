public class bst_form_preorder {
    public TreeNode bstFromPreorder(int[] preorder) {
        return bfs(preorder, Integer.MAX_VALUE , new int[]{0});
    }
    public TreeNode bfs(int[] A , int bound , int[] i){
        if (i[0] == A.length || A[i[0]] > bound) return null;
        TreeNode root = new TreeNode(A[i[0]++]);
        root.left = bfs(A , root.val , i);
        root.right = bfs(A , bound , i);
        return root;
    }
}
