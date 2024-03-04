public class odd_even {
    public static void main(String[] args) {

    }

}

// ! Naive Approach
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
//class Solution {
//    public ListNode oddEvenList(ListNode head) {
//        ArrayList<Integer> arr = new ArrayList();
//        ListNode temp = head;
//        if (head == null || head.next == null) return head;
//        while (temp != null && temp.next != null){
//            arr.add(temp.val);
//            temp = temp.next.next;
//        }
//        if (temp != null) arr.add(temp.val);
//        temp = head.next;
//        while (temp != null && temp.next != null){
//            arr.add(temp.val);
//            temp = temp.next.next;
//        }
//        if (temp != null) arr.add(temp.val);
//        int i = 0;
//        temp = head;
//        while (temp != null){
//            temp.val = arr.get(i);
//            i++;
//            temp = temp.next;
//        }
//        return head;
//    }
//}
// ! Optimized Approach
//class Solution {
//    public ListNode oddEvenList(ListNode head) {
//
//        if(head==null||head.next==null){
//            return head;
//        }
//        ListNode odd=head;
//        ListNode even = head.next;
//        ListNode enHead = even;
//        while (even != null && even.next != null && odd!=null&&odd.next!=null) {
//            odd.next = even.next;
//            odd = odd.next;
//
//            even.next = odd.next;
//            even = even.next;
//        }
//
//
//        odd.next = enHead;
//
//        return head;
//    }
//}