public class sort_LL {
    public static void main(String[] args) {

    }
    static Node sort(Node head){
        if (head == null || head.next == null) return null;
        Node middle = middleNode(head);
        Node lefthead = head;
        Node righthead = middle.next;
        middle.next = null;
        lefthead = sort(lefthead);
        righthead = sort(righthead);
        return merge(lefthead , righthead);
    }

    static Node  middleNode(Node head){
        Node slow = head;
        Node fast = head.next;
        while (fast != null && fast.next != null && fast.next.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
    static Node merge(Node list1 , Node list2){
        Node dummyNode = new Node(-1);
        Node temp = dummyNode;
        while (list1 != null && list2 != null){
            if (list1.data < list2.data){
                temp.next = list1;
                temp = list1;
                list1 = list1.next;
            } else {
                temp.next = list2;
                temp = list2;
                list2 = list2.next;
            }
           if (list1 != null) temp.next = list1;
           else temp.next = list2;
        }
        return dummyNode.next;
    }
}

//public class Solution {
//
//    public ListNode sortList(ListNode head) {
//        if (head == null || head.next == null)
//            return head;
//
//        // step 1. cut the list to two halves
//        ListNode prev = null, slow = head, fast = head;
//
//        while (fast != null && fast.next != null) {
//            prev = slow;
//            slow = slow.next;
//            fast = fast.next.next;
//        }
//
//        prev.next = null;
//
//        // step 2. sort each half
//        ListNode l1 = sortList(head);
//        ListNode l2 = sortList(slow);
//
//        // step 3. merge l1 and l2
//        return merge(l1, l2);
//    }
//
//    ListNode merge(ListNode l1, ListNode l2) {
//        ListNode l = new ListNode(0), p = l;
//
//        while (l1 != null && l2 != null) {
//            if (l1.val < l2.val) {
//                p.next = l1;
//                l1 = l1.next;
//            } else {
//                p.next = l2;
//                l2 = l2.next;
//            }
//            p = p.next;
//        }
//
//        if (l1 != null)
//            p.next = l1;
//
//        if (l2 != null)
//            p.next = l2;
//
//        return l.next;
//    }
//
//}