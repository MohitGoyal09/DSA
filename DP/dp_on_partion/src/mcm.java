import java.util.*;
public class mcm {
    static int f(int arr[], int i, int j, int[][] dp){
        // base condition
        if(i == j) return 0;
        if(dp[i][j]!=-1) return dp[i][j];
        int mini = Integer.MAX_VALUE;
        // partioning loop
        for(int k = i; k<= j-1; k++){
            int ans = f(arr,i,k,dp) + f(arr, k+1,j,dp) + arr[i-1]*arr[k]*arr[j];
            mini = Math.min(mini,ans);
        }
        return dp[i][j] = mini;
    }
    static int matrixMultiplication(int[] arr, int N){
        int dp[][]= new int[N][N];
        for(int row[]:dp)  Arrays.fill(row,-1);
        int i =1;
        int j = N-1;
        return f(arr,i,j,dp);
    }
    static int solve(int[] arr , int N ){
        int[][] dp = new int[N][N];

        // Initialize the dp array with -1
        for (int row[] : dp) {
            Arrays.fill(row, -1);
        }
        for (int i = 0 ; i < N ; i++){
            dp[i][i] = 0;
        }
        int mini = Integer.MAX_VALUE;
        for (int i = N - 1 ; i>= 1 ; i--){
            for (int j = i + 1 ; j < N ; j++){
                for (int k = i ; k < j ; k++){
                    int temp = dp[i][k] + dp[k+1][j] + arr[i-1]*arr[k]*arr[j];
                    mini = Math.min(mini,temp);
                }
                dp[i][j] = mini;
            }
        }

        return dp[1][N-1];
    }
}
