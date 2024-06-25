public class binary_subarrays_sum {
    public static void main(String[] args) {

    }
    public int goals(int nums[] , int goal){
        int l = 0 , sum = 0 ;
        int count = 0,r = 0;
        if (goal < 0) return 0;
        while ( r < nums.length){
            sum += nums[r];
            while ( sum > goal){
                sum = sum - nums[l];
                l++;
            }
            count += r - l + 1;
            r++;
        }
        return count;
    }
}
