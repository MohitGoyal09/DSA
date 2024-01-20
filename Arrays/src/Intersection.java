import java.util.*;
public class Intersection {
    public static void main(String[] args) {

        int[] arr1 = {1, 2, 3, 4, 5, 5,6, 7, 8, 9, 10};
        int[] arr2 = { 2, 3, 3,4,5,5, 5, 7,  9};
        int n = arr1.length;
        int m = arr2.length;
//        ArrayList<Integer> Intersection = optimal(arr1, arr2, n, m);
        ArrayList<Integer> burtteForce = burtteForce(arr1, arr2, n, m);
        System.out.println("Intersection of arr1 and arr2 is: ");
        for (int val : burtteForce)
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
    // * Time Compleixty : O(m*n)
    // * Time Complexity : O(m)
    static ArrayList<Integer> burtteForce(int arr1[], int arr2[], int n, int m) {
                      ArrayList<Integer> result = new ArrayList<Integer>();
                      int[] visited = new int[m];
                      for ( int i = 0 ; i < n ; i++){
                          for ( int j = 0 ; j < m ; j++){
                              if ( arr1[i] == arr2[j] && visited[j] == 0){
                                  result.add(arr1[i]);
                                  visited[j] = 1;
                                  break;
                              }
                              if (arr2[j] > arr1[i]) break;
                          }
                      }
                      return result;
    }
}
