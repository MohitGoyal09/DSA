public class floor_ceil {
    public static void main(String[] args) {

        int[] arr = { 1, 2, 8, 10, 10, 12, 19 };
        int x = 5;
        System.out.println("Floor of " + x + " is " + findFloor(arr, x));
        System.out.println("Ceil of " + x + " is " + findCeil(arr, x));

    }
    static int findFloor(int[] arr,  int x) {
        int n = arr.length;
        int low = 0, high = n - 1;
        int ans = -1;

        while (low <= high) {
            int mid = (low + high) / 2;
            // maybe an answer
            if (arr[mid] <= x) {
                ans = arr[mid];
                //look for smaller index on the left
                low = mid + 1;
            } else {
                high = mid - 1; // look on the right
            }
        }
        return ans;
    }
    static int findCeil(int[] arr,  int x) {
        int n = arr.length;
        int low = 0, high = n - 1;
        int ans = -1;

        while (low <= high) {
            int mid = (low + high) / 2;
            // maybe an answer
            if (arr[mid] >= x) {
                ans = arr[mid];
                //look for smaller index on the left
                high = mid - 1;
            } else {
                low = mid + 1; // look on the right
            }
        }
        return ans;
    }
}

