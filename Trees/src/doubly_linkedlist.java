public class doubly_linkedlist {

}
class LLNode {
    int val;
    LLNode prev;
    LLNode next;
    public LLNode(int val){
        val = this.val;
        prev = null;
        next = null;
    }
}
 class d {
    LLNode head;
    LLNode tail;
    public LLNode convrt(TreeNode root){
        if (root == null) return null;
        helper(root);
        return head;
    }

    private void helper(TreeNode node) {
        if (node == null) return;
        helper(node.left);
        if (head == null){
            head = new LLNode(node.val);
            tail = head;
        } else {
            tail.next = new LLNode(node.val);
            tail.next.prev = tail;
            tail = tail.next;
        }

        helper(node.right);
    }
}