import java.util.PriorityQueue;

public class kth_largest_and_smallest {
    public int findKthLargest(int[] nums, int k) {
        //create a min heap
        PriorityQueue<Integer> heap = new PriorityQueue();

        //iterate over the array
        for (int n : nums) {
            //first add the integer to heap
            heap.add(n);
            //if size of the heap is greater than k
            if (heap.size() > k) {
                //remove the root element (lowest of all)
                heap.poll();
            }
        }
        //finally heap has k largest elements left with root as the kth largest element
        return heap.peek();
    }
    public static int kthSmallest(int[] arr, int k) {
        // Your code here
        PriorityQueue<Integer> prio = new PriorityQueue<>();
        for(int i = 0; i < arr.length; i++){
            prio.add(arr[i]);
        }
        for(int i = 1; i < k; i++){
            prio.poll();
        }
        return prio.peek();
    }
}
