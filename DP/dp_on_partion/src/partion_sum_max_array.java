import java.util.Arrays;

public class partion_sum_max_array {
    class Solution {
        public int maxSumAfterPartitioning(int[] arr, int k) {
            int n = arr.length ;
            int[] dp = new int[n];
            Arrays.fill(dp , -1);
            return f( 0 , arr , k , dp);
        }
        public int f(int i , int[] arr , int k , int[] dp){
            int n = arr.length;
            if ( i== n) return 0;
            if (dp[i] != -1) return dp[i];
            int len = 0 ;
            int max  = Integer.MIN_VALUE;
            int ans = Integer.MIN_VALUE;
            for ( int j = i ; j < Math.min( n , i + k) ; j++){
                len++;
                max = Math.max(max , arr[j]);
                int sum = len * max + f(j + 1 , arr , k , dp);
                ans = Math.max(ans , sum);
            }
            return dp[i] = ans;
        }
        public int part( int[] arr , int k ){
            int n = arr.length;
            int[] dp = new int[n + 1];
            Arrays.fill(dp , -1);
            dp[n] = 0;
            for ( int i = n - 1 ; i >= 0 ; i--){
                int len = 0 ;
                int max  = Integer.MIN_VALUE;
                int ans = Integer.MIN_VALUE;
                for ( int j = i ; j < Math.min( n , i + k) ; j++){
                    len++;
                    max = Math.max(max , arr[j]);
                    int sum = len * max + dp[j + 1];
                    ans = Math.max(ans , sum);
                }
                dp[i] = ans;
            }
            return dp[0];
        }
    }
}
