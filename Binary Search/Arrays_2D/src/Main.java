import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> matrix = new ArrayList<>();

        matrix.add(new ArrayList<>(Arrays.asList(0, 0, 1)));
        matrix.add(new ArrayList<>(Arrays.asList(0, 0, 0)));
        matrix.add(new ArrayList<>(Arrays.asList(1, 1, 1)));
        int n = 3, m = 3;
        System.out.println("The row with the maximum number of 1's is: " +
                bs(matrix, n, m));
    }

    static int rowwithMatrix(ArrayList<ArrayList<Integer>> matrix, int n, int m){
        int cnt_max =0;
        int index = -1;
        for ( int i = 0 ; i < n ; i++){
            int cnt = 0;
            for ( int j = 0 ; j < m ; j++){
                cnt += matrix.get(i).get(j);
            }
            if ( cnt > cnt_max){
                cnt_max = cnt;
                index = i;
            }
        }
        return index;
    }

    static int bs(ArrayList<ArrayList<Integer>> matrix , int n  , int m){
        int cnt_max = 0;
        int index = -1;
        for ( int i = 0 ; i < n ; i++){
            int cnt_ones = m - lower_bound(matrix.get(i) , 1);
            if (cnt_ones > cnt_max){
                cnt_max = cnt_ones;
                index = i;
            }
        }
        return index;
    }

    static int lower_bound(ArrayList<Integer> arr, int target) {
        int n = arr.size();
        int ans = n;
        int low = 0 , high = n - 1;
        while ( low <= high){
            int mid = (low + high) / 2;
            if ( arr.get(mid) >= target){
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }

        }
        return ans;
    }
}