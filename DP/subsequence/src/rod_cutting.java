import java.util.Arrays;

public class rod_cutting {
    class Solution{
        public int cutRod(int price[], int n) {
            //code here
            int[][] dp=new int[n][n+1];

            for(int[] r:dp)
                Arrays.fill(r,-1);

            return countLength(price,n,n-1,dp);
        }

        public int countLength(int[] price,int n,int ind,int[][] dp)
        {
            if(ind==0)
                return n*price[0];

            if(dp[ind][n]!=-1) return dp[ind][n];

            int notPick= countLength(price, n, ind - 1, dp);
            int pick=Integer.MIN_VALUE;
            int rodlen=ind+1;
            if(rodlen<=n) pick=price[ind]+countLength(price,n-rodlen,ind,dp);

            return dp[ind][n]=Math.max(pick,notPick);
        }
    }
}

