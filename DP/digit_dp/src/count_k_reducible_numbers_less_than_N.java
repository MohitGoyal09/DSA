import java.util.*;
public class count_k_reducible_numbers_less_than_N {
    class Solution {
        int[] cntOfStepsToReachOne;
        int k ;
        int MOD = (int) 1e9+7;
        int[][][] dp;
        public int countKReducibleNumbers(String s, int k) {
            this.k = k;
            this.cntOfStepsToReachOne = new int[801];
            this.dp = new int[s.length()][2][801];
            for ( int[][] layer: dp){
                for ( int [] row : layer) Arrays.fill(row , -1);
            }
            cntOfStepsToReachOne[1] = 1;
            for ( int bitCount = 2 ; bitCount <= 800 ; bitCount++){
                int setBits = Integer.bitCount(bitCount);
                cntOfStepsToReachOne[bitCount] = 1 + cntOfStepsToReachOne[setBits];
            }
            return solve(s , 0 ,1 , 0);
        }
        int solve(String s , int i , int tight , int setBits){
            int res = 0;
            if ( i == s.length()){
                return (tight == 1 || setBits == 0) ?  0 : (cntOfStepsToReachOne[setBits] <= k ? 1 : 0);
            }
            if (dp[i][tight][setBits] != -1) return dp[i][tight][setBits];
            if (tight == 1){
                if (s.charAt(i) == '0') res = solve(s , i +1 , tight , setBits);
                else res = (solve(s , i +1 , 1 , setBits + 1) + solve(s , i + 1 , 0 , setBits) )% MOD;
            }  else {
                res = (solve( s , i + 1 , tight , setBits +1) + solve(s , i + 1 , tight , setBits )) % MOD;
            }
            return dp[i][tight][setBits] = res;
        }
    }
}
