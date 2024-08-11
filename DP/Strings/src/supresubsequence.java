import java.util.Arrays;

public class supresubsequence {
    public static String supresubsequence(String s1, String s2) {

        int n = s1.length();
        int m = s2.length();

        int dp[][] = new int[n + 1][m + 1];

        for (int rows[] : dp) {
            Arrays.fill(rows, -1);
        }
        for ( int i = 0 ; i <= n ; i++){
            dp[i][0] = 0;
        }
        for ( int i = 0 ; i <= m ; i++){
            dp[0][i] = 0;
        }
        for ( int i = 1 ; i <= n ; i++){
            for (  int j = 1 ; j <= m ; j++){

                if (s1.charAt(i-1) == s2.charAt(j-1)){
                    dp[i][j] = 1 + dp[i-1][j-1];
                }
                else {
                    dp[i ][j ] = Math.max(dp[i][j - 1] , dp[i - 1][j]);
                }
            }
        }
        int len = dp[n][m];
        int i = n ;
        int j = m;
        int index = len - 1;
        String ans = "";

        while (i > 0 && j > 0) {
            if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                ans += s1.charAt(i - 1);
                i--;
                j--;
            } else if (dp[i - 1][j] > dp[i][j - 1]) {
                ans += s1.charAt(i - 1);
                i--;
            } else {
                ans += s2.charAt(j - 1);
                j--;
            }
        }
        String ans2 = new StringBuilder(ans).reverse().toString();
        return ans2;
    }
}
