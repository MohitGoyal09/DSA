import java.util.Arrays;
import java.util.HashMap;

// ! 2 SUM PROBLEM
public class Main {
    public static void main(String[] args) {

        int[] arr = {2, 7, 11, 15};
        int target = 18;
        int n = arr.length;
        int[] ans = optimized(arr, n, target);
        System.out.println(Arrays.toString(ans));
    }

    // ? Brutte Force
    // * TIME COMPLEXITY - O(n^2)
    // * SPACE COMPLEXITY - O(1)
    static int[] brutte(int[] a, int n, int target) {
        int[] arr = new int[2];
        arr[0] = arr[1] = -1;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (a[i] + a[j] == target) {
                    arr[0] = i;
                    arr[1] = j;
                    return arr;
                }
            }
        }
        return arr;
    }

    // ? Better APPROACH
    // * TIME COMPLEXITY - O(n)
    // * SPACE COMPLEXITY - O(n)
    static int[] better(int[] a, int n, int target) {
        int[] arr = new int[2];
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        arr[0] = arr[1] = -1;
        for ( int i =0 ; i< n ; i++){
            int one = a[i];
            int other = target - one;
            if (map.containsKey(other)){
                arr[0] = map.get(other);
                arr[1] = i;
                return arr;
            }
            map.put(a[i] , i);
        }
        return arr;
    }

    // ? Optimal APPROACH - 2 POINTER APPROACH
    // * TIME COMPLEXITY - O(n) + O(nlogn)
    // * SPACE COMPLEXITY - O(1)

    static int[] optimized(int[] a, int n, int target){
        Arrays.sort(a);
        int left = 0 , right = n-1;
        while ( left < right) {
            int sum = a[left] + a[right];
            if (sum == target) {
                return new int[]{left, right};
            } else if (sum < target) left++;
            else right--;
        }
        return new int[]{-1, -1};
    }

}