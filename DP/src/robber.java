import java.util.ArrayList;

public class robber {
    class Solution {
        public int rob(int[] nums) {
            ArrayList<Integer> arr1=new ArrayList<>();
            ArrayList<Integer> arr2=new ArrayList<>();
            int n = nums.length;
            if(n==1) return nums[0];

            for(int i=0; i<n; i++){

                if(i!=0) arr1.add(nums[i]);
                if(i!=n-1) arr2.add(nums[i]);
            }

            int ans1 = solve(arr1);
            int ans2 = solve(arr2);

            return Math.max(ans1,ans2);
        }
        static int solve(ArrayList<Integer> arr){
            int n = arr.size();
            int prev = arr.get(0);
            int prev2 =0;

            for(int i=1; i<n; i++){
                int pick = arr.get(i);
                if(i>1)
                    pick += prev2;
                int nonPick = prev;

                int cur_i = Math.max(pick, nonPick);
                prev2 = prev;
                prev= cur_i;

            }
            return prev;
        }
    }
}
