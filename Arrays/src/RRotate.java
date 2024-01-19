import java.util.Arrays;

public class RRotate {
    public static void main(String[] args) {

        int[] arr = {1, 2, 3, 4, 5 , 6  , 7, 8, 9, 10};
        int n = arr.length;
        int k = 2;
        System.out.println("Arrays after right rotation: ");
        rotateByK(arr, k, n);
        optimizedRotateByK(arr, k, n);
        System.out.println(Arrays.toString(arr));
    }
    // ? Burte Force Approach
    // * Time Complexity: O(n)
    // * Space Complexity: O(k)
    public static void rotateByK(int[] arr , int k , int n){
            if ( n == 0) return;
            k = k % n;
            if ( k > n ) return;
            int[] temp = new int[k];
        for (int i = n - k; i < n; i++) {
            temp[i - n + k] = arr[i];
        }
        for (int i = n - k - 1; i >= 0; i--) {
            arr[i + k] = arr[i];
        }
        for (int i = 0; i < k; i++) {
            arr[i] = temp[i];
        }
    }

    // ? Optimized Approach
    // * Time Complexity – O(N) where N is the number of elements in an array
    // * Space Complexity – O(1) since no extra space is required
    public static void optimizedRotateByK(int[] arr, int n, int k) {
        if ( n == 0) return;
        k = k % n;
        if ( k > n ) return;
        // !  Reverse first n-k elements
        reverse(arr , 0 , n-k-1);
        // ! Reverse last k elements
        reverse(arr , n-k ,n-1);
        // ! Reverse whole array
        reverse( arr ,  0 ,n-1);
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
