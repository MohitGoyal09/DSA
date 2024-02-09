import java.util.Arrays;

public class arregesive_cows {
    public static void main(String[] args) {
        int stalls[] = {1,2,8,4,9};
        int cows = 3;
        System.out.println(bs(stalls,cows));

    }
   static int aggressiveCows(int[] stalls, int cows){
       int n = stalls.length;
       Arrays.sort(stalls);
       int limit = stalls[n-1] - stalls[0];
       for ( int i = 0 ; i  <= limit ; i++){
            if (canplace(stalls,i,cows) == false){
                return (i-1);
            }
       }
       return limit;
   }

    private static boolean canplace(int[] stalls, int dist, int cows) {
        int last = stalls[0];
        int count = 1;
        int n = stalls.length;
        for ( int i = 0 ; i < n ; i++){
            if ( stalls[i] - last >= dist){
                count++;
                last = stalls[i];
            }
            if (count >= cows) return true;
        }
        return false;
    }

    public static int bs(int[] stalls, int cows){
        int n  = stalls.length;
        Arrays.sort(stalls);
        int low = 1 , high = stalls[n-1] - stalls[0];
        while ( low <= high){
            int mid = (low + high)/2;
            if ( canplace(stalls , mid  , cows) == true) low = mid + 1;
            else high = mid - 1;
        }
        return high;
    }
}
