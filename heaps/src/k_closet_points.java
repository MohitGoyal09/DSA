import java.util.*;
public class k_closet_points {
    public int[][] kClosest(int[][] points, int k) {
        Queue<int[]> q = new PriorityQueue<int[]>((p1, p2) ->
                Integer.compare((p2[0] * p2[0] + p2[1] * p2[1]),(p1[0] * p1[0] + p1[1] * p1[1])));

        for (int[] point : points) {
            q.add(point);
            if (q.size() > k) {
                q.poll();
            }
        }
        int[][] arr = new int[k][2];
        while(k>0){
            arr[--k] = q.poll();
        }
        return arr;
    }
}
