import java.util.HashMap;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Node head = null;

        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);

        head = node1;
        head.next = node2;
        head.next.next = node3;
        head.next.next.next = node4;

        head.random = node4;
        head.next.random = node1;
        head.next.next.random = null;
        head.next.next.next.random = node2;

        System.out.println("Original list:(current node:node pointed by next pointer, node pointed by random pointer)");
        printList(head);

        System.out.println("Copy list:(current node:node pointed by next pointer,node pointed by random pointer)");
        Node newHead = getcopy(head);
        printList(newHead);
    }
    // ! Timw Complexity : O(N) + O(N)
    // ! Space Complexity : O(N)
    static Node copy(Node head){
        HashMap<Node , Node> map = new HashMap<>();
        Node temp = head;
        // * first iteration for inserting deep nodes of every node in the hashmap
        while (temp != null){
            Node newNode = new Node(temp.val);
            map.put(temp , newNode);
            temp = temp.next;
        }
        Node t = head;
        // * second iteration for inserting next and random pointers
        while ( t != null){
            Node node = map.get(t);
            node.next = map.get(t.next);
            node.random = map.get(t.random);
            t = t.next;
        }
        return map.get(head);
    }
    static void printList(Node head) {
        while(head != null) {
            System.out.print(head.val+":");
            if(head.next != null)
                System.out.print(head.next.val);
            else
                System.out.print("NULL");
            if(head.random != null)
                System.out.print(","+head.random.val);
            else
                System.out.print(",NULL");
            System.out.println();
            head = head.next;
        }
    }

    static Node getcopy(Node head){
        Node temp = head;
        // step 1
        while (temp != null){
            Node newnode = new Node(temp.val);
            newnode.next = temp.next;
            temp.next = newnode;
            temp = temp.next.next;
        }
        // step 2
        Node itr = head;
        while (itr != null){
            if (itr.random != null) itr.next.random = itr.random.next;
            itr = itr.next.next;
        }
        // step 3
        Node dummy = new Node(0);
        itr = dummy;
        temp = head;
        if (temp != null){
            itr.next = temp.next;
            temp.next = temp.next.next;
            itr = itr.next;
            temp = temp.next;
        }
        return dummy.next;
    }
}