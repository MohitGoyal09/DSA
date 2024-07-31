import java.util.*;
public class Main {

    public static void main(String[] args) {
        int n = 5;
        int[] dp = new int[n+1];
        Arrays.fill(dp,-1);
        fibonachi(dp , n);
        System.out.println(dp[n]);

    }
    // ! Memoization
    static int fibonachi(int[] dp , int n){
        if ( n <=1) return n;
        if (dp[n] != -1) return dp[n];
        return dp[n] = fibonachi(dp , n-1) + fibonachi(dp , n-2);
    }

    // ! Tabulization
    static int fibonachi(int n){
        int[] dp = new int[n+1];
        Arrays.fill(dp,-1);
        dp[0]= 0;
        dp[1]= 1;
        for(int i=2; i<=n; i++){
            dp[i] = dp[i-1]+ dp[i-2];
        }
        return dp[n];
    }

    // ! Space Optimized
    static int fibonachiopt(int n){
        int prev2 = 0;
        int prev = 1;

        for(int i=2; i<=n; i++){
           int cur_i = prev + prev2;
           prev2 = prev;
           prev = cur_i;
        }
        return prev;
    }
}