public class delete_middle_node {
    public static void main(String[] args) {

    }
    // ! Time Complxity : O(N + N/2)
    public static Node burutte(Node head){
        Node temp = head;
        int n = 0;
        if (head == null && head.next == null) return null;
        while (temp != null){
            n++;
            temp = temp.next;
        }
        int res = n/2;
        temp = head;
        while (temp != null){
            res--;
            if (res == 0){
                Node middle = temp.next;
                temp.next = temp.next.next;
                break;
            }
            temp = temp.next;
        }
        return head;
    }
    // ! Time Complexity : O(N)
    public Node deleteMiddle(Node head) {
        if(head == null) return null;
        if(head.next == null) return null;
        Node slow = head, fast = head.next;
        while(fast != null && fast.next != null && fast.next.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return head;

    }
}
