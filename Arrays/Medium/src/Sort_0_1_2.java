import java.util.ArrayList;
public class Sort_0_1_2 {
    public static void main(String[] args) {

        int arr[] = {0,1,1,2,0,1,0,2,0,1,1,0};
        int n = arr.length;
        System.out.println("Before sorting array: ");
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
        optimize(arr,  n );
        System.out.println("After sorting array: ");
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    // * Burrtte Approach
    // * Merger sort
    // ! Time Complexity  = O(nlogn)
    // ! Space Complexity = 0(n)
    static void burutte( int[] arr , int start , int end){
            if (start >= end) return;
            int mid = start + (end - start)/2;
            burutte(arr , start , mid);
            burutte(arr , mid+1 , end);
            merge(arr , start , mid , end);

    }
    static void merge(int[] arr , int start , int mid , int end){
        ArrayList<Integer> merged = new ArrayList<>();
        int i = start , j = mid + 1;
        while ( i <= mid && j <= end){
            if ( arr[i] < arr[j]) {
                merged.add(arr[i]);
                i++;
            }
            else {
                merged.add(arr[j]);
                j++;
            }
        }
        while ( i <= mid){
            merged.add(arr[i]);
            i++;
        }
        while ( j <= end){
            merged.add(arr[j]);
            j++;
        }
        for ( int k = start ; k <= end ; k++){
            arr[k] = merged.get(k-start);
        }
    }
    // * Better Approach
    // ! Time Complexity : 0(n) + 0(n)
    // ! Space Complexity : 0(1)
    static void better(int[] arr , int n ){
        int cnt0 = 0 , cnt1 = 0 , cnt2 = 0;
        for ( int i = 0; i < n ; i++){
            if ( arr[i] == 0) cnt0++;
            if (arr[i] == 1) cnt1++;
            if (arr[i] == 2) cnt2++;
        }
        for (int i = 0; i < cnt0; i++) arr[i] =  0; // replacing 0's

        for (int i = cnt0; i < cnt0 + cnt1; i++) arr[i] = 1; // replacing 1's

        for (int i = cnt0 + cnt1; i < n; i++) arr[i] = 2;
    }
    // * Optimal Appproach
    // ?                                                 Dutch National Flag Algorithm
    // ! Time complexity : 0(n)
    // ! Space complexity : 0(1)
    static void optimize(int[] a , int n){
           int low = 0 , mid = 0 , high = n-1;
           while ( mid <= high){
               if (a[mid] == 0) {
                   swap(a ,low , mid);
                   low++;
                   mid++;
               }
               else if  (a[mid] == 1) {
                   mid++;
               }
               else {
                   swap(a , mid , high);
                   high--;
               }
           }
    }
    static void swap(int[] arr, int first, int second) {
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }
}
