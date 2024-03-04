import java.util.Stack;

public class reverse {
    public static void main(String[] args) {
        int[] arr = {12, 5, 6, 8, 4};
        // Convert the array to a doubly linked list
        Node head = convertArr2DLL(arr);

        // Print the doubly linked list
        System.out.println("Doubly Linked List Before Reversing :");
        print(head);

        System.out.println("Doubly Linked List After Reversing :");

        head = optimal(head);
        print(head);
    }
    private static Node convertArr2DLL(int[] arr) {
        // Create the head node with the first element of the array
        Node head = new Node(arr[0]);
        // Initialize 'prev' to the head node
        Node prev = head;

        for (int i = 1; i < arr.length; i++) {
            // Create a new node with data from the array and set its 'back' pointer to the previous node
            Node temp = new Node(arr[i], null, prev);
            // Update the 'next' pointer of the previous node to point to the new node
            prev.next = temp;
            // Move 'prev' to the newly created node for the next iteration
            prev = temp;
        }
        // Return the head of the doubly linked list
        return head;
    }
    private static void print(Node head) {
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
    }
    // ! Time Complexity : O(2N)
    // ! Space Complexity : O(N)
    public static Node burutte(Node head){
        Stack<Integer> stk = new Stack<>();
        Node temp = head;
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
    public static Node optimal(Node head){
        if (head == null || head.next == null) return null;
        Node prev = null;
        Node current = head;
        while (current != null){
            prev = current.back;
            current.back = current.next;
            current.next = prev;
            current = current.back;
        }
        return prev.back;
    }
}
