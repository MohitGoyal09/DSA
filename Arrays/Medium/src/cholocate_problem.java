import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

// ! Time Complexity: O(N*log(N))
// ! Auxiliary Space: O(1)


// TODO : FIX , TIME BOUND EXCEEDED IN CODING NINJA
public class cholocate_problem {
    public static void main(String[] args) {
        int arr[] = {12, 4, 7, 9, 2, 23, 25, 41, 30, 40, 28, 42, 30, 44, 48, 43, 50};
        int m = 7;

        // Calculate the result using the chocolateDistribution method
        int result = optimal(arr, m);

        // Print the result or indicate an invalid input
        if (result != -1) {
            System.out.println("Minimum difference is " + result);
        } else {
            System.out.println("Invalid input");
        }
    }

    static int optimal(int[] chocolates, int m) {
        int n = chocolates.length;

        if (n == 0 || m == 0) {

            return 0;

        }

        int res = Integer.MAX_VALUE;

        Arrays.sort(chocolates);

        int i = 0;

        int j = m - 1;

        while (j < n) {

            int diff = chocolates[j] - chocolates[i];

            res = Math.min(res, diff);

            i++;

            j++;

        }

        return res;
    }


    // * GFG CODE
    public long findMinDiff (ArrayList<Integer> a, int n, int m)
    {
        // your code here
        if ( n == 0  || m == 0) return 0;

        long min = Integer.MAX_VALUE;
        Collections.sort(a);
        for ( int i = 0 ; i < n ; i++){
            int j = i + m -1;
            if ( j >= n) break;
            int diff = a.get(j) - a.get(i);
            min = Math.min(min , diff);
        }
        return min;
    }

}
