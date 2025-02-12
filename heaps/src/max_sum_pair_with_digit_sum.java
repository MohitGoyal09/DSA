import java.util.*;
public class max_sum_pair_with_digit_sum {
    private int getdigit(int num) {
        int sum = 0;
        while (num > 0) {
            sum += (num % 10);
            num /= 10;
        }
        return sum;
    }

    public int maximumSum(int[] nums) {
        int n = nums.length;
        int result = -1;
        HashMap<Integer, Integer> mp = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int digitSum = getdigit(nums[i]);
            if (mp.containsKey(digitSum)){
                result = Math.max(result , nums[i] + mp.get(digitSum) );
            }
            mp.put(digitSum, Math.max(mp.getOrDefault(digitSum, 0), nums[i]));
        }
        return result;
    }
    public int maximumSum2(int[] nums) {
        int n = nums.length;
        int result = -1;
        int[] res = new int[82];
        for (int i = 0 ; i < n ; i++){
            int digitSum = getdigit(nums[i]);
            if (res[digitSum] > 0){
                result = Math.max(result , nums[i] + res[digitSum]);
            }
            res[digitSum] = Math.max(res[digitSum] , nums[i]);
        }
        return result;

    }
}
