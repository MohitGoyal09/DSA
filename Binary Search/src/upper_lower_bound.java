public class upper_lower_bound {
    public static void main(String[] args) {
        int[] arr = {3, 5, 8, 9, 15, 19};
        int  x = 9;
        int ind = lower_bound(arr, x);
        System.out.println("The upper bound is the index: " + ind);

    }
    static int upper_bound(int[] arr, int target) {
        int n = arr.length;
        int ans = n;
        int low = 0 , high = n - 1;
        while ( low <= high){
            int mid = (low + high) / 2;
            if ( arr[mid] > target){
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }

        }
        return ans;
    }

    static int lower_bound(int[] arr, int target) {
        int n = arr.length;
        int ans = n;
        int low = 0 , high = n - 1;
        while ( low <= high){
            int mid = (low + high) / 2;
            if ( arr[mid] >= target){
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }

        }
        return ans;
    }
}
