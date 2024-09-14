public class split_linkedlist_parts {
    public class ListNode {
      int val;
      ListNode next;
    ListNode() {}ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
    class Solution {
        public ListNode[] splitListToParts(ListNode head, int k) {
            // Step 1: Calculate the length of the linked list
            int n = 0;
            ListNode curr = head;
            while (curr != null) {
                n++;  // Increment the length
                curr = curr.next;
            }

            // Step 2: Determine the base size and how many parts need an extra node
            int base = n / k;  // Minimum size of each part
            int extra = n % k;  // Number of parts that get an extra node

            // Step 3: Split the linked list
            ListNode[] res = new ListNode[k];
            curr = head;
            for (int i = 0; i < k; i++) {
                ListNode part_head = curr;  // This is the head of the current part
                int part_size = base + (extra > 0 ? 1 : 0);  // Add 1 extra node if needed
                extra--;  // Decrease extra after assigning the extra node

                // Now, advance the pointer `part_size - 1` steps to get to the end of the current part
                for (int j = 0; j < part_size - 1 && curr != null; j++) {
                    curr = curr.next;
                }

                // After advancing, break the current part if necessary
                if (curr != null) {
                    ListNode next_part = curr.next;  // The head of the next part
                    curr.next = null;  // Break the list here
                    curr = next_part;  // Move to the next part
                }

                res[i] = part_head;  // Add the head of the current part to the result
            }

            return res;
        }
    }
}
