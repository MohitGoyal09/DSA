public class remove_nth_node_from_last {
    public static void main(String[] args) {

    }
//    class Solution {
//        public ListNode removeNthFromEnd(ListNode head, int n) {
//            int cnt = 0;
//            ListNode temp = head;
//            while ( temp != null){
//                cnt++;
//                temp = temp.next;
//            }
//            if (cnt == n){
//                ListNode newhead = head.next;
//                head = null;
//                return newhead;
//            }
//            int res = cnt-n;
//            temp = head;
//            while (temp != null){
//                res--;
//                if (res == 0) break;
//                temp = temp.next;
//            }
//            ListNode deleteNode = temp.next;
//            temp.next = temp.next.next;
//            deleteNode = null;
//            return head;
//        }
//    }
    // ! Better Approach
//public ListNode removeNthFromEnd(ListNode head, int n) {
//    ListNode fast = head;
//    ListNode slow = head;
//    for (int i = 0 ; i < n ; i++) fast = fast.next;
//    if (fast == null) return head.next;
//    while (fast.next != null){
//        fast = fast.next;
//        slow = slow.next;
//    }
//    ListNode delNode = slow.next;
//    slow.next = slow.next.next;
//    delNode = null;
//    return head;
//}
}
