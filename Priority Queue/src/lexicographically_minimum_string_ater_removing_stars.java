import java.util.*;
public class lexicographically_minimum_string_ater_removing_stars {
    public String clearStars(String s) {
        int n = s.length();
        PriorityQueue<Character> pq = new PriorityQueue<>();
        Map<Character , Deque<Integer>> map = new HashMap<>();
        boolean[] keep = new boolean[n];
        Arrays.fill(keep, true);

        for (int i = 0 ; i < n  ;i++){
            char c = s.charAt(i);
            if ( c == '*'){
                char smallest = pq.poll();
                int indextoRemove = map.get(smallest).removeLast();
                keep[i] = false;
                keep[indextoRemove] = false;
            } else {
                pq.offer(c);
                map.putIfAbsent(c , new ArrayDeque<>());
                map.get(c).add(i);
            }
        }
        StringBuilder result = new StringBuilder();
        for (int i = 0 ; i <  n ; i++){
            if (keep[i]){
                result.append(s.charAt(i));
            }
        }
        return result.toString();
    }
}
