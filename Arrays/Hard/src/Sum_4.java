import java.util.*;

public class Sum_4 {
    public static void main(String[] args) {
        int[] nums = {4, 3, 3, 4, 4, 2, 1, 2, 1, 1};
        int target = 9;
        List<List<Integer>> ans = optimal(nums, target);
        System.out.println("The quadruplets are: ");
        for (List<Integer> it : ans) {
            System.out.print("[");
            for (int ele : it) {
                System.out.print(ele + " ");
            }
            System.out.print("] ");
        }
        System.out.println();

    }

    // ? Brute Force
    // ! Time Complexity: O(N^4)
    // ! Space Complexity: O(2 * no. of the quadruplets) as we are using a set data structure and a list to store the quads.
    static List<List<Integer>> brute(int[] a , int target){
        int n = a.length;
        HashSet<List<Integer>> set = new HashSet<>();
        for (int i = 0 ; i < n ; i++){
            for ( int j = i + 1 ; j < n ; j++){
                for ( int k = j + 1 ; k < n ; k++){
                    for ( int l = j+1 ; l < n ; l++){
                        long sum = a[i] + a[j];
                        sum += a[k];
                        sum += a[l];
                        if (sum == target) {
                            List<Integer> temp = Arrays.asList(a[i], a[j], a[k], a[l]);
                            Collections.sort(temp);
                            set.add(temp);
                        }
                    }
                }
            }
        }
        List<List<Integer>> ans = new ArrayList<>(set);
        return ans;
    }

    // ? Better
    // ! Time Complexity : O(N^3)
    // ! Space Complexity : O(2 * no. of the unique quadruplets) + O(N)
    static List<List<Integer>> better(int[] a , int target){
        int n = a.length;
        Set<List<Integer>> set = new HashSet<>();
        for (int i = 0 ; i < n ; i++){
            for ( int j = i + 1 ; j < n ; j++){
                Set<Long> hashset = new HashSet<>();
                for ( int k =  j + 1 ; k < n ; k++){
                    long sum = a[i] + a[j];
                    sum += a[k];
                   long fourth = target - sum;
                   if ( hashset.contains(fourth)){
                       List<Integer> temp = new ArrayList<>();
                       temp.add(a[i]);
                       temp.add(a[j]);
                       temp.add(a[k]);
                       temp.add((int) fourth);
                       temp.sort(Integer::compareTo);
                      set.add(temp);
                   }
                   hashset.add((long) fourth);
                }
            }

        }
        List<List<Integer>> ans = new ArrayList<>(set);
        return ans;
    }
    // ? Optimal
//    ! Time Complexity: O(N3), where N = size of the array.
//    * Reason: Each of the pointers i and j, is running for approximately N times. And both
//    * the pointers k and l combined can run for approximately N times including the operation of skipping
//    * duplicates. So the total time complexity will be O(N3).

//    !  Space Complexity: O(no. of quadruplets), This space is only used to store the answer.
//   * We are not using any extra space to solve this problem. So, from that perspective,
//    * space complexity can be written as O(1).
    static List<List<Integer>> optimal(int[] a , int target){
        int n = a.length;
        Arrays.sort(a);
        List<List<Integer>> ans = new ArrayList<>();
        for(int i = 0; i < n; i++){
            if ( i > 0 && a[i] == a[i-1]) continue;
            for ( int j = i+1 ; j < n ; j++){
                if ( j > i + 1 && a[j] == a[j-1]) continue;
                int k = j + 1;
                int l = n - 1;
                while ( k < l) {
                    long sum = a[i];
                    sum += a[j];
                    sum += a[k];
                    sum += a[l];
                    if (sum == target) {
                        List<Integer> temp = new ArrayList<>();
                        temp.add(a[i]);
                        temp.add(a[j]);
                        temp.add(a[k]);
                        temp.add(a[l]);
                        ans.add(temp);
                        k++;
                        l--;
                        while (k < l && a[k] == a[k - 1]) k++;
                        while (k < l && a[l] == a[l + 1]) l--;

                    } else if ( sum < target) k++;
                    else l--;
                }
            }
        }
        return ans;
    }
}
