public class OrderAgnosticBS {
    public static void main(String[] args) {
        int[] arr = { 79 , 77 , 45 , 34 , 23 , 22 , 19 , 12 , 7 , 2, 0};
        int target = 45;
        int ans = orderAgnosticBS(arr, target); // Call the binary search function
        System.out.println(ans); // Print the result
    }

    // Binary search function to find the target element in a sorted array (ascending or descending)
    static int orderAgnosticBS(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;

        // Determine if the array is in ascending or descending order
        boolean isAsc = arr[start] < arr[end];

        while (start <= end) {
            // Calculate the middle index
            int mid = start + (end - start) / 2;

            // Check if the middle element is the target
            if (arr[mid] == target) {
                return mid; // Target found, return its index
            }

            // Adjust the search range based on order (ascending or descending)
            if (isAsc) {
                if (target < arr[mid]) {
                    end = mid - 1; // Update end pointer for ascending order
                } else {
                    start = mid + 1; // Update start pointer for ascending order
                }
            } else {
                if (target > arr[mid]) {
                    end = mid - 1; // Update end pointer for descending order
                } else {
                    start = mid + 1; // Update start pointer for descending order
                }
            }
        }

        return -1; // Target not found in the array
    }
}
