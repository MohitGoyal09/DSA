public class adding_1 {
    public static void main(String[] args) {
    }
}
// ! Iterative Approach
// ! Time Complexity : O(3N)
class Solution {
    public static Node addOne(Node head) {
        // Write your code here.
        head = reverse(head);
        Node temp = head;
        int carry = 1;
        while (temp != null){
            temp.data = temp.data + carry;
            if (temp.data < 10){
                carry = 0;
                break;
            }
            else {
                temp.data = 0;
                carry = 1;
            }
            temp = temp.next;
        }
        if (carry == 1){
            Node newnode = new Node(1);
            head = reverse(head);
            newnode.next = head;
            return newnode;
        }
        head = reverse(head);
        return head;
    }
    public static Node reverse(Node head){
        if (head == null || head.next == null) return head;
        Node newhead = reverse(head.next);
        Node front = head.next;
        front.next = head;
        head.next = null;
        return newhead;
    }
}

// ! Recurssive Approach - Using BackTracking
class Solution4 {
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