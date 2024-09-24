import java.util.*;
public class kth_smallest_lexical_scoping {
    public int countNumbers(long curr, long next, int n) {
        int countNum = 0;

        while (curr <= n) {
            countNum += Math.min(next, (long) n + 1) - curr;
            curr *= 10;
            next *= 10;
        }

        return countNum;
    }

    public int findKthNumber(int n, int k) {
        int curr = 1;
        k -= 1; // Since we start from the first number (1), we need k-1 more numbers

        while (k > 0) {
            int count = countNumbers(curr, curr + 1, n);
            if (count <= k) {
                curr++;
                k -= count; // Skipping the elements under the current prefix tree
            } else {
                curr *= 10;
                k -= 1;
            }
        }

        return curr;
    }
}
