import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

public class slinding_mindow_max {
    public static void main(String[] args) {

    }
    static ArrayList<Integer> buruttefore(int[] arr, int k){
        int n = arr.length;
        int left = 0 , right = 0 ;
        int i , j;
        ArrayList<Integer> ans = new ArrayList<>();
        while (right < k-1){
            right++;
        }
        while (right < n){
            Getmax(arr , left , right , ans);
            left++;
            right++;
        }
        return ans;
    }

    private static void Getmax(int[] arr, int left, int right, ArrayList<Integer> ans) {
        int i , maxi = Integer.MIN_VALUE;
        for (i = 0 ; i < right ; i++){
            maxi = Math.max(maxi , arr[i]);
            ans.add(maxi);
        }
    }

    //  ! Optimal

    static int[] optimal(int[] arr , int k){
        int n = arr.length;
        int[] r = new int[n-k+1];
        int ri = 0;
        Deque<Integer> q = new ArrayDeque<>();
        for (int i = 0 ; i < n ; i++){
            // ! remove out of bound of K
            if (!q.isEmpty() && q.peek() == i-k){
                q.poll();
            }
            // ! remove smallest element than arr[i]
            while (!q.isEmpty() && arr[q.peekLast()] < arr[i]){
                q.pollLast();
            }
            q.offer(i);
            if (i >= k-1){
                r[ri++] = arr[q.peekFirst()];
            }
        }
        return r;
    }
}
