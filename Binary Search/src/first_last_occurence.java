import java.util.ArrayList;

public class first_last_occurence {
    public static void main(String[] args) {
        int[] a = {2, 4, 6, 8, 8, 8, 11, 13};
        int x = 8;
        int[] ans = occurences(a,x);
        System.out.println(ans[0] + " " + ans[1]);
    }

    static int[] occurences(int[] a , int x ){
        int lb = lower_bound(a, x);
        if ( lb == a.length  || a[lb] !=x) return new int[]{-1, -1};
        else return new int[] {lb , upper_bound(a,x) - 1};
    }
    static int upper_bound(int[] arr, int x){
        int n = arr.length;
        int low = 0 , high = n-1;
        int ans = n;
        while (low <= high){
            int mid = (low + high) / 2;

            if (arr[mid] > x) {
                ans = mid;
                high = mid - 1;
            }
            else low = mid + 1;
        }
        return ans;
    }
    static int lower_bound(int[] arr, int x){
        int n = arr.length;
        int low = 0 , high = n-1;
        int ans = n;
        while (low <= high){
            int mid = (low + high) / 2;

            if (arr[mid] >= x) {
                ans = mid;
                high = mid - 1;
            }
            else low = mid + 1;
        }
        return ans;
    }


    static int firstoccurence(int[] arr, int k ){
        int low = 0 , high = arr.length - 1;
        int first = -1;
        while (low <= high) {
            int mid = (low + high) / 2;
            // maybe an answer
            if (arr[mid] == k) {
                first = mid;
                // look for smaller index on the left
                high = mid - 1;
            } else if (arr[mid] < k) {
                low = mid + 1; // look on the right
            } else {
                high = mid - 1; // look on the left
            }
        }
        return first;
    }
    static int lastoccurence(int[] arr, int k ){
        int low = 0 , high = arr.length - 1;
        int last = -1;
        while (low <= high) {
            int mid = (low + high) / 2;
            // maybe an answer
            if (arr[mid] == k) {
                last = mid;
                // look for smaller index on the left
                low = mid + 1;
            } else if (arr[mid] < k) {
                low = mid + 1; // look on the right
            } else {
                high = mid - 1; // look on the left
            }
        }
        return last;
    }
}
