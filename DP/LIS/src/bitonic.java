import java.util.Arrays;

public class bitonic {
    class Solution {
        public static int LongestBitonicSequence(int n, int[] nums) {
            int[] dp1 = new int[n];
            int[] dp2 = new int[n];
            Arrays.fill(dp1,1);
            Arrays.fill(dp2,1);
            //LIS from front:-
            for(int i=0;i<n;i++){
                for(int j=0;j<i;j++){
                    if(nums[i]>nums[j] && dp1[j]+1>dp1[i]){
                        dp1[i]=1+dp1[j];
                    }
                }
            }
            //LIS from rear:-
            for(int i=n-1;i>=0;i--){
                for(int j=n-1;j>i;j--){
                    if(nums[i]>nums[j] && dp2[j]+1>dp2[i]){
                        dp2[i]=1+dp2[j];
                    }
                }
            }

            if(dp1[n-1]==n || dp2[0]==n) return 0;
            int ans=0;
            for(int i=0;i<n;i++){
                if(dp1[i]>1 && dp2[i]>1)ans=Math.max(ans,dp1[i]+dp2[i]-1); //Joining LIS from front and rear and finding maximum
            }
            return ans;

        }
    }
}
