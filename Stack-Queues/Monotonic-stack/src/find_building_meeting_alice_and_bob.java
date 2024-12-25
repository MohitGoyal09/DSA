import java.util.*;
public class find_building_meeting_alice_and_bob {
    public int[] leftmostBuildingQueries(int[] heights, int[][] queries) {
            int n = heights.length, q = queries.length;
            int[] result = new int[q];
            Arrays.fill(result, -1);
            List<List<int[]>> deferred = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                deferred.add(new ArrayList<>());
            }
            PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));

            for (int i = 0; i < q; ++i) {
                int a = queries[i][0], b = queries[i][1];
                if (a > b) {
                    int temp = a;
                    a = b;
                    b = temp;
                }
                if (a == b || heights[a] < heights[b]) result[i] = b;
                else deferred.get(b).add(new int[]{heights[a], i});
            }

            for (int i = 0; i < n; ++i) {
                for (int[] query : deferred.get(i)) pq.add(query);
                while (!pq.isEmpty() && pq.peek()[0] < heights[i]) {
                    result[pq.poll()[1]] = i;
                }
            }

            return result;
        }

}
