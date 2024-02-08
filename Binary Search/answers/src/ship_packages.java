public class ship_packages {
    public static void main(String[] args) {
        int[] weights = {5, 4, 5, 2, 3, 4, 5, 6};
        int d = 5;
        int ans = bs(weights, d);
        System.out.println("The minimum capacity should be: " + ans);
    }
    static int shipPackages(int[] weights, int D) {
        int n = weights.length;
        int max = Integer.MIN_VALUE , sum = 0;
        for ( int i = 0 ; i < n ; i++){
            sum += weights[i];
            max = Math.max(max , weights[i]);
        }
        for ( int i = max ; i <= sum ; i++){
            if ( finddays(weights  , i) <= D) return i;
        }
        return -1;
    }
    static int finddays(int[] a  , int cap){
        int  n = a.length;
        int load = 0;
        int day = 1;
        for ( int i = 0 ;  i < n ; i++){
            if (load + a[i] > cap){
                day +=1;
                load = a[i];
            } else load += a[i];
        }
        return day;
    }

    static int bs(int[] a  , int cap){
        int n = a.length;
        int low = Integer.MIN_VALUE , high = 0;
        for ( int i = 0 ; i < n ; i++){
            low = Math.max(low , a[i]);
            high +=a[i];
        }
        while ( low <= high){
            int mid = (low + high)/2;
            if (finddays(a, mid) <= cap) high = mid -1;
            else low = mid + 1;
        }
        return low;
    }
}
