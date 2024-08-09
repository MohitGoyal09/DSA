import java.util.Arrays;

public class mini_coins {
    class Solution {
        public int coinChange(int[] coins, int amount) {
            int n = coins.length;
            int[][] dp = new int[n][amount + 1];
            for ( int[] rows : dp){
                Arrays.fill(rows , -1);
            }
            int ans =  solve( coins , n - 1 , amount , dp);
            if ( ans >= (int) Math.pow(10,9)) return -1;
            return ans;
        }
        public int solve(int[] arr , int ind , int T , int[][] dp){
            if (ind == 0){
                if ( T % arr[0] == 0) return T/arr[0];
                else return (int) Math.pow(10,9);
            }
            if ( dp[ind][T] != -1) return dp[ind][T];
            int notaken = solve(arr , ind - 1 , T , dp);
            int taken = (int) Math.pow(10, 9);

            // If the current element is less than or equal to T, calculate the minimum taking it
            if (arr[ind] <= T)
                taken = 1 + solve(arr, ind, T - arr[ind], dp);

            // Store the minimum result in the dp array and return it
            return dp[ind][T] = Math.min(notaken, taken);
        }
        static int table(int[] coins , int amount){
            int n = coins.length;
            int[][] dp=  new int[n][amount + 1];
            for ( int i = 0 ;  i <= amount ; i++){
                if ( i % coins[0] == 0) dp[0][i] = i/coins[0];
                else dp[0][i] = (int) Math.pow(10,9);
            }
            for (int ind = 1 ; ind < n ; ind++){
                for ( int target = 0 ; target <= amount ; target++){
                    int notaken = dp[ind - 1][target];
                    int taken = (int) Math.pow(10, 9);
                    if ( coins[ind] <= target)
                        taken = 1 + dp[ind][target - coins[ind]];
                    dp[ind][target] = Math.min(notaken, taken);
                }
            }
            return dp[n - 1][amount];
        }
    }
    static int minimumElements(int[] arr, int T) {
        int n = arr.length;

        // Create two arrays to store results of subproblems: prev and cur
        int prev[] = new int[T + 1];
        int cur[] = new int[T + 1];

        // Initialize the prev array for the first element of the array
        for (int i = 0; i <= T; i++) {
            if (i % arr[0] == 0)
                prev[i] = i / arr[0];
            else
                prev[i] = (int) Math.pow(10, 9);
        }

        // Fill the cur array using dynamic programming
        for (int ind = 1; ind < n; ind++) {
            for (int target = 0; target <= T; target++) {
                int notTake = 0 + prev[target];
                int take = (int) Math.pow(10, 9);

                // If the current element is less than or equal to the target, calculate 'take'
                if (arr[ind] <= target)
                    take = 1 + cur[target - arr[ind]];

                // Store the minimum result in the cur array
                cur[target] = Math.min(notTake, take);
            }

            // Update prev with cur for the next iteration
            prev = cur.clone();
        }

        // Get the minimum number of elements needed for the target sum
        int ans = prev[T];

        // If it's not possible to achieve the target sum, return -1
        if (ans >= (int) Math.pow(10, 9))
            return -1;
        return ans;
    }
}
