import java.util.PriorityQueue;

public class gas_stations {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        int k = 4;
        double ans = brutteforce(arr, k);
        System.out.println("The answer is: " + ans);

    }
    static double brutteforce(int[] station , int k){
        int n = station.length;
        int[] howmany = new int[n - 1];

        for ( int gasStation = 1 ;gasStation <= k ;gasStation++){
            double maxSection = -1;
            int maxindex = -1;
            for ( int i  = 0 ; i < n-1 ; i++){
                double diff = station[i+1] - station[i];
                double sectionlength = diff / (double) (howmany[i] + 1);
                if ( sectionlength > maxSection ) maxindex = i;
                maxSection = Math.max(maxSection , sectionlength);
            }
            howmany[maxindex]++;
        }
        double maxans = -1;
        for ( int i = 0 ; i < n-1 ; i++){
            double diff = station[i+1] - station[i];
            double sectionlength = diff/(double) (howmany[i] +1);
            maxans = Math.max(maxans , sectionlength);
        }
        return maxans;
    }


    static double bs(int[] station , int k){
        int n = station.length;
        double low = 0 , high = 0;
        for (  int i = 0 ; i  < n ; i++){
            high = Math.max(high ,(double) station[i+1] - station[i]);
        }
        double diff = 1e-6;
        while ( high - low > diff){
            double mid = (low + high)/2;
            int cnt = numberOfGasStationsRequired(mid , station);
            if ( cnt > k){
                low = mid;
            } else {
                high = mid;
            }
        }
        return high;
    }
    public static int numberOfGasStationsRequired(double dist, int[] arr) {
        int n = arr.length; // size of the array
        int cnt = 0;
        for (int i = 1; i < n; i++) {
            int numberInBetween = (int)((arr[i] - arr[i - 1]) / dist);
            if ((arr[i] - arr[i - 1]) == (dist * numberInBetween)) {
                numberInBetween--;
            }
            cnt += numberInBetween;
        }
        return cnt;
    }
}
