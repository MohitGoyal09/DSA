
public class Main {
    public static void main(String[] args) {
    int[] arr = {12,3,4,5,6};
    Node head = arry2ll(arr);
//    Node temp = head;
//    while (temp != null){
//        System.out.print(temp.data);
//        temp = temp.next;
//    }
    System.out.println(lenofll(head));
    }

    private static Node arry2ll(int[] arr){
        Node head = new Node(arr[0]);
        Node mover = head;
        for (int i = 0 ; i < arr.length ; i++){
            Node temp = new Node(arr[i]);
            mover.next = temp;
            mover = temp;
        }
        return head;
    }
    private static int lenofll(Node head){
        int cnt = 0;
        Node temp = head;
        while(temp != null){
            temp = temp.next;
            cnt++;
        }
        return cnt;
    }
}
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

