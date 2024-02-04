public class times_array_rotated {
    public static void main(String[] args) {

        int[] arr = {4, 5, 6, 7, 0,0,0, 1, 2, 3};
        int ans = timerotateddup(arr);
        System.out.println("The minimum element is: " + ans);

    }
    static int timerotated(int[] a ){
        int n = a.length;
        int low = 0 , high = n-1;
        int ans = Integer.MAX_VALUE;
        int index = -1;
        while (low <= high){
            int mid = (low + high)/2;
            //search space is already sorted
            //then arr[low] will always be
            //the minimum in that search space:
            if (a[low] <= a[high]) {
                if (a[low] < ans) {
                    index = low;
                    ans = a[low];
                }
                break;
            }
            //if left part is sorted:
            if (a[low] <= a[mid]) {
                // keep the minimum:
                if (a[low] < ans) {
                    index = low;
                    ans = a[low];
                }

                // Eliminate left half:
                low = mid + 1;

            } else { //if right part is sorted:

                // keep the minimum:
                if (a[low] < ans) {
                    index = mid;
                    ans = a[mid];
                }

                // Eliminate right half:
                high = mid - 1;
            }
        }
        return index;
    }
    // ! IF ARRAY CONTAIN DUPLICATE ELEMENT
    static int timerotateddup(int[] a ){
        int n = a.length;
        int low = 0 , high = n-1;
        int ans = Integer.MAX_VALUE;
        int index = -1;
        while (low <= high){
            int mid = (low + high)/2;
            //search space is already sorted
            //then arr[low] will always be
            //the minimum in that search space:
            if(a[mid]==a[low] && a[high]==a[mid]){
                if (a[low] < ans) {
                    index = low;
                    ans = a[low];
                }
                high = high-1;
                low = low+1;
                continue;
            }
            if (a[low] <= a[high]) {
                if (a[low] < ans) {
                    index = low;
                    ans = a[low];
                }
                break;
            }
            //if left part is sorted:
            if (a[low] <= a[mid]) {
                // keep the minimum:
                if (a[low] < ans) {
                    index = low;
                    ans = a[low];
                }

                // Eliminate left half:
                low = mid + 1;

            } else { //if right part is sorted:

                // keep the minimum:
                if (a[low] < ans) {
                    index = mid;
                    ans = a[mid];
                }

                // Eliminate right half:
                high = mid - 1;
            }
        }
        return index;
    }
}
