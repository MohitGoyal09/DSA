import java.util.Arrays;

public class longest_string_chain {
    class Solution {
        int dp[][];
        public int longestStrChain(String[] words) {
            Arrays.sort(words,(a, b) -> Integer.compare(a.length(),b.length()));
            int n = words.length;

            dp = new int[n+1][n];

            for(int row[] : dp){
                Arrays.fill(row,-1);
            }

            return solve(words, 0 , -1);

        }

        public int solve(String[] words, int currentIndex, int prevIndex){

            if(currentIndex >= words.length){
                return 0;
            }

            if(dp[currentIndex][prevIndex+1] != -1){
                return dp[currentIndex][prevIndex+1];
            }

            int pick = 0;
            int notPick = 0;
            // Pick
            if(prevIndex == -1 || isMatch(words[prevIndex],words[currentIndex])){
                pick = 1 + solve(words, currentIndex+1,currentIndex);
            }

            // Not pick
            notPick = solve(words, currentIndex+1,prevIndex);
            dp[currentIndex][prevIndex+1] = Math.max(pick,notPick);
            return dp[currentIndex][prevIndex+1];
        }

        public boolean isMatch(String s, String t){

            int i = 0;
            int j = 0;

            if(t.length() != s.length()+1) return false;

            while(i < s.length() && j < t.length()){
                if(s.charAt(i) == t.charAt(j)){
                    i++;
                }
                j++;
            }

            return  i == s.length();
        }


    }
}
