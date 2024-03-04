public class sort_0_1_2 {
    public static void main(String[] args) {

        int[] arr = {0, 1, 1, 0, 1, 2, 1, 2, 0, 0, 0, 1};
        Node head = Main.convertArr2DLL(arr);
        head = better(head);
        print(head);
    }
    // ! Naive Approach
    // ! Time Complexity : O(2N)
    // ! Soace Complexity : O(1)
    public static Node brutte(Node head){
       int cnt0 = 0;
       int cnt1 = 0;
       int cnt2 = 0;
       Node temp = head;
       while (temp != null){
           if (temp.data == 0) cnt0++;
           else if (temp.data == 1) cnt1++;
           else cnt2++;
           temp = temp.next;
       }
       temp = head;
       while (temp != null){
           if (cnt0 > 0){
               temp.data = 0;
               cnt0--;
           }
           else if (cnt1 > 0){
               temp.data = 1;
               cnt1--;
           }
           else{
               temp.data = 2;
               cnt2--;
           }
           temp = temp.next;
       }

       return head;
    }

    // ! Better Approach
    // ! Time Complexity : O(N)
    // ! Soace Complexity : O(1)
    public static Node better(Node head){
        if (head == null || head.next == null) return head;
        Node zero = new Node(-1);
        Node one = new Node(-1);
        Node two = new Node(-1);
        Node zerohead = zero;
        Node onehead = one;
        Node twohead = two;
        Node temp = head;
        while (temp != null){
            if (temp.data == 0){
                zero.next = temp;
                zero = temp;
            }
            else if (temp.data == 1){
                one.next = temp;
                one = temp;
            }
            else {
                two.next = temp;
                two = temp;
            }
            temp = temp.next;
        }
        zero.next = (onehead.next != null) ? onehead.next : twohead.next;
        one.next = twohead.next;
        two.next = null;
        return zerohead.next;
    }
    private static void print(Node head) {
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
    }
}
