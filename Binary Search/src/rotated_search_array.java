public class rotated_search_array {
    public static void main(String[] args) {

        int[] arr = { 4, 5, 6, 7, 0, 1, 2 };
        int[] arr2 = {7, 8, 1, 2, 3, 3, 3, 4, 5, 6};
        int x = 4;
        System.out.println(search2(arr2, x));

    }

    static int search1(int[] arr , int x){
        int n = arr.length;
        int low = 0 , high =  n - 1;
        int ans = -1;
        while ( low <= high){
            int mid = (low + high)/2;
            if ( arr[mid] == x){
                ans = mid;
            }
            if ( arr[low] <= arr[mid]){
                if ( arr[low] <= x &&  arr[mid] >= x){
                    high = mid - 1;
                } else low = mid+1;
            }
            else {
                if ( arr[mid] <= x && arr[high] >= x){
                    low = mid + 1;
                } else high = mid-1;
            }
        }
        return ans;
    }

    // ! IF ARRAY HAS DUPLICATE ELEMENTS
    static int search2(int[] arr , int x){
        int n = arr.length;
        int low = 0 , high =  n - 1;
        int ans = -1;
        while ( low <= high){
            int mid = (low + high)/2;
            if ( arr[mid] == x){
                ans = mid;
            }
            if (arr[low] == arr[mid] && arr[mid] == arr[high]) {
                low = low + 1;
                high = high - 1;
                continue;
            }
            if ( arr[low] <= arr[mid]){
                if ( arr[low] <= x &&  arr[mid] >= x){
                    high = mid - 1;
                } else low = mid-1;
            }
            else {
                if ( arr[mid] <= x && arr[high] >= x){
                    low = mid+1;
                } else high = mid-1;
            }
        }
        return ans;
    }
}
