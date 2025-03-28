import java.util.*;
public class check_grid_cut_in_sections {
    public int[][] merge(int[][] intervals) {
        int n = intervals.length;

        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        List<int[]> result = new ArrayList<>();
        result.add(intervals[0]);

        for (int i = 1; i < n; i++) {
            if (intervals[i][0] < result.get(result.size() - 1)[1]) { // Overlapping
                result.get(result.size() - 1)[1] = Math.max(result.get(result.size() - 1)[1], intervals[i][1]);
            } else {
                result.add(intervals[i]);
            }
        }

        return result.toArray(new int[result.size()][]);
    }

    public boolean checkValidCuts(int n, int[][] rectangles) {
        List<int[]> hor = new ArrayList<>();
        List<int[]> vert = new ArrayList<>();

        for (int[] coord : rectangles) {
            int x1 = coord[0];
            int y1 = coord[1];
            int x2 = coord[2];
            int y2 = coord[3];

            hor.add(new int[]{x1, x2});
            vert.add(new int[]{y1, y2});
        }

        int[][] horArray = hor.toArray(new int[hor.size()][]);
        int[][] vertArray = vert.toArray(new int[vert.size()][]);

        int[][] result1 = merge(horArray);
        if (result1.length >= 3) {
            return true;
        }

        int[][] result2 = merge(vertArray);
        return result2.length >= 3;
    }
}
