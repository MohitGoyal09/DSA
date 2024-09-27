import java.util.*;
public class k_sized_subaaray_max {
    public ArrayList<Integer> max_of_subarrays(int k, int arr[]) {
        // Your code here
        ArrayList<Integer> list = new ArrayList<>();
        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0 ; i < arr.length ; i++){
            if (!deque.isEmpty() && deque.peekFirst() <= i-k) deque.pollFirst();
            while (!deque.isEmpty() && arr[deque.peekLast()] <= arr[i]) deque.pollLast();
            deque.offerLast(i);
            if ( i >= k- 1) list.add(arr[deque.peekFirst()]);
        }
        return list;
    }
}
