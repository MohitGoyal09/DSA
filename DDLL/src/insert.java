public class insert {
    public static void main(String[] args) {
        int[] arr = {12, 5,  8, 4};
        // Convert the array to a doubly linked list
        Node head = convertArr2DLL(arr);
        // Print the doubly linked list
        print(head);

        System.out.println("Doubly Linked List After Inserting 6 before head: ");
        insertbeforeNode(head.next.next, 100);

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
            // Print the data in the current node
            System.out.print(head.data + " ");
            // Move to the next node
            head = head.next; // Move to the next node
        }
        System.out.println();
    }

    public static Node insertbeforeHead(Node head, int val){
        Node newhead = new Node(val , head , null);
        head.back = newhead;
        return newhead;
    }
    public static Node insertbeforeTail(Node head, int val){
        if (head.next == null) return insertbeforeHead(head, val);
        Node tail = head;
        while (tail.next != null) tail = tail.next;
        Node prev = tail.back;
        Node newnode = new Node(val , tail, prev);
        prev.next = newnode;
        tail.back = newnode;
        return head;
    }
    public static Node insetbeforethekthelement(Node head , int k , int val){
        if (k == 1) return insertbeforeHead(head , val);
        Node temp = head;
        int cnt = 0;
        while (temp != null){
            cnt++;
            if (cnt == k) break;
            temp = temp.next;
        }
        Node prev = temp.back;
        Node newnode = new Node(val , temp , prev);

        prev.next = newnode;
        temp.back = newnode;

        newnode.next = temp;
        newnode.back = prev;
        return head;
    }
    public static void insertbeforeNode(Node node , int val){
        Node prev = node.back;
        Node newnode = new Node(val , node , prev);
        prev.next = newnode;
        node.back = newnode;
    }
}
