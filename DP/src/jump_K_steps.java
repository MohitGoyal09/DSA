import java.util.Arrays;

public class jump_K_steps {
    public int minimizeCost(int arr[], int k) {
        // code here
        int n = arr.length;
        int[] dp = new int[n];
        Arrays.fill(dp , -1);
        return solve(n - 1 , arr , dp , k);
    }
    public int solve(int ind , int[] arr , int[] dp , int k){
        if ( ind == 0) return 0;
        if (dp[ind] != -1) return dp[ind];
        int mmSteps = Integer.MAX_VALUE;
        for (int j = 1 ; j <= k ; j++){
            if ( ind - j >= 0 ){
                int jump = solve(ind - j , arr , dp , k ) + Math.abs(arr[ind] - arr[ind - j ]);
                mmSteps = Math.min(jump , mmSteps);
            }
        }
        return dp[ind] = mmSteps;
    }
    static int solveUtil(int n, int[] height, int[] dp, int k) {
        dp[0] = 0;

        // Loop through the array to fill in the dp array
        for (int i = 1; i < n; i++) {
            int mmSteps = Integer.MAX_VALUE;

            // Loop to try all possible jumps from '1' to 'k'
            for (int j = 1; j <= k; j++) {
                if (i - j >= 0) {
                    int jump = dp[i - j] + Math.abs(height[i] - height[i - j]);
                    mmSteps = Math.min(jump, mmSteps);
                }
            }
            dp[i] = mmSteps;
        }
        return dp[n - 1]; // The result is stored in the last element of dp
    }
}
