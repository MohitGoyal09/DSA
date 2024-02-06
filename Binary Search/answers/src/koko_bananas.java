public class koko_bananas {
    public static void main(String[] args) {
        int[] a = { 3, 6, 7, 11 };
        int h = 8;
        int ans = bs(a , h);
        System.out.println("The minimum number of hours is: " + ans);
    }

    static int bs(int[] a , int h){
        int low = 1 , high = maxel(a);
        while ( low <= high){
            int mid = (low+ high)/2;
            int hourlyrate = calculateTotalHours(a, mid);
            if ( hourlyrate <= h){
                high = mid -1;
            } else low = mid + 1;
        }
        return low;
    }

    private static int calculateTotalHours(int[] a, int horuly) {
        int total = 0;
        int n = a.length;
        for ( int i = 0 ;  i <  n ; i++){
            total += Math.ceil((double) a[i]/horuly);
        }
        return total;
    }

    private static int maxel(int[] a) {
        int max = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i] > max) {
                max = a[i];
            }
        }
        return max;
    }
}
