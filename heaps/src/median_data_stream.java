import java.util.*;
public class median_data_stream {
    class MedianFinder {
        private PriorityQueue<Integer> leftMaxHeap; // max heap
        private PriorityQueue<Integer> rightMinHeap; // min heap

        public MedianFinder() {
            leftMaxHeap = new PriorityQueue<>(Collections.reverseOrder());
            rightMinHeap = new PriorityQueue<>();
        }

        public void addNum(int num) {
            if (leftMaxHeap.isEmpty() || num < leftMaxHeap.peek()){
                leftMaxHeap.add(num);
            } else {
                rightMinHeap.add(num);
            }
            if (Math.abs(leftMaxHeap.size() - rightMinHeap.size()) > 1) {
                rightMinHeap.add(leftMaxHeap.poll());
            } else if (leftMaxHeap.size() < rightMinHeap.size()) {
                leftMaxHeap.add(rightMinHeap.poll());
            }
        }

        public double findMedian() {
            if (leftMaxHeap.size() == rightMinHeap.size()) {
                // even number of elements
                return (double) (leftMaxHeap.peek() + rightMinHeap.peek()) / 2;
            }

            // odd number of elements
            return leftMaxHeap.peek();
        }
    }
}
