public class peak_element {
    public static void main(String[] args) {
        int[] a = {1,2,3,1};
        System.out.println(bs(a));
    }

    static int buruutefore(int[] a ){
        int n = a.length;
        for (int i = 0 ; i < n ; i++){
            if ((i == 0 || a[i] > a[i-1]) && ( i == n-1 || a[i] > a[i+1])) return i;
        }
        return -1;
    }

    static int bs(int[] a){
        int n = a.length;
        if ( n == 1) return 0;
        if ( a[0] > a[1]) return 0;
        if ( a[n-1] > a[n-2]) return n-1;
        int low = 1 , high = n-2;
        while (low <= high){
            int mid = (low + high) /2;
            if (a[mid] > a[mid-1] && a[mid] > a[mid+1]) return mid;
            else if (a[mid] > a[mid-1]) low = mid + 1;
            else high = mid - 1;
        }
        return -1;
    }
}
