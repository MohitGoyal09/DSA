public class add_1_linked_list {
    public static Node addOne(Node head) {
        // Write your code here.
        int carry = helper(head);
        if (carry == 1){
            Node newhead = new Node(1);
            newhead.next = head;
            head = newhead;
        }
        return head;
    }
    public static int helper(Node temp){
        if (temp == null) return 1;
        int carry = helper(temp.next);
        temp.data += carry;
        if ( temp.data < 10) return 0;
        temp.data = 0;
        return 1;
    }
}
