import java.util.*;
public class print_lis {
    class Solution {
        public ArrayList<Integer> longestIncreasingSubsequence(int n, int arr[]) {
            // Code here
            int[] dp = new int[n];
            int[] hash = new int[n];
            Arrays.fill(dp,1);
            Arrays.fill(hash , 1);
            for ( int ind = 0 ; ind <= n -1 ; ind++){
                hash[ind] = ind;
                for ( int prev = 0 ; prev <= ind - 1 ; prev++){

                    if ( arr[prev] < arr[ind] && 1 + dp[prev] > dp[ind]){
                        dp[ind] = 1 + dp[prev];
                        hash[ind] = prev;
                    }
                }
            }
            int ans = -1;
            int lastIndex = -1;
            for ( int i = 0 ; i <= n - 1 ; i++){
                if (dp[i] > ans){
                    ans = dp[i];
                    lastIndex = i;
                }
            }
            ArrayList<Integer> temp=new ArrayList<>();
            temp.add(arr[lastIndex]);

            while(hash[lastIndex] != lastIndex){ // till not reach the initialization value
                lastIndex = hash[lastIndex];
                temp.add(arr[lastIndex]);
            }
            Collections.reverse(temp);
            return temp;
        }
    }
}

