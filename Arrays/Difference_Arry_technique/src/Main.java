public class Main {
    //Approach (Using Difference Array Technique)
//T.C : O(m+n), m = length of queries, n = length of array
//S.C : O(n)
    public int[] getModifiedArray(int length, int[][] updates) {
        int[] diff = new int[length]; // Initialize the difference array

        // Step 1: Apply updates using the difference array
        for (int[] update : updates) {
            int start = update[0];
            int end = update[1];
            int x = update[2];

            diff[start] += x; // Add increment at startIndex
            if (end + 1 < length) {
                diff[end + 1] -= x; // Subtract increment after endIndex
            }
        }

        // Step 2: Compute the final array from the difference array
        int[] result = new int[length];
        int cumSum = 0;
        for (int i = 0; i < length; i++) {
            cumSum += diff[i];
            result[i] = cumSum;
        }

        return result;
    }
}