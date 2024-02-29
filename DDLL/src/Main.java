
public class Main {
    public static void main(String[] args) {
        int[] arr = {12, 5, 6, 8, 4};
        Node head = convertArr2DLL(arr); // Convert the array to a doubly linked list
        print(head); // Print the doubly linked list

        System.out.println("Doubly Linked List after deleting node with value '5': ");
        deleteNode(head.next);
        print(head);
    }
    public static Node convertArr2DLL(int[] arr){
        Node head = new Node(arr[0]);
        Node prev = head;
        for (int i = 1 ; i < arr.length;i++){
            Node temp = new Node(arr[i],null,prev);
            prev.next = temp;

            prev = temp;
        }
        return head;
    }
    public static void print(Node head) {
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
    public static void deleteNode(Node temp){
        Node prev = temp.back;
        Node front = temp.next;
        if (front == null){
            temp.back = null;
            prev.next = null;
            return;
        }
        prev.next = front;
        front.back = prev;

        temp.back = null;
        temp.next = null;
        return;
    }
}
