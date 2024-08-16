public class reverse {
    class Node{
        int data;
        Node next;
        Node(int data1){
            this.data = data1;
            this.next = null;
        }
        Node(int data1, Node next1){
            this.data = data1;
            this.next = next1;
        }
    }
    public static Node reverse(Node head){
        Node prev = null;
        Node front = null;
        while (head != null){
            head = head.next;
            head.next = prev;
            prev = head;
            head = front;
        }
        return prev;
    }
    // Function to reverse a singly
    // linked list using a recursion
    public static Node reverseLinkedList(Node head) {
        // Base case:
        // If the linked list is empty or has only one node,
        // return the head as it is already reversed.
        if (head == null || head.next == null) {
            return head;
        }

        // Recursive step:
        // Reverse the linked list starting
        // from the second node (head.next).
        Node newHead = reverseLinkedList(head.next);

        // Save a reference to the node following
        // the current 'head' node.
        Node front = head.next;

        // Make the 'front' node point to the current
        // 'head' node in the reversed order.
        front.next = head;

        // Break the link from the current 'head' node
        // to the 'front' node to avoid cycles.
        head.next = null;

        // Return the 'newHead,' which is the new
        // head of the reversed linked list.
        return newHead;
    }
}
