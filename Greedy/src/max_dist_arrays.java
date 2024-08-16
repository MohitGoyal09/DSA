import java.util.*;
//Initialize Variables:
//result is initialized to Integer.MIN_VALUE to store the maximum distance.
//max and min store the maximum and minimum values of the first array, respectively.
//Iterate Through Arrays:
//For each array starting from the second, calculate two possible distances
//
//The distance between the smallest element in the current array and the largest element encountered so far.
//The distance between the largest element in the current array and the smallest element encountered so far.
//Update result with the maximum of these distances.
//
//Update max and min for subsequent comparisons.
public class max_dist_arrays {
    class Solution {
        public int maxDistance(List<List<Integer>> arrays) {
            int smallest = arrays.get(0).get(0);
            int biggest = arrays.get(0).get(arrays.get(0).size() - 1);
            int maxDistance = 0;

            for (int i = 1; i < arrays.size(); i++) {
                maxDistance = Math.max(maxDistance, Math.abs(arrays.get(i).get(arrays.get(i).size() - 1) - smallest));
                maxDistance = Math.max(maxDistance, Math.abs(biggest - arrays.get(i).get(0)));
                smallest = Math.min(smallest, arrays.get(i).get(0));
                biggest = Math.max(biggest, arrays.get(i).get(arrays.get(i).size() - 1));
            }

            return maxDistance;
        }
    }
//    Use PriorityQueue. Java uses Comparator, and C++ uses custom comparator functions to manage the heaps.
//    The code in all languages stores both the value and the index of the array it came from.
//    This is crucial to check if the elements are from different arrays.
//    If the smallest and largest values belong to the same array, the code checks
//    the next smallest and largest elements to ensure the difference is maximized.
//    Finally, the code returns the largest possible difference based on the criteria.
    public int maxDistance(List<List<Integer>> arrays) {
        // Min-Heap for smallest elements
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        // Max-Heap for largest elements
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> Integer.compare(b[0], a[0]));

        // Fill the heaps with elements from the arrays
        for (int i = 0; i < arrays.size(); i++) {
            minHeap.offer(new int[] {arrays.get(i).get(0), i});
            maxHeap.offer(new int[] {arrays.get(i).get(arrays.get(i).size() - 1), i});
        }

        // Get the smallest and largest elements
        int[] minElement = minHeap.poll();
        int[] maxElement = maxHeap.poll();

        int minVal = minElement[0];
        int maxVal = maxElement[0];
        int diff = Math.abs(maxVal - minVal);

        // If the smallest and largest elements come from the same array
        if (minElement[1] == maxElement[1]) {
            // Get the next smallest and largest elements
            int[] nextMin = minHeap.poll();
            int[] nextMax = maxHeap.poll();
            int altDiff1 = Math.abs(nextMax[0] - minVal);
            int altDiff2 = Math.abs(maxVal - nextMin[0]);
            diff = Math.max(altDiff1, altDiff2);
        }

        return diff;
    }
}
