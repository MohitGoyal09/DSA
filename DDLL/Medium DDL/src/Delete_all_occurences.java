public class Delete_all_occurences {
    public static void main(String[] args) {

    }
    static Node delete(Node head, int key){
        Node temp = head;
        while (temp != null){
            if (temp.data == key ){
                if (temp == head) head = temp.next;
                Node newnode = temp.next;
                Node prevnode = temp.back;
                if (newnode != null) newnode.back = prevnode;
                if (prevnode != null) prevnode.next = newnode;
                temp = newnode;
            }
            else temp = temp.next;
        }
        return head;
    }
}
