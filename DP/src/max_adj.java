public class max_adj {
    public int solve(int n , int dp[] , int arr[]){
        if ( n== 0 ) return arr[n];
        if ( n < 0) return 0;
        if ( dp[n] != -1 ) return dp[n];
        int pick = arr[n] + solve(n-2 , dp , arr);
        int notPick = solve(n-1 , dp , arr);
        return dp[n] = Math.max(pick , notPick);
    }
    public int solve2(int n , int[] dp , int[] arr){
        dp[0] = arr[0];
        for (int i = 1 ; i < n ; i++){
            int pick = arr[i];
            if ( i > 1) pick += dp[i-2];
            int notPick = dp[i-1];
            dp[i] = Math.max(pick , notPick);
        }
        return dp[n-1];
    }
    static int solve(int n, int[] arr) {
        // Initialize variables to keep track of the maximum sums at the current and previous positions.
        int prev = arr[0];
        int prev2 = 0;

        // Iterate through the array starting from the second element.
        for (int i = 1; i < n; i++) {
            // Calculate the maximum sum by either picking the current element or not picking it.
            int pick = arr[i];

            // If there are at least two elements before the current element, add the value from prev2.
            if (i > 1)
                pick += prev2;

            // The non-pick option is to use the maximum sum from the previous position.
            int nonPick = prev;

            // Calculate the maximum sum for the current position and update prev and prev2.
            int cur_i = Math.max(pick, nonPick);
            prev2 = prev;
            prev = cur_i;
        }

        // The 'prev' variable now holds the maximum possible sum.
        return prev;
    }
}

