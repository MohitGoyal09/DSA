public class len_of_loop {
    public static void main(String[] args) {

    }
}
 class Solution6
{
    public static int lengthOfLoop(Node head) {
        // Write your code here
        Node fast = head , slow = head;
        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if (fast == slow){
                slow = head;
                while (slow != fast){
                    slow = slow.next;
                    fast = fast.next;
                }
                int count = 1;
                slow = slow.next;
                while (slow != fast){
                    slow = slow.next;
                    count++;
                }
                return count;
            }

        }
        return 0;
    }
}