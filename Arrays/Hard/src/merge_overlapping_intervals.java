import java.util.Arrays;

public class merge_overlapping_intervals {
    public static void main(String[] args) {
        long[] arr1 = {1, 4, 8, 10};
        long[] arr2 = {2, 3, 9};
        int n = 4, m = 3;
        optimal1(arr1, arr2, n, m);
        System.out.println("The merged arrays are:");
        System.out.print("arr1[] = ");
        for (int i = 0; i < n; i++) {
            System.out.print(arr1[i] + " ");
        }
        System.out.print("\narr2[] = ");
        for (int i = 0; i < m; i++) {
            System.out.print(arr2[i] + " ");
        }
        System.out.println();

    }
    // ? Brtue force
    // ! Time Complexity: O(n+m) + O(n+m), where n and m are the sizes of the given arrays.
    // ! Space Complexity : O(n + m)
    static void  brute(long[] a1,long[] a2 , int n , int m){
        long a3[] = new long[n+m];
        int left = 0;
        int right = 0;
        int index = 0;
        while ( left < n && right < m){
            if (a1[left]<= a2[right]){
                a3[index++] = a1[left++];
            } else {
                a3[index++] = a2[right++];
            }
        }
        while ( left < n){
            a3[index++] = a1[left++];
        }
        while ( right < m){
            a3[index++] = a2[right++];
        }

        for ( int i = 0 ; i < n+m ; i++){
            if ( i < n) {
                a1[i] = a3[i];
            } else {
                a2[i-n] = a3[i];
            }
        }
    }
    // ? Optimal
    // ! Time Complexity : O(n+m)
    // ! Space Complexity : O(1)
    static void optimal1(long a1[] , long a2[] , int n , int m){
        int right = 0;
        int left = n-1;
        while ( left >= 0 && right < m){
            if (a1[left] > a2[right]){
                long temp = a1[left];
                a1[left] = a2[right];
                a2[right] = temp;
                left--;
                right++;
            } else {
                break;
            }
        }
        Arrays.sort(a1);
        Arrays.sort(a2);
    }
    // ? Optimal 2
    // !Time Complexity: O((n+m)*log(n+m)), where n and m are the sizes of the given arrays.
    // ! Space Complexity : O(1)
    public static void optimal2(long[] arr1, long[] arr2, int n, int m) {

        // len of the imaginary single array:
        int len = n + m;

        // Initial gap:
        int gap = (len / 2) + (len % 2);

        while (gap > 0) {
            // Place 2 pointers:
            int left = 0;
            int right = left + gap;
            while (right < len) {
                // case 1: left in arr1[]
                //and right in arr2[]:
                if (left < n && right >= n) {
                    swapIfGreater(arr1, arr2, left, right - n);
                }
                // case 2: both pointers in arr2[]:
                else if (left >= n) {
                    swapIfGreater(arr2, arr2, left - n, right - n);
                }
                // case 3: both pointers in arr1[]:
                else {
                    swapIfGreater(arr1, arr1, left, right);
                }
                left++; right++;
            }
            // break if iteration gap=1 is completed:
            if (gap == 1) break;

            // Otherwise, calculate new gap:
            gap = (gap / 2) + (gap % 2);
        }
    }
    public static void swapIfGreater(long[] arr1, long[] arr2, int ind1, int ind2) {
        if (arr1[ind1] > arr2[ind2]) {
            long temp = arr1[ind1];
            arr1[ind1] = arr2[ind2];
            arr2[ind2] = temp;
        }
    }
}
