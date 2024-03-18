import java.util.Comparator;
import java.util.PriorityQueue;

public class merge_k_sort_ll {
    public static void main(String[] args) {

    }

}
//class Solution {
//    public ListNode mergeKLists(ListNode[] lists) {
//        if (lists.length == 0) return null;
//        ListNode head = lists[0];
//        for (int i = 1 ; i < lists.length ; i++){
//            head = merge(head , lists[i]);
//        }
//        return head;
//    }
//    private ListNode merge(ListNode l1, ListNode l2) {
//        ListNode dummy = new ListNode(0);
//        ListNode curr = dummy;
//
//        while (l1 != null && l2 != null) {
//            if (l1.val < l2.val) {
//                curr.next = l1;
//                l1 = l1.next;
//            } else {
//                curr.next = l2;
//                l2 = l2.next;
//            }
//            curr = curr.next;
//        }
//
//        curr.next = (l1 != null) ? l1 : l2;
//
//        return dummy.next;
//    }
//}


// Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0) return null;

        // Custom comparator to compare the ListNode objects based on their values
        PriorityQueue<ListNode> pq = new PriorityQueue<>(lists.length, new Comparator<ListNode>() {
            public int compare(ListNode l1, ListNode l2) {
                return l1.val - l2.val;
            }
        });

        // Adding the first node of each list to the priority queue
        for(ListNode list : lists) {
            if(list != null) {
                pq.add(list);
            }
        }

        ListNode dummyNode = new ListNode(-1);
        ListNode temp = dummyNode;

        while(!pq.isEmpty()) {
            ListNode node = pq.poll();
            temp.next = node;
            temp = temp.next;

            if(node.next != null) {
                pq.add(node.next);
            }
        }

        return dummyNode.next;
    }
}
