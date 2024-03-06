import java.util.ArrayList;
import java.util.Arrays;

public class merge_sort {
    public static void main(String[] args) {

    }
    // ! Recursive Approach
    public static Node merge(Node head1, Node head2) {
        if (head1 == null) return head2;
        if (head2 == null) return head1;
        if (head1.data < head2.data) {
            head1.next = merge(head1.next, head2);
            return head1;
        } else {
            head2.next = merge(head1, head2.next);
            return head2;
        }
    }
    public static Node burutte(Node head1 , Node head2){
        ArrayList<Integer> list = new ArrayList<>();
        Node temp1 = head1;
        Node temp2 = head2;
        while (temp1 != null){
            list.add(temp1.data);
            temp1 = temp1.next;
        }
        while (temp2 != null){
            list.add(temp2.data);
            temp2 = temp2.next;
        }
        list.sort(Integer::compareTo);
        Node head = new Node(0);
        Node temp = head;
        for (int i = 0; i < list.size(); i++) {
            temp.next = new Node(list.get(i));
            temp = temp.next;
        }
        return head.next;
    }
    public static Node optimal(Node head1, Node head2){
        Node t1 = head1 , t2 = head2;
        Node dummy = new Node(-1);
        Node temp = dummy;
        while (t1 != null && t2 != null){
            if (t1.data < t2.data){
                dummy.next = t1;
                temp = t1;
                t1 = t1.next;
            } else {
                dummy.next = t2;
                temp = t2;
                t2 = t2.next;
            }

        }
        if (t1 != null) temp.next = t1;
        else temp.next = t2;
        return dummy.next;
    }
}
