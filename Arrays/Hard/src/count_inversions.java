import java.util.ArrayList;

public class count_inversions {
    public static void main(String[] args) {
        int[] a = { 1, 20, 6, 4, 5 };
        int n = a.length;
        System.out.println(optimal(a, n));
    }

    // ? BruteForce
    // ! Time Complexity: O(N^2), where N = size of the given array.
    // ! Space Complexity: O(1)
    public static int burute(int[] a, int n) {
        // Count the number of pairs:
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (a[i] > a[j]) cnt++;
            }
        }
        return cnt;
    }
    // ? Optimal
    // ! Time Complexity: O(N*logN), where N = size of the given array.
    // ! Space Complexity: O(N), as in the merge sort We use a temporary array to store elements in sorted order.
    public static int optimal(int[] a , int n){
        return mergesort(a , 0 , n-1);
    }
    public static int mergesort(int[] a , int low , int high){
        int cnt = 0;
        int mid = (low + high) / 2;
        if ( low >= high) return cnt;
        cnt += mergesort(a , low , mid );
        cnt += mergesort(a , mid+1 , high);
        cnt += merge(a , low , mid , high);
        return cnt;
    }
    static int merge(int[] arr , int low , int mid , int high){
        ArrayList<Integer> temp = new ArrayList<>(); // temporary array
        int left = low;      // starting index of left half of arr
        int right = mid + 1;   // starting index of right half of arr

        //Modification 1: cnt variable to count the pairs:
        int cnt = 0;

        //storing elements in the temporary array in a sorted manner//

        while (left <= mid && right <= high) {
            if (arr[left] <= arr[right]) {
                temp.add(arr[left]);
                left++;
            } else {
                temp.add(arr[right]);
                cnt += (mid - left + 1); //Modification 2
                right++;
            }
        }

        // if elements on the left half are still left //

        while (left <= mid) {
            temp.add(arr[left]);
            left++;
        }

        //  if elements on the right half are still left //
        while (right <= high) {
            temp.add(arr[right]);
            right++;
        }

        // transfering all elements from temporary to arr //
        for (int i = low; i <= high; i++) {
            arr[i] = temp.get(i - low);
        }
        return cnt;
    }
}
