import java.util.Arrays;

public class frog_jump {

    public static void main(String[] args) {
        int arr[] = {1, 3, 6, 3, 2, 3, 6, 8, 9, 5};
        int n = arr.length;
        int[] dp = new int[n];
        Arrays.fill(dp,-1);
        System.out.println(frogJump(arr,  n, dp));
    }
    public static int frogJump(int[] arr, int ind, int[] dp){
        if(ind == 0) return 0;
        if(dp[ind] != -1) return dp[ind];
        int left = frogJump(arr,  ind-1, dp) + Math.abs(arr[ind] - arr[ind+1]);
        int right = Integer.MAX_VALUE;
        if(ind > 1) right = frogJump(arr,  ind-2, dp) + Math.abs(arr[ind] - arr[ind+2]);
        return dp[ind] = Math.min(left, right);
    }
    // ! Memoization
    public static int frogumpMemo(int[] height , int n , int[] dp){
        dp[0] = 0 ;
        for(int ind=1;ind<n;ind++){
            int jumpTwo = Integer.MAX_VALUE;
            int jumpOne= dp[ind-1] + Math.abs(height[ind]-height[ind-1]);
            if(ind>1)
                jumpTwo = dp[ind-2] + Math.abs(height[ind]-height[ind-2]);

            dp[ind]=Math.min(jumpOne, jumpTwo);
        }
        return dp[n-1];
    }
    public static int frogumpMemoopt(int[] height , int n ){
        int prev = 0 ;
        int prev2 = 0;
        for(int ind=1;ind<n;ind++){
            int jumpTwo = Integer.MAX_VALUE;
            int jumpOne= prev + Math.abs(height[ind]-height[ind-1]);
            if(ind>1)
                jumpTwo = prev2 + Math.abs(height[ind]-height[ind-2]);

            int cur_i =Math.min(jumpOne, jumpTwo);
            prev = cur_i;
            prev2 = prev;
        }
        return prev;
    }
}
