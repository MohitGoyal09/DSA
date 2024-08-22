import java.util.ArrayList;

public class insert_interval {
    class Solution {
        public int[][] insert(int[][] intervals, int[] newInterval) {
            ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
            int n = intervals.length;
            int i = 0;

            // Add all intervals before the new interval
            while (i < n && intervals[i][1] < newInterval[0]) {
                ArrayList<Integer> temp = new ArrayList<>();
                temp.add(intervals[i][0]);
                temp.add(intervals[i][1]);
                ans.add(temp);
                i++;
            }

            // Merge overlapping intervals with the new interval
            while (i < n && intervals[i][0] <= newInterval[1]) {
                newInterval[0] = Math.min(intervals[i][0], newInterval[0]);
                newInterval[1] = Math.max(intervals[i][1], newInterval[1]);
                i++;
            }

            // Add the merged interval
            ArrayList<Integer> temp = new ArrayList<>();
            temp.add(newInterval[0]);
            temp.add(newInterval[1]);
            ans.add(temp);

            // Add remaining intervals
            while (i < n) {
                temp = new ArrayList<>();
                temp.add(intervals[i][0]);
                temp.add(intervals[i][1]);
                ans.add(temp);
                i++;
            }

            // Convert ArrayList to int[][] array
            int[][] res = new int[ans.size()][2];
            for (int j = 0; j < ans.size(); j++) {
                res[j][0] = ans.get(j).get(0);
                res[j][1] = ans.get(j).get(1);
            }

            return res;
        }
    }
}
