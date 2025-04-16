public class SegmentTree {
    private int[] tree;
    private int n;

    // Constructor to initialize the segment tree
    public SegmentTree(int[] arr) {
        n = arr.length;
        // Height of segment tree
        int height = (int) (Math.ceil(Math.log(n) / Math.log(2)));
        // Maximum size of segment tree
        int maxSize = 2 * (int) Math.pow(2, height) - 1;
        tree = new int[maxSize];
        buildSegmentTree(arr, 0, n - 1, 0);
    }

    // A recursive function that builds the segment tree
    private int buildSegmentTree(int[] arr, int start, int end, int index) {
        // If there is only one element in the array, store it in the current node of the segment tree and return
        if (start == end) {
            tree[index] = arr[start];
            return arr[start];
        }

        // If there are more than one elements, calculate the middle point
        int mid = start + (end - start) / 2;

        // Build the left and right subtrees recursively and store their sum in the current node
        tree[index] = buildSegmentTree(arr, start, mid, index * 2 + 1) +
                buildSegmentTree(arr, mid + 1, end, index * 2 + 2);
        return tree[index];
    }

    // Function to update a value at a specific position in the array
    public void update(int pos, int value, int[] arr) {
        // Get the difference between new and old values
        int diff = value - arr[pos];
        arr[pos] = value;

        // Update the segment tree with the difference
        updateSegmentTree(0, n - 1, pos, diff, 0);
    }

    // A recursive function to update the segment tree
    private void updateSegmentTree(int start, int end, int pos, int diff, int index) {
        // If the position to be updated is outside the range of this node, return
        if (pos < start || pos > end)
            return;

        // If the position is within the range, update the current node
        tree[index] += diff;

        // If not a leaf node, recur for children
        if (start != end) {
            int mid = start + (end - start) / 2;
            updateSegmentTree(start, mid, pos, diff, 2 * index + 1);
            updateSegmentTree(mid + 1, end, pos, diff, 2 * index + 2);
        }
    }

    // Function to get the sum of elements in a given range
    public int getSum(int qStart, int qEnd) {
        // Check for invalid input
        if (qStart < 0 || qEnd > n - 1 || qStart > qEnd) {
            System.out.println("Invalid Input");
            return -1;
        }
        return getSumQuery(0, n - 1, qStart, qEnd, 0);
    }

    // A recursive function to get the sum of values in a given range
    private int getSumQuery(int start, int end, int qStart, int qEnd, int index) {
        // If segment of this node is completely within the given range, return the sum of the segment
        if (qStart <= start && qEnd >= end)
            return tree[index];

        // If segment of this node is outside the given range, return 0
        if (end < qStart || start > qEnd)
            return 0;

        // If a part of this segment overlaps with the given range, calculate from both sides
        int mid = start + (end - start) / 2;
        return getSumQuery(start, mid, qStart, qEnd, 2 * index + 1) +
                getSumQuery(mid + 1, end, qStart, qEnd, 2 * index + 2);
    }

    // Main method to demonstrate usage
    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 7, 9, 11};
        SegmentTree segTree = new SegmentTree(arr);

        System.out.println("Sum of values in range [1, 3]: " + segTree.getSum(1, 3));

        // Update value at index 1 to 10
        segTree.update(1, 10, arr);
        System.out.println("Updated array: ");
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();

        System.out.println("Sum of values in range [1, 3] after update: " + segTree.getSum(1, 3));
    }
}
