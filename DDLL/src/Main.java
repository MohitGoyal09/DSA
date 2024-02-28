
public class Main {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        Node head = arrayto2ll(arr);
        head = kthelement(head, 3); // read
        printLL(head);
    }
    public static Node arrayto2ll(int[] arr){
        Node head = new Node(arr[0]);
        Node prev = head;
        for (int i = 1 ; i < arr.length;i++){
            Node temp = new Node(arr[i],null,prev);
            prev.next = temp;
            prev = temp;
        }
        return head;
    }
    public static void printLL(Node head) {
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
    }
    public static Node deleteHead(Node head){
        if (head == null || head.next == null) return null;
        Node prev = head;
        head = head.next;
        head.back = null;
        prev.back = null;
        return head;
    }
    public static Node deleteTail(Node head){
        if (head == null || head.next == null) return null;
        Node tail = head;
        while (tail.next != null) tail = tail.next;
        Node newtail = tail.back;
        newtail.next = null;
        tail.back = null;
        return head;
    }

    public static Node kthelement(Node head, int k){
        if (head == null ) return null;
        int cnt = 0;
        Node kthnode = head;
        while (kthnode != null){
            cnt++;
            if (cnt == k) break;
            kthnode = kthnode.next;
        }
        Node prev = kthnode.back;
        Node front = kthnode.next;
        if (prev == null && front == null) {
            return null;
        } else if (prev == null) {
            return deleteHead(head);
        } else if (front == null) {
            return deleteTail(head);
        }
        prev.next = front;
        front.back = prev;
        kthnode.next = null;
        kthnode.back = null;
        return head;
    }
}
