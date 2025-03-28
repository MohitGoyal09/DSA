import java.util.*;
public class house_robber_4 {
    public int minCapability(int[] nums, int k) {
        int n = nums.length;
        int l = Arrays.stream(nums).min().getAsInt();
        int r = Arrays.stream(nums).max().getAsInt();
        int result = r;
        while ( l <= r){
            int mid = r + (l-r)/2;
            if (isPossible(nums , k , mid)){
                result = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return result;
    }
    public boolean isPossible(int[] nums , int k , int mid){
        int house = 0;
        for (int i = 0 ; i < nums.length ; i++){
            if (nums[i] <= mid){
                house++;
                i++;
            }
        }
        return house >= k;
    }
}
