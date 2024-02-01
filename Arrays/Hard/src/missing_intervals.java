import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class missing_intervals {
    public static void main(String[] args) {
        int[][] arr = {{1, 3}, {8, 10}, {2, 6}, {15, 18}};
        List<List<Integer>> ans = optimal(arr);
        System.out.print("The merged intervals are: \n");
        for (List<Integer> it : ans) {
            System.out.print("[" + it.get(0) + ", " + it.get(1) + "] ");
        }
        System.out.println();

    }
    // ? Brute Forces
    // ! Time Complexity: O(N*logN) + O(2*N), where N = the size of the given array.
    // ! Space Complexity: O(N), as we are using an answer list to store the merged intervals.
    //  * Except for the answer array, we are not using any extra space.

    static List<List<Integer>> brutte(int[][] a){
        int n = a.length;
        Arrays.sort(a, (a1, a2) -> a1[0] - a2[0]);
        List<List<Integer>> ans = new ArrayList<>();
        for ( int i = 0 ; i < n ; i++){
            int start = a[i][0];
            int end = a[i][1];

            if (!ans.isEmpty() && end <=ans.get(ans.size()-1).get(1))   continue;
            for ( int j = i + 1 ; j < n ; j++){
                if (a[j][0] <= end){
                    end = Math.max(end, a[j][1]);
                } else break;
            }
            ans.add(Arrays.asList(start , end));
        }
        return ans;
    }

    // ? Optimal
    // ! Time Complexity: O(N*logN) + O(N), where N = the size of the given array.
    // ! Space Complexity: O(N)
    static List<List<Integer>> optimal(int[][] a){
        int n = a.length;
        Arrays.sort(a, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return a[0] - b[0];
            }
        });
        List<List<Integer>> ans = new ArrayList<>();
        for ( int i = 0 ; i < n ; i++){
            if (ans.isEmpty() || a[i][0] > ans.get(ans.size() - 1).get(1)){
                       ans.add(Arrays.asList(a[i][0] , a[i][1]));
            } else {
                ans.get(ans.size() -1).set(1, Math.max(ans.get(ans.size() - 1).get(1) , a[i][1]));
            }
        }
        return ans;

    }
}
