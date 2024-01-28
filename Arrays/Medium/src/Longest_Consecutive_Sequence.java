import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Longest_Consecutive_Sequence {
    public static void main(String[] args) {
        int[] a = {100, 200, 1, 2, 3, 4};
        int ans = optimal(a);
        System.out.println("The longest consecutive sequence is " + ans);
    }

    static boolean linearsearch(int[] a, int target) {
        int n = a.length;
        for (int i = 0; i < n; i++) {
            if (a[i] == target) return true;
        }
        return false;
    }

    // ? Burute Force
    // ! Time Complexity: O(N2)
    // ! Space Complexity : O(1)
    static int burutte(int[] arr) {
        int longest = 1;
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            int x = arr[i];
            int cnt = 1;
            while (linearsearch(arr, x + 1)) {
                x++;
                cnt++;
            }
            longest = Math.max(longest, cnt);

        }
        return longest;
    }

    // ? Better Approach
    // ! Time Complexity: O(NlogN) + O(N)
    // ! Space Complexity : O(1)

    static int better(int[] arr) {
        Arrays.sort(arr);
        int longest = 1;
        int n = arr.length;
        int cnt = 0;
        int lastmin = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            if (arr[i] - 1 == lastmin) {
                cnt++;
                lastmin = arr[i];
            } else if (lastmin != arr[i]) {
                cnt = 1;
                lastmin = arr[i];

            }
            longest = Math.max(longest, cnt);
        }
        return longest;
    }

    // ? Optimal Approach
    // ! Time Complexity : O(N) + O(2*N) ~ O(3 * N)
    // ! Space Complexity : O(N)
    static int optimal(int[] arr) {
        int n = arr.length;
        int longest = 1;
        if (n == 0) return 0;
        Set<Integer> set = new HashSet<Integer>();
        for (int i = 0; i < n; i++) {
            set.add(arr[i]);
        }
        for (int it : set) {
            if (!set.contains(it - 1)) {
                int cnt = 1;
                int x = it;
                while (set.contains(x + 1)) {
                    x++;
                    cnt++;
                }
                longest = Math.max(longest, cnt);
            }
        }
        return longest;
    }
}


