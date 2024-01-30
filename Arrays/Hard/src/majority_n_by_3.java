import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class majority_n_by_3 {
    public static void main(String[] args) {
        int[] arr = {11, 33, 33, 11, 33, 11};
        List<Integer> ans = optimal(arr);
        System.out.print("The majority elements are: ");
        for (int i = 0; i < ans.size(); i++) {
            System.out.print(ans.get(i) + " ");
        }
        System.out.println();

    }

    // ? Brute Force
    // ! Time Complexity : O(n^2)
    // ! Space Complexity : O(1)
    static List<Integer> burute(int[] a) {
        int n = a.length;
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (ans.size() == 0 || a[i] != ans.get(0)) {
                int count = 0;
                for (int j = i + 1; i < n; j++) {
                    if (a[i] == a[j]) count++;
                }
                if (count > n / 3) ans.add(a[i]);
            }
            if (ans.size() == 2) break;
        }
        return ans;
    }
    // ? Better Approach
    // ! Time Complexity: O(N*logN), where N = size of the given array.
    // ! Space Complexity: O(N).

    static List<Integer> better(int[] a) {
        int n = a.length;
        List<Integer> ans = new ArrayList<>();
        int mini = (int) n / 3 + 1;
        HashMap<Integer, Integer> set = new HashMap<>();
        for (int i = 0; i < n; i++) {
            set.put(a[i], set.getOrDefault(a[i], 0) + 1);

            if (set.get(a[i]) == mini) ans.add(a[i]);
            if (ans.size() == 2) break;
        }
        return ans;
    }
    // ? Optimal Approach
    // ! Time Complexity: O(N) + O(N)
    // ! Space Complexity: O(1)

    static List<Integer> optimal(int[] a) {
        int n = a.length;
        List<Integer> ans = new ArrayList<>();
        int cnt1 = 0;
        int cnt2 = 0;
        int el1 = Integer.MIN_VALUE;
        int el2 = Integer.MIN_VALUE;


        for (int i = 0; i < n; i++) {
            if ( cnt1 == 0 && el2 !=a[i]){
                el1 = a[i];
                cnt1 = 1;
            } else if ( cnt2 == 0 && el1 !=a[i]){
                el2 = a[i];
                cnt2 = 1;
            } else if ( a[i] == el1) cnt1++;
            else if (a[i] == el2) cnt2++;
            else {
                cnt1--;
                cnt2--;
            }
        }
        cnt1 = 0; cnt2 = 0;
        for (int i = 0; i < n; i++) {
            if (a[i] == el1) cnt1++;
            if (a[i] == el2) cnt2++;
        }
        int mini = (int)(n / 3) + 1;
        if (cnt1 >= mini) ans.add(el1);
        if (cnt2 >= mini) ans.add(el2);
        return ans;
    }
}
