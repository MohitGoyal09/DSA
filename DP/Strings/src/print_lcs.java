import java.util.*;
public class print_lcs {


    class TUF{
        static void lcs(String s1, String s2) {

            int n=s1.length();
            int m=s2.length();

            int[][] dp =new int[n+1][m+1];
            for(int i=0;i<=n;i++){
                dp[i][0] = 0;
            }
            for(int i=0;i<=m;i++){
                dp[0][i] = 0;
            }

            for(int ind1=1;ind1<=n;ind1++){
                for(int ind2=1;ind2<=m;ind2++){
                    if(s1.charAt(ind1-1)==s2.charAt(ind2-1))
                        dp[ind1][ind2] = 1 + dp[ind1-1][ind2-1];
                    else
                        dp[ind1][ind2] = Math.max(dp[ind1 - 1][ind2], dp[ind1][ind2 - 1]);
                }
            }

            int len=dp[n][m];
            int i=n;
            int j=m;

            int index = len-1;
            String str="";
            for(int k=1; k<=len;k++){
                str +="$"; // dummy string
            }
            StringBuilder ss= new StringBuilder(s1);
            StringBuilder str2=new StringBuilder(str);
            while(i>0 && j>0){
                if(ss.charAt(i-1) == s2.charAt(j-1)){
                    str2.setCharAt(index,ss.charAt(i-1) );
                    index--;
                    i--;
                    j--;
                }
                else if(ss.charAt(i-1)>s2.charAt(j-1)){
                    i--;
                }
                else j--;
            }
            System.out.println(str2);
        }
}
    class Solution {
        public List<String> all_longest_common_subsequences(String s1, String s2) {
            int n = s1.length();
            int m = s2.length();

            int dp[][] = new int[n + 1][m + 1];

            // Fill the dp table
            for (int ind1 = 1; ind1 <= n; ind1++) {
                for (int ind2 = 1; ind2 <= m; ind2++) {
                    if (s1.charAt(ind1 - 1) == s2.charAt(ind2 - 1))
                        dp[ind1][ind2] = 1 + dp[ind1 - 1][ind2 - 1];
                    else
                        dp[ind1][ind2] = Math.max(dp[ind1 - 1][ind2], dp[ind1][ind2 - 1]);
                }
            }

            // Use a map to memoize results of subproblems
            Map<String, Set<String>> memo = new HashMap<>();
            Set<String> subsequences = findAllLCS(s1, s2, n, m, dp, memo);

            // Convert set to list and sort it to get lexicographical order
            List<String> result = new ArrayList<>(subsequences);
            Collections.sort(result);

            return result;
        }

        private Set<String> findAllLCS(String s1, String s2, int i, int j, int[][] dp, Map<String, Set<String>> memo) {
            // Base case: if either string is exhausted
            if (i == 0 || j == 0) {
                Set<String> baseResult = new HashSet<>();
                baseResult.add("");
                return baseResult;
            }

            // Check if the result is already computed and cached
            String key = i + "," + j;
            if (memo.containsKey(key)) {
                return memo.get(key);
            }

            Set<String> result = new HashSet<>();

            // If characters match, add to all LCS found by moving diagonally
            if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                Set<String> lcs = findAllLCS(s1, s2, i - 1, j - 1, dp, memo);
                for (String str : lcs) {
                    result.add(str + s1.charAt(i - 1));
                }
            } else {
                // If not, follow the direction of maximum value in dp table
                if (dp[i - 1][j] >= dp[i][j - 1]) {
                    result.addAll(findAllLCS(s1, s2, i - 1, j, dp, memo));
                }
                if (dp[i][j - 1] >= dp[i - 1][j]) {
                    result.addAll(findAllLCS(s1, s2, i, j - 1, dp, memo));
                }
            }

            // Memoize the result for the current subproblem
            memo.put(key, result);
            return result;
        }
    }}
