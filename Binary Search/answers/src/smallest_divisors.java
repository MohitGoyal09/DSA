public class smallest_divisors {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        int limit = 8;
        int ans = bs(arr, limit);
        System.out.println("The minimum divisor is: " + ans);
    }
    static int smallestDivisor(int[] a , int limit){
        int n = a.length;
        int max = Integer.MAX_VALUE;
        for (int i = 0 ; i  < n ; i++){
            max = Math.max(max , a[i]);
        }
        for ( int d = 1 ; d <= max ; d++){
            int sum = 0 ;
            for ( int i = 0 ; i < n ; i++){
                sum += Math.ceil((double) a[i] / (double) d);
            }
            if (sum <= limit) return d;
        }
        return -1;
    }
    static int bs(int[] a , int limit){
        int n = a.length;
        int max = Integer.MIN_VALUE;
        if(n > limit) return -1;
        for (int i = 0 ; i  < n ; i++){
            max = Math.max(max , a[i]);
        }
        int low = 1 , high = max;
        while (low <= high){
            int mid = (low + high)/2;
            if (sumD( a  , mid) <= limit){
                high = mid -1;
            } else low = mid + 1;

        }
        return low;
    }

    static int sumD(int[] a , int div){
        int n = a.length;
        int sum = 0;
        for ( int i = 0 ; i < n ; i++){
            sum += Math.ceil((double) a[i]/(double) div);
        }
        return sum;
    }
}
