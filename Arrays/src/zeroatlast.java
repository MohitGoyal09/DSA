import java.util.*;

public class zeroatlast {
    public static void main(String[] args) {
        int[] arr = {1, 0, 2, 3, 0, 4, 5, 0};
        int n = arr.length;
//        arr = moveZeros(arr, n);
        arr = moveZeros(arr,n);
        System.out.println(Arrays.toString(arr));
    }

    // ? Brute Force
    public static int[] moveZeros(int[] arr, int n) {
        ArrayList<Integer> temp = new ArrayList<>();
        for ( int i = 0; i < n; i++ ) {
            if ( arr[i] !=0){
                temp.add(arr[i]);
            }
        }
        int nz = temp.size();
        for ( int i = 0 ; i < nz ; i++ ) {
            arr[i] = temp.get(i);
        }
        for ( int i = nz ; i< n ; i++ ) {
            arr[i] = 0;
        }
        return arr;
    }

    // ? Optimized
    // ? Two Pointer Approach

    // * Time Complexity: O(N), N = size of the array.
    // * Reason: We have used 2 loops and using those loops, we are basically traversing the array once.
    // * Space Complexity: O(1) as we are not using any extra space to solve this problem.
    public static int[] optimize(int[] arr , int n) {
        int j = -1;
        //place the pointer j:
        for ( int i = 0 ; i< n ; i++){
            if ( arr[i] ==0){
                j = i;
                break;
            }
        }
        //no non-zero elements:
        if (j == -1) return arr;
        //Move the pointers i and j
        //and swap accordingly:
        for ( int i = j+1 ; i< n ; i++ ){
            if ( arr[i] !=0){
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                j++;
            }
        }
        return arr;
    }
}
