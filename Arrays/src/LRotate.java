import java.util.Arrays;

public class LRotate {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        int n = arr.length;
        arr = rotate(arr, n);
        System.out.println(Arrays.toString(arr));
    }
    // Rotate by One Place
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
}
