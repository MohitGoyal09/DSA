public class Kadane_Algorithm {
    public static void main(String[] args) {
        int[] arr = { -2, 1, -3, 4, -1, 2, 1, -5, 4};
        int n = arr.length;
        long maxSum = optimize(arr, n);
        System.out.println("The maximum subarray sum is: " + maxSum);
    }

    // ?  Brutte force
    // ! Time complexity = O(n^2)
    // ! Space complexity = O(1)
    static int burutte(int[] a , int n){
        int maxi = Integer.MIN_VALUE;
        for ( int i = 0 ; i < n ; i ++ ){
            int sum = 0;
            for ( int j = i ; j < n ; j ++ ){
                sum +=a[j];
                maxi = Math.max(maxi , sum);
            }

        }
        return maxi;
    }

    // ? Optimal Approach
    // ! Time Complexity : O(n)
    // ! Space Complexity : O(1)
    static long optimize(int[] a , int n){
        long sum = 0;
        long maxSum = Integer.MIN_VALUE;
        for ( int i = 0 ; i < n ; i++){
            sum += a[i];
            if ( sum > maxSum) maxSum = sum;
            if ( sum < 0) sum = 0;
        }
        // ! if there is no array with sum > 0
        // ! To consider the sum of the empty subarray
        if ( maxSum < 0) maxSum = 0;
        return maxSum;
    }
}
