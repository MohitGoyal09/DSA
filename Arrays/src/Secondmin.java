import java.util.Arrays;

public class Secondmin {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 3, 5, 9, 7, 8, 9, 10};
        int n = arr.length;
        int s1 = optimal(arr, n);
        System.out.println(s1);
    }
    static int optimal(int[] arr , int n){
        // * One loop
        //  * Time complexity : O(n)
        //  *Space complexity : O(1)
        if ( n <2) return -1;
        int min = Integer.MAX_VALUE;
        int secondmin = Integer.MAX_VALUE;
        int i;
        for (i = 0; i < n; i++){
            if (arr[i] < min){
                secondmin = min;
                min = arr[i];
            } else if ( arr[i] < secondmin && arr[i]!=min){
                secondmin = arr[i];
            }
        }
        return secondmin;

    }
    static int better(int[] arr , int n){
        // * Two loops
        // * Time Complexity : O(n)
        // * Space Complexity : O(1)
        if ( n <2)
            return -1;
        int min = Integer.MAX_VALUE;
        int secondmin = Integer.MAX_VALUE;
        int i;
        for ( i = 0; i < n; i++ ){
            min = Math.max(min , arr[i]);
        }
        for ( i = 0 ; i < n; i++ ){
            if ( arr[i] < min && arr[i] > secondmin){
                secondmin = arr[i];
            }
        }
        return secondmin;
    }

    static int brute(int[] arr, int n) {
        // * Time Complexity: O(NlogN), For sorting the array
        if ( n == 0 || n == 1)
            return -1;
        Arrays.sort(arr);
        int small = arr[1];
        int large = arr[n - 2];
        System.out.println("Second smallest is " + small);
        System.out.println("Second largest is " + large);
        return -1;
    }
}
