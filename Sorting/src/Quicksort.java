import java.util.*;

// * Time Complexity: O(N*logN), where N = size of the array.

//Reason: At each step, we divide the whole array, for that logN and n steps are taken for partition() function, so overall time complexity will be N*logN.

//The following recurrence relation can be written for Quick sort :

//F(n) = F(k) + F(n-1-k)

//Here k is the number of elements smaller or equal to the pivot and n-1-k denotes elements greater than the pivot.

//There can be 2 cases :

//Worst Case – This case occurs when the pivot is the greatest or smallest element of the array. If the partition is done and the last element is the pivot, then the worst case would be either in the increasing order of the array or in the decreasing order of the array.

//Recurrence:
//F(n) = F(0)+F(n-1)  or  F(n) = F(n-1) + F(0)

// * Worst Case Time complexity: O(n2)

//Best Case – This case occurs when the pivot is the middle element or near to middle element of the array.
//Recurrence :
//F(n) = 2F(n/2)

// * Time Complexity for the best and average case: O(N*logN)

// ! Space Complexity: O(1) + O(N) auxiliary stack space.
public class Quicksort {

    public static void main(String[] args) {

        int[]  arr =  {4, 6, 2, 5, 7, 9, 1, 3};
        int n = arr.length;
        System.out.println("Before Using Quick Sort: ");
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
        arr = Solution.quickSort(arr);
        System.out.println("After Quick sort: ");
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

}
class Solution{
    public static int[] quickSort(int[]arr){
         qs(arr , 0 , arr.length -1);
         return arr;
    }

   static void qs(int[] arr, int low, int high) {
        if ( low < high ) {
            int pI = parition(arr, low, high);
            qs(arr , low , pI-1);
            qs(arr , pI +1 , high);
        }

    }

    static int parition(int[] arr, int low, int high){
        int pivot = arr[low];
        int i = low;
        int j = high;
        while ( i < j){
            while ( arr[i] <= pivot && i <= high-1) i++;
            while ( arr[j] > pivot && j>= low+1) j--;
            if ( i < j){
                swap(arr ,i, j);
            }
        }
        swap(arr ,low, j);
        return j;

    }
    static void swap(int[] arr, int first, int second) {
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }
}
