import java.util.Arrays;

public class LRotate {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5 , 6  , 7, 8, 9, 10};
        int n = arr.length;
        int k = 100;
        System.out.println("Arrays after left rotation: ");
        arr = rotate(arr, n);
        rotateByK(arr, n, k);
        System.out.println(Arrays.toString(arr));
    }
    // ? Rotate by One Place
    static int[] rotate(int[] arr, int n) {
//      *  Time Complexity: O(n), as we iterate through the array only once.
//      *   Space Complexity: O(1) as no extra space is used
        int temp = arr[0];
        for (int i = 1; i < n; i++) {
            arr[i - 1] = arr[i];
        }
        arr[n - 1] = temp;
        return arr;
    }


                                                // * Rotate by k Places //

    // ? Brutte Force Approach
    // * Time Complexity: O(n)
    // * Space Complexity: O(k)
    public static void rotateByK(int[] arr, int n, int k) {
        if ( n == 0) return ;
        k = k % n;
        if ( k > n ) return;
        int temp[] = new int[k];
        //  ! Storing the first k elements in Temp array
        for ( int i = 0; i < k; i++) {
            temp[i] = arr[i];
        }
        // ! Shifting elements in given array by k positions
        for (int i = 0; i < n - k; i++) {
            arr[i] = arr[i + k];
        }
        // ! Adding the temp array elements to the end of the given array
        for (int i = n - k; i < n; i++) {
            arr[i] = temp[i - n + k];
        }
    }

    // ? Optimized Approach
   // * Time Complexity – O(N) where N is the number of elements in an array
    // * Space Complexity – O(1) since no extra space is required
    public static void optimizedRotateByK(int[] arr, int n, int k) {
        if ( n == 0) return ;
        k = k % n;
        if ( k > n ) return;
        // ! Reverse first k elements
        reverse(arr , 0, k-1);
        // ! Reverse first n-k elements
        reverse(arr , k , n-1);
        // ! Reverse whole array
        reverse(arr , 0 ,n-1);
    }
   // ? Reverse the array
    static int[] reverse(int[] arrr , int start , int end){

        while(start < end){
            int temp = arrr[start];
            arrr[start] = arrr[end];
            arrr[end] = temp;
            start++;
            end--;
        }
        return arrr;
    }
}
