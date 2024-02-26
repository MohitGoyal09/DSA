public class delete {
    public static void main(String[] args) {

        // Create a linked list: 1 -> 2 -> 3
        int[] arr = {1, 2, 3};
        Node head = new Node(arr[0]);
        head.next = new Node(arr[1]);
        head.next.next = new Node(arr[2]);
        head = deletetail(head);
        // Print the modified linked list
        printLL(head);
    }

    static Node deletehead(Node head){
        if (head == null) return head;
        head = head.next;
        return head;
    }
    static Node deletetail(Node head){
        if (head == null || head.next== null) return head;
        Node temp = head;
        while(temp.next.next != null){
            temp = temp.next;
        }
        temp.next = null;
        return head;
    }

    static Node delete_kth_node(Node head , int k){
        if (head == null) return head;
        if (k == 1){
            Node temp = head;
            head = head.next;
            temp = null;
            return head;
        }
        Node temp = head;
        Node prev = null;
        int cnt = 0;
        while (temp != null){
            cnt++;
            if (cnt == k){
                prev.next = temp.next.next;
                temp = null;
                break;
            }
            prev = temp;
            temp = temp.next;
        }
        return head;
    }
    private static void printLL(Node head) {
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
    }
}
