import java.util.HashMap;

public class longest_subarray_sum_0 {
    public static void main(String[] args) {
        int a[] = {9, -3, 3, -1, 6, -5};
        System.out.println(optimal(a));
    }

    // ? Brute Force
    // ! Time Complexity : O(n^2)
    // ! Time Complexity : O(1)
    static int brute(int[] a) {
        int n = a.length;
        int max = 0;
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum += a[j];
                if (sum == 0) {
                    max = Math.max(max, j - i + 1);
                }
            }
        }
        return max;
    }
    // ? Optimal
    // ! Time Complexity : O(n)
    // ! Space Complexity : O(n)
    static int optimal(int[] a) {
        int n = a.length;
        int max = 0;
        int sum = 0;
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < n; i++) {
            sum += a[i];
            if (sum == 0) {
                max = i + 1;
            } else {
                if (map.get(sum) != null) {
                    max = Math.max(max, i - map.get(sum));
                } else {
                    map.put(sum, i);
                }

            }
        }
        return max;
    }
}
