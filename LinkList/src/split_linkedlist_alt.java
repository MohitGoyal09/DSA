import java.util.*;
public class split_linkedlist_alt {
    Node[] alternatingSplitList(Node head) {
        // code here
        Node h1 = head;
        Node temp = head;
        Node[] ans = new Node[2];
        if (head.next == null){
            ans[0] = head;
            return ans;
        }
        Node h2 = head.next;
        ans[0] = h1;
        ans[1] = h2;
        while (h1.next != null && h1.next.next != null){
            h1.next = h1.next.next;
            h2.next = h2.next.next;
            h1 = h1.next;
            h2 = h2.next;
        }
        h1.next = null;
        return ans;
    }
}
