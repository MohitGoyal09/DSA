
public class Main {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        Node head = arrayto2ll(arr);
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
}
