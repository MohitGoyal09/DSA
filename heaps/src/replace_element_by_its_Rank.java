import java.util.*;
public class replace_element_by_its_Rank {
    static int[] replaceWithRank(int arr[], int n) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            pq.add(arr[i]);
        }

        int rank = 0;
        while (!pq.isEmpty()) {
            int a = pq.poll();
            if (!map.containsKey(a))
                map.put(a, ++rank);
        }

        for (int i = 0; i < n; i++) {
            arr[i] = map.get(arr[i]);
        }

        return arr;
    }
}
