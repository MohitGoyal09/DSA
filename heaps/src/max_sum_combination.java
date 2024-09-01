import java.util.*;
public class max_sum_combination {
    public class Solution {
        public ArrayList<Integer> solve(ArrayList<Integer> A, ArrayList<Integer> B, int C) {
            ArrayList<Integer> arr = new ArrayList<>();
            Collections.sort(A, Collections.reverseOrder());
            Collections.sort(B, Collections.reverseOrder());
            PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> {
                if(a[0] == b[0])    return b[1]-a[0];
                return b[0] - a[0];
            });
            for(int i = 0 ; i < C; i++) pq.add(new int[]{A.get(i)+B.get(0),0});
            while(!pq.isEmpty() && C-->0){
                int sum = pq.peek()[0];
                int index = pq.peek()[1];
                pq.poll();
                arr.add(sum);
                if(index+1 < B.size()) pq.add(new int[]{sum-B.get(index) + B.get(index+1),index+1});
            }
            return arr;
        }
    }
}
