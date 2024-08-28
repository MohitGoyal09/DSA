public class convertMintoMaxheap {
    class Solution {
        static void convertMinToMaxHeap( int N , int arr[]) {
            // Start from the last non-leaf node and move up.
            for (int i = (N / 2) - 1; i >= 0; i--) {
                // Perform heapify operation on each non-leaf node.
                heapify(arr, N, i);
            }
        }

        static void heapify(int[] arr, int N, int index) {
            int largest = index; // Initialize largest as the current node.
            int leftChild = 2 * index + 1; // Index of the left child.
            int rightChild = 2 * index + 2; // Index of the right child.

            // Compare the current node with its left child.
            if (leftChild < N && arr[leftChild] > arr[largest]) {
                largest = leftChild;
            }

            // Compare the current node with its right child.
            if (rightChild < N && arr[rightChild] > arr[largest]) {
                largest = rightChild;
            }

            // If the largest element is not the current node, swap them and recursively heapify the affected subtree.
            if (largest != index) {
                int temp = arr[index];
                arr[index] = arr[largest];
                arr[largest] = temp;
                heapify(arr, N, largest);
            }
        }
    }
}
