public class intersection_ll {
    public static void main(String[] args) {
        // creation of both lists
        Node head = null;
        head=insertNode(head,1);
        head=insertNode(head,3);
        head=insertNode(head,1);
        head=insertNode(head,2);
        head=insertNode(head,4);
        Node head1 = head;
        head = head.next.next.next;
        Node headSec = null;
        headSec=insertNode(headSec,3);
        Node head2 = headSec;
        headSec.next = head;
        //printing of the lists
        System.out.print("List1: "); printList(head1);
        System.out.print("List2: "); printList(head2);
        //checking if intersection is present
        Node answerNode = intersectionPresent(head1,head2);
        if(answerNode == null)
            System.out.println("No intersection\n");
        else
            System.out.println("The intersection point is "+answerNode.data);
    }
    //utility function to print linked list created
    static void printList(Node head) {
        while(head.next != null) {
            System.out.print(head.data+"->");
            head = head.next;
        }
        System.out.println(head.data);
    }
    //utility function to insert node at the end of the linked list
    static Node insertNode(Node head,int val) {
        Node newNode = new Node(val);

        if(head == null) {
            head = newNode;
            return head;
        }

        Node temp = head;
        while(temp.next != null) temp = temp.next;

        temp.next = newNode;
        return head;
    }

    static Node intersectionPresent(Node head1 , Node head2){
        while (head2 != null){
            Node temp = head1;
            while (temp != null){
                if (temp == head2) return head2;
                temp = temp.next;
            }
            head2 = head2.next;
        }
         return null;
    }
    static Node difflen(Node head1 , Node head2){
        int diff = diff(head1,head2);
        if (diff < 0) while (diff++ != 0) head2 = head2.next;
        else while (diff-- != 0) head1 = head1.next;
        while( head1 != null){
            if (head1 == head2) return head1;
            head1 = head1.next;
            head2 = head2.next;
        }
         return head1;
    }

    static int diff(Node head1 , Node head2){
        int len1 = 0,len2 = 0;
        while(head1 != null || head2 != null) {
            if(head1 != null) {
                ++len1; head1 = head1.next;
            }
            if(head2 != null) {
                ++len2; head2 = head2.next;
            }

        }
        return len1-len2;
    }
}
