public class minimum_rotate_array {
    public static void main(String[] args) {
        int[] arr = {4, 5, 6, 7, 0, 1, 2, 3};
        int ans = min(arr);
        System.out.println("The minimum element is: " + ans );
    }

    static int min(int[] a ){
        int n = a.length;
        int low = 0 , high = n-1;
        int ans = Integer.MAX_VALUE;
        while (low <= high){
            int mid = (low + high)/2;
            //search space is already sorted
            //then arr[low] will always be
            //the minimum in that search space:
            if (a[low] <= a[high]) {
                ans = Math.min(ans, a[low]);
                break;
            }
            //if left part is sorted:
            if (a[low] <= a[mid]) {
                // keep the minimum:
                ans = Math.min(ans, a[low]);

                // Eliminate left half:
                low = mid + 1;

            } else { //if right part is sorted:

                // keep the minimum:
                ans = Math.min(ans, a[mid]);

                // Eliminate right half:
                high = mid - 1;
            }
        }
        return ans;
    }

    // ! IF ARRAY CONTAIN DUPLICATE ELEMENT
    public int findMin(int[] n) {

        int low=0;
        int high =n.length-1;
        int min = Integer.MAX_VALUE;


        while(low<=high) {
            int mid = (low+high)/2;

            if(n[mid]==n[low] && n[high]==n[mid]){
                min = Math.min(min,n[low]);
                high = high-1;
                low=low+1;
                continue;
            }
            if(n[low]<=n[mid]){
                min=Math.min(min,n[low]);
                low=mid+1;
            }
            else{
                min=Math.min(min,n[mid]);
                high =mid-1;
            }
        }
        return min;

    }
}
