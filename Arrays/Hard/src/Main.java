import java.util.*;

// ! 3 SUM PROBLEM
public class Main {
    public static void main(String[] args) {
        int[] arr = {1, 2, -2, 3, 4, 5, -1};
        int n = arr.length;
        List<List<Integer>> ans = optimal( arr , n);
        for (List<Integer> it : ans) {
            System.out.print("[");
            for (Integer i : it) {
                System.out.print(i + " ");
            }
            System.out.print("] ");
        }
        System.out.println();
    }

     // ? Burute Force
    // ! Time Complexity: O(N^3)
    // ! Space Complexity : O(2 * no. of the unique triplets)
    static List<List<Integer>> burute(int[] a , int n){
        Set<List<Integer>> st = new HashSet<>();
        for ( int i = 0 ; i < n ; i++){
            for ( int j = i+1 ; j < n ; j++){
                for ( int k = j + 1 ; k < n ; k++){
                    if (a[i] + a[j] + a[k] == 0){
                          List<Integer> temp = Arrays.asList(a[i] , a[j] , a[k]  );
                          temp.sort(null);
                          st.add(temp);
                    }
                }
            }
        }
        List<List<Integer>> result = new ArrayList<>(st);
        return result;

    }

    // ? Better Approach
   // ! Time Complexity: O(N2 * log(no. of unique triplets)), where N = size of the array.
    // ! Reason: Here, we are mainly using 3 nested loops. And inserting triplets
    // ! into the set takes O(log(no. of unique triplets)) time complexity.
    // ! But we are not considering the time complexity of sorting as we are just sorting 3 elements every time.

    // !Space Complexity: O(2 * no. of the unique triplets) + O(N) as we are using a set data structure
    // !and a list to store the triplets and extra O(N) for storing the array elements in another set.

    static List<List<Integer>> better(int[] a , int n){
        Set<List<Integer>> set = new HashSet<>();
        for ( int i = 0 ; i < n ; i++){
            Set<Integer> hashSet = new HashSet<>();
            for ( int j = i+1 ;  j < n ; j++){
                int third = - ( a[i] + a[j]) ;
                if (hashSet.contains(third)){
                    List<Integer> temp = Arrays.asList(a[i] , a[j] , third  );
                    temp.sort(null);
                    set.add(temp);
                }
                hashSet.add(a[j]);
            }
        }
        List<List<Integer>> result = new ArrayList<>(set);
        return result;
    }

    // ? Optimal Approach
    // ! Time Complexity : O(NlogN) + O(N^2)
    // ! Space Complexity : O(No. of triplets)

    static List<List<Integer>> optimal(int[] a , int n){
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(a);
        for ( int i = 0 ; i < n ; i++){
            if ( i > 0 && a[i] == a[i-1]) continue;
            int j = i + 1;
            int k = n-1;
            while ( j < k){
                int sum = a[i] + a[j] + a[k];
                if ( sum > 0) k--;
                else if ( sum < 0) j++;
                else {
                    List<Integer> temp = Arrays.asList(a[i] , a[j] , a[k]);
                    ans.add(temp);
                    j++;
                    k--;
                    while ( j < k && a[j] == a[j-1]) j++;
                    while ( j < k && a[k] == a[k+1]) k--;
                }

            }
        }
        return ans;
    }
}