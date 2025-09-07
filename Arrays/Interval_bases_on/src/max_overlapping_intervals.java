class Solution {

    /**
     * Merges overlapping intervals in a 2D array.
     * Time Complexity: O(N log N) due to sorting, where N is the number of intervals.
     * Space Complexity: O(N) for the output list.
     */
    public int[][] merge(int[][] intervals) {
        ArrayList<int[]> ans = new ArrayList<>();
        // Sort intervals by start time
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        // Add the first interval to the answer list
        ans.add(intervals[0]);
        for (int i = 1; i < intervals.length; i++) {
            // Get the start of the current interval
            int curStart = intervals[i][0];
            // If current interval overlaps with the last interval in ans, merge them
            if (curStart <= ans.get(ans.size() - 1)[1]) {
                ans.get(ans.size() - 1)[1] =
                    Math.max(ans.get(ans.size() - 1)[1], intervals[i][1]);
            } else {
                // Otherwise, add the current interval as a new interval
                ans.add(intervals[i]);
            }
        }
        // Convert the list to a 2D array
        int[][] res = new int[ans.size()][2];
        ans.toArray(res);
        return res;
    }

    /**
     * Merges overlapping intervals and returns a list of merged intervals.
     * Brute-force approach.
     * Time Complexity: O(N^2) in the worst case due to nested loops.
     * Space Complexity: O(N) for the output list.
     */
    public static List<List<Integer>> mergeOverlappingIntervals(int[][] arr) {
        int n = arr.length; // size of the array
        // Sort the given intervals by start time
        Arrays.sort(arr, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return a[0] - b[0];
            }
        });

        List<List<Integer>> ans = new ArrayList<>();

        for (int i = 0; i < n; i++) { // Select an interval
            int start = arr[i][0];
            int end = arr[i][1];

            // Skip all the merged intervals
            if (!ans.isEmpty() && end <= ans.get(ans.size() - 1).get(1)) {
                continue;
            }

            // Check the rest of the intervals for overlap and merge if needed
            for (int j = i + 1; j < n; j++) {
                if (arr[j][0] <= end) {
                    end = Math.max(end, arr[j][1]);
                } else {
                    break;
                }
            }
            ans.add(Arrays.asList(start, end));
        }
        return ans;
    }

    /**
     * Merges overlapping intervals using an optimized approach.
     * Time Complexity: O(N log N) due to sorting, then O(N) for merging.
     * Space Complexity: O(N) for the output list.
     */
    public static List<List<Integer>> mergeOverlappingIntervals2(int[][] arr) {
        int n = arr.length; // size of the array
        // Sort the given intervals by start time
        Arrays.sort(arr, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return a[0] - b[0];
            }
        });

        List<List<Integer>> ans = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            // If the current interval does not overlap with the last interval in ans, add it
            if (ans.isEmpty() || arr[i][0] > ans.get(ans.size() - 1).get(1)) {
                ans.add(Arrays.asList(arr[i][0], arr[i][1]));
            }
            // If the current interval overlaps, merge it with the last interval
            else {
                ans.get(ans.size() - 1).set(1,
                                            Math.max(ans.get(ans.size() - 1).get(1), arr[i][1]));
            }
        }
        return ans;
    }
}
