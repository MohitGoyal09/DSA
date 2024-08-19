import java.util.Arrays;

public class palidrome_partioring_2 {
    class Solution {
        public int minCut(String s) {
            int n = s.length();
            int[] dp = new int[n];
            Arrays.fill(dp , -1);
            return f(s , 0 , n , dp) - 1;
        }
        public boolean isPara(int i , int j , String s){
            while (i < j) {
                if (s.charAt(i) != s.charAt(j)) return false;
                i++;
                j--;
            }
            return true;
        }
        public int f(String s , int i , int n ,int[] dp){
            if ( i == n) return 0;
            if (dp[i] != -1) return dp[i];
            int min = Integer.MAX_VALUE;
            for ( int j = i ; j < n ; j++){
                if (isPara(i , j , s)){
                    int ans = 1 + f(s , j+1 , n , dp);
                    min = Math.min(ans , min);
                }
            }
            return dp[i] = min;
        }
        public int palindromePartitioning(String str) {
            int n = str.length();
            int[] dp = new int[n + 1];
            dp[n] = 0;
            for (int i = n - 1; i >= 0; i--) {
                int minCost = Integer.MAX_VALUE;
                // String[i...j]
                for (int j = i; j < n; j++) {
                    if (isPara(i, j, str)) {
                        int cost = 1 + dp[j + 1];
                        minCost = Math.min(minCost, cost);
                    }
                }
                dp[i] = minCost;
            }
            return dp[0] - 1;
        }
    }
}
