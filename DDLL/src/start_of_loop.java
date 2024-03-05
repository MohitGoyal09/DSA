import java.util.HashMap;

public class start_of_loop {
    public static void main(String[] args) {

    }

}
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
//public class Solution {
//    public ListNode detectCycle(ListNode head) {
//        ListNode slow = head , fast = head;
//        while (fast != null && fast.next != null){
//            slow = slow.next;
//            fast = fast.next.next;
//            if (slow == fast){
//                slow = head;
//                while ( slow != fast){
//                    slow = slow.next;
//                    fast = fast.next;
//                }
//                return slow;
//            }
//
//        }
//        return null;
//    }
//}