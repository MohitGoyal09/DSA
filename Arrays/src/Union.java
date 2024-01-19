import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class Union {
    public static void main(String[] args) {

        int arr1[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int arr2[] = {2, 3, 4, 4, 5, 11, 12};
        int n = arr1.length;
        int m = arr2.length;
        ArrayList<Integer> Union = optimal(arr1, arr2, n, m);
        System.out.println("Union of arr1 and arr2 is ");
        for (int val: Union)
            System.out.print(val+" ");
    }

    // ? Brute Force
    // * Time Compleixty : O( (m+n)log(m+n) ) .
    // * Inserting an element in a set takes logN time, where N is no of elements in the set.
    //  * At max set can store m+n elements {when there are no common elements and elements in arr,arr2 are distntict.
    // * So Inserting m+n th element takes log(m+n) time.
    //  * Upon approximation across inserting all elements in worst, it would take O((m+n)log(m+n) time.
    // * Space Complexity : O(m+n) {If Space of Union ArrayList is considered}
    // * O(1) {If Space of union ArrayList is not considered}
    static ArrayList<Integer> FindUnion(int arr1[], int arr2[], int n, int m){
        ArrayList<Integer> arr = new ArrayList<Integer>();
        HashSet<Integer> set = new HashSet<>();
        for ( int i = 0 ; i < n ; i++){
            set.add(arr1[i]);
        }
        for ( int i = 0 ; i < m ; i++){
            set.add(arr2[i]);
        }
        for ( int it : set){
            arr.add(it);
        }
        return arr;
    }

   // ? Optimal Approach
   // *Time Complexity: O(m+n), Because at max i runs for n times and j runs for m times. When there are no common elements in arr1 and arr2 and all elements in arr1, arr2 are distinct.
   // * Space Complexity : O(m+n) {If Space of Union ArrayList is considered}
    // *O(1) {If Space of union ArrayList is not considered}
    static ArrayList<Integer> optimal(int arr1[], int arr2[], int n, int m) {
        int i = 0, j = 0; // pointers
        ArrayList<Integer > Union=new ArrayList<>(); // Uninon Array
        while (i < n && j < m) {
            if (arr1[i] <= arr2[j]) // Case 1 and 2
            {
                if (Union.size() == 0 || Union.get(Union.size()-1) != arr1[i])
                    Union.add(arr1[i]);
                i++;
            } else // case 3
            {
                if (Union.size() == 0 || Union.get(Union.size()-1) != arr2[j])
                    Union.add(arr2[j]);
                j++;
            }
        }
        while (i < n) // IF any element left in arr1
        {
            if (Union.get(Union.size()-1) != arr1[i])
                Union.add(arr1[i]);
            i++;
        }
        while (j < m) // If any elements left in arr2
        {
            if (Union.get(Union.size()-1) != arr2[j])
                Union.add(arr2[j]);
            j++;
        }
        return Union;
    }
}
