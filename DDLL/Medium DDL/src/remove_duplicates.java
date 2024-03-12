public class remove_duplicates {
    public static void main(String[] args) {

    }

}

 class Solution6 {
    public static Node uniqueSortedList(Node head) {
        // Write your code here.
        Node temp = head;
        while (temp != null && temp.next != null){
            Node nextnode = temp.next;
            while (nextnode != null && nextnode.data == temp.data) nextnode = nextnode.next;
            temp.next = nextnode;
            if ( nextnode != null) nextnode.back = temp;
            temp = temp.next;
        }
        return head;
    }
}