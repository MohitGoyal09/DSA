import java.util.HashMap;

public class Subarray {
    public static void main(String[] args) {
        int[] a = {2, 3, 5, 1, 9};
        long k = 10;
        int len = optimize(a, k);
        System.out.println("The length of the longest subarray is: " + len);

    }

    // * Brutte force
    // ! Time complexity = O(n^2)
    // ! Space complexity = O(1)
    static int brutteforce(int[] arr , long k){
        int n = arr.length;
        int len = 0;
        for ( int i  = 0 ; i  < n ; i++){
            long sum  = 0;
            for ( int  j = 0 ; j < n ; j++){
                sum+= arr[j];
                if ( sum == k){
                    len = Math.max(len , j-i+1);
                }
            }
        }
        return len;
    }
    // * Better approach
    //  * Optimal Solution if array contains negatives and zeros also
    // ! Time complexity = O(nlogn)
    // ! Space complexity = O(n)
    static int betterarray(int[] arr , long k) {
        HashMap<Long, Integer> preSumMap = new HashMap<>();
        int n = arr.length;
        int maxLen = 0;
        long sum = 0;
        for (int i = 0; i < n; i++) {
            sum +=arr[i];
            if (sum == k) {
                maxLen = Math.max(maxLen, i + 1);
            }
            long rem = sum - k;
            if (preSumMap.containsKey(rem)) {
                int len = i - preSumMap.get(rem);
                maxLen = Math.max(maxLen, len);
            }
            if (!preSumMap.containsKey(sum)){
                preSumMap.put(sum, i);
            }
      }
        return maxLen;
    }
   // * Optimized approach
    // ! Time complexity = O(n)
    // ! Space complexity = O(1)
    static int optimize(int[] arr , long k){
        int left = 0 , right = 0;
        int maxLen = 0;
        long sum = arr[0];
        int n = arr.length;
        while ( right < n){
            while ( sum > k && left <= right){
                sum-= arr[left];
                left++;
            }
            if ( sum == k) {
                maxLen = Math.max(maxLen , right - left + 1);
            }
            right++;
            if (right < n) sum += arr[right];
        }
        return maxLen;
    }
}
