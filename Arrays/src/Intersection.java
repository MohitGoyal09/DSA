import java.util.*;
public class Intersection {
    public static void main(String[] args) {

        int[] arr1 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int[] arr2 = { 2, 3,  5, 7,  9};
        int n = arr1.length;
        int m = arr2.length;
        ArrayList<Integer> Intersection = optimal(arr1, arr2, n, m);
        System.out.println("Intersection of arr1 and arr2 is: ");
        for (int val : Intersection)
            System.out.print(val + " ");
    }

    // ? Optimal Approach
    // * Time Complexity: O(m+n)
    // * Space Complexity : O(1)
    static ArrayList<Integer> optimal(int arr1[], int arr2[], int n, int m) {
        int i = 0, j = 0;
        ArrayList<Integer> result = new ArrayList<Integer>();

        while ( i < n &&  j < m){
            if ( arr1[i] < arr2[j]) i++;
            else if ( arr1[i] > arr2[j]) j++;
            else  {
                result.add(arr1[i]);
                i++;
                j++;
            }

        }
        return result;
    }

    // ? Brute Force
    static ArrayList<Integer> burtteForce(int arr1[], int arr2[], int n, int m) {

    }
}
