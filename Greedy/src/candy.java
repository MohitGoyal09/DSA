public class candy {
    // Time Complexity: O(3N)
    // Space Complexity: O(2N)
    public int candy(int[] ratings) {
        int n = ratings.length;
        int[] left = new int[n];
        int[] right = new int[n];
        left[0] = 1;
        right[n - 1] = 1;
        for (int i = 1; i < n; i++) {
            if (ratings[i] > ratings[i - 1]) {
                left[i] = left[i - 1] + 1;
            } else {
                left[i] = 1;
            }
        }
        for (int i = n - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                right[i] = right[i + 1] + 1;
            } else {
                right[i] = 1;
            }
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans += Math.max(left[i], right[i]);
        }
        return ans;
    }
    // ! Better
    static int mincandy(int n , int ratings[]){
        int left[] = new int[n];
        left[0]=1;
        for(int i=1;i<n;i++){
            if(ratings[i]>ratings[i-1])
                left[i]=left[i-1]+1;
            else
                left[i]=1;
        }
        int curr=1,right=1,sum=Math.max(left[n-1],1);
        for(int i=n-2;i>=0;i--){
            if(ratings[i]>ratings[i+1])
                curr=right+1;
            else
                curr=1;
            right=curr; // right is updated outside if else
            sum+=Math.max(left[i],curr);
        }
        return sum;
    }
    // ! Optimal
//    # Candy Distribution Algorithm Notes
//
//1. **Initialization**:
//            - Start with 1 candy (sum = 1)
//   - Begin from the second child (i = 1)
//
//2. **Equal Ratings**:
//            - If current child's rating equals previous, give 1 candy and move on
//
//            3. **Ascending Slope**:
//            - Count consecutive increasing ratings
//   - Distribute candies in increasing order (1, 2, 3, ...)
//   - Track peak value
//
//4. **Descending Slope**:
//            - Count consecutive decreasing ratings
//   - Distribute candies in increasing order (1, 2, 3, ...)
//   - Track down value
//
//5. **Adjustment**:
//            - If peak > down, add (peak - down) to sum
//   - This ensures the peak gets the correct number of candies
//
//6. **Efficiency**:
//            - Single pass through the array (O(n) time complexity)
//            - Constant extra space (O(1) space complexity)
//
//            7. **Key Insight**:
//            - Handles both ascending and descending slopes in one pass
//   - Adjusts for peaks to satisfy both sides of the slope

    static int mincandy2(int n , int ratings[]){
        int sum = 1;
        int i = 1;
        while ( i< n){
            if (ratings[i] == ratings[i-1]){
                sum++;
                i++;
                continue;
            }
            int peak = 1;
            while ( i < n && ratings[i] >ratings[i-1]){
                peak++;
                sum += peak;
                i++;
            }
            int down = 1;
            while ( i < n && ratings[i] < ratings[i-1]){
                down++;
                sum += down;
                i++;
            }
            if ( peak > down){
                sum = sum + (peak - down);
            }
        }
        return sum;
    }
}

