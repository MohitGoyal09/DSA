import java.util.Arrays;
import java.util.List;

public class insert {
    public static void main(String[] args) {
        List<Integer> arr = Arrays.asList(12, 8, 5, 7);
        int val = 100;

        // Creating a linked list with initial elements from the array
        Node head = new Node(arr.get(0));
        head.next = new Node(arr.get(1));
        head.next.next = new Node(arr.get(2));
        head.next.next.next = new Node(arr.get(3));

        // Inserting a new node at the head of the linked list
        head = kth_inset(head, val,3);

        // Printing the linked list
        printLL(head);
    }
    public static void printLL(Node head) {
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
    }
    public static Node insertHead(Node head, int val) {
        Node temp = new Node(val,head);
        return temp;
    }
    public static Node insertTail(Node head , int val){
        if (head == null) return new Node(val);
        Node temp = head;
        while (temp.next != null) temp = temp.next;
        Node newNode = new Node(val);
        temp.next = newNode;
        return head;
    }
    public static Node kth_inset(Node head, int val , int k){
        if (head == null){
            if (k== 1) return new Node(val);
            else return head;
        }
        int cnt = 0;
        Node temp = head;
        while (temp != null){
            cnt++;
            if (cnt == k-1){
                Node newNode = new Node(val, temp.next);
                temp.next = newNode;
                break;
            }
            temp = temp.next;
        }
        return head;
    }
}
