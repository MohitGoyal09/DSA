import java.util.Stack;

public class reverse_ll {
    public static void printLinkedList(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }
    public static void main(String[] args) {
        // Create a linked list with values 1, 3, 2, and 4
        Node head = new Node(1);
        head.next = new Node(3);
        head.next.next = new Node(2);
        head.next.next.next = new Node(4);

        // Print the original linked list
        System.out.print("Original Linked List: ");
        printLinkedList(head);

        // Reverse the linked list
        head = reverse(head);

        // Print the reversed linked list
        System.out.print("Reversed Linked List: ");
        printLinkedList(head);
    }
    public static Node burttue(Node head){
        Node temp = head;
        Stack<Integer> stk = new Stack<>();
        while (temp != null){
            stk.push(temp.data);
            temp = temp.next;
        }
        temp = head;
        while (temp != null){
            temp.data = stk.pop();
            temp = temp.next;
        }
        return head;
    }
    // ! Iterative approach
    public static Node optimal(Node head){
        Node temp = head;
        Node prev = null;
        while (temp != null){
            Node front = temp.next;
            temp.next = prev;
            prev = temp;
            temp = front;
        }
        return head;
    }
    // ! Recursive Approach
    public static Node reverse(Node head){
        if (head == null || head.next == null) return head;
        Node nextHead = reverse(head.next);
        Node front = head.next;
        front.next = head;
        head.next = null;
        return nextHead;
    }
}
