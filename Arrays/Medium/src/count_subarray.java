import java.util.HashMap;

public class count_subarray {
    public static void main(String[] args) {
        int[] arr = {3, 1, 2, 4};
        int k = 6;
        int cnt = optimal(arr, k);
        System.out.println("The number of subarrays is: " + cnt);
    }

    // ? Burutte
    // ! Time complexity : O(n^3)
    // ! Space complexity : O(1)
    static int burutte(int[] arr , int k){
        int n = arr.length;
        int count = 0;
        for ( int i = 0 ; i < n ; i++){
            for ( int j = 0 ; j < n ; j++){
                int sum = 0;
                for ( int m = i ; m <=j ; m++){
                    sum +=arr[m];

                }
                if ( sum == k) count++;

            }
        }

        return count;
    }

    // ? Better
    // ! Time complexity : O(n^2)
    // ! Space complexity : O(1)
    static int better(int[] arr , int k){
        int n = arr.length;
        int count = 0;
        for ( int i = 0 ; i < n ; i++){
            int sum = 0;
            for ( int j = i ;  j < n ; j++){
                sum +=arr[j];
                if ( sum == k){
                    count++;
                }
            }
        }
        return count;

    }

    // ? Optimal
    static int optimal(int[] arr , int k) {
        HashMap<Integer, Integer> ans = new HashMap<>();
        int count = 0;
        int n = arr.length;
        int presum = 0;
        ans.put(0, 1);
        for (int i = 0; i < n; i++){
            // add current element to prefix Sum:
            presum +=arr[i];
            // Calculate x-k:
            int remove = presum - k;
            // Add the number of subarrays to be removed:
            count +=ans.getOrDefault(remove,0);
            // Update the count of prefix sum
            // in the map.
            ans.put(presum, ans.getOrDefault(presum,0)+1);
        }
            return count;
    }
}


