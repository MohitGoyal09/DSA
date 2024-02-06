
public class Main {
    public static void main(String[] args) {
        int n = 28;
        int ans = bs(n);
        System.out.println("The floor of square root of " + n + " is: " + ans);
    }
    static int brutterforce(int n){
        int ans =0;
        for ( long i = 1 ; i <= n ;i++){
            long val = i * i;
            if ( val <= (long) n){
                ans = (int) i;
            } else break;

        }
        return ans;
    }

    static int bs(int n){
        int low = 1 , high = n;
        while ( low <= high){
            long mid = (low + high)/2;
            long val = mid * mid;
            if (val <= (long) n){
                low = (int) mid + 1;

            } else high = (int) mid - 1;
        }
        return high;
    }
}