
public class Main {
    // Function to find the length of the longest increasing subsequence
    static int getAns(int arr[], int n, int ind, int prev_index, int[][] dp) {
        // Base condition
        if (ind == n) {
            return 0;
        }

        if (dp[ind][prev_index + 1] != -1) {
            return dp[ind][prev_index + 1];
        }

        int notTake = getAns(arr, n, ind + 1, prev_index, dp);

        int take = 0;

        if (prev_index == -1 || arr[ind] > arr[prev_index]) {
            take = 1 + getAns(arr, n, ind + 1, ind, dp);
        }

        dp[ind][prev_index + 1] = Math.max(notTake, take);

        return dp[ind][prev_index + 1];
    }
   static int LIS(int arr[] , int n) {
       int[][] dp = new int[n][n + 1];
       for (int ind = n - 1; ind >= 0; ind--) {
           for (int prev_index = ind - 1; prev_index >= -1; prev_index--) {
               int notTake = dp[ind + 1][prev_index + 1];
               int take = 0;
               if (prev_index == -1 || arr[ind] > arr[prev_index]) {

                   take = 1 + dp[ind + 1][ind + 1];
               }

               dp[ind][prev_index + 1] = Math.max(notTake, take);
           }
       }
       return dp[0][0];
   }
   static int space(int arr[] , int n){
        int[] prev = new int[n+1];
        int[] curr = new int[n+1];

        for (int ind = n - 1 ; ind>= 0 ; ind--){
            for (int prev_ind = ind - 1; prev_ind >= 0 ; prev_ind--){
                int notake = prev[prev_ind + 1];
                int take = 0;
                if (prev_ind == -1 || arr[ind] > arr[prev_ind]){
                    take = 1 + curr[prev_ind + 1];
                }
                curr[prev_ind + 1] = Math.max(notake , take);
            }
            prev = curr;
        }
        return prev[0];
   }



}


