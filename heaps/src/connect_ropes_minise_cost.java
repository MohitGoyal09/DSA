import java.util.*;
public class connect_ropes_minise_cost {
    private static int connectRopes(int[] arr, int size) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        int cost = 0;

        for (int i = 0; i < size; i++) {
            minHeap.add(arr[i]);
        }

        while (minHeap.size() >= 2) {
            int first = minHeap.poll();
            int second = minHeap.poll();
            cost += first + second;
            minHeap.add(first + second);
        }
        return cost;
    }
}
