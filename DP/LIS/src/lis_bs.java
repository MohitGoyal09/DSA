import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class lis_bs {
    class Solution {
        // Function to find length of longest increasing subsequence.
        static int longestSubsequence(int n, int a[]) {
            // code here
            List<Integer> temp = new ArrayList<>();
            temp.add(a[0]);
            int len = 1;
            for (int i = 0 ; i < n ; i++){
                if (a[i] > temp.get(temp.size() - 1)){
                    temp.add(a[i]);
                    len++;
                } else {
                    int ind = Collections.binarySearch(temp, a[i]);

                    if (ind < 0) {
                        ind = -ind - 1;
                    }

                    temp.set(ind, a[i]);
                }
            }
            return len;
        }
    }
}
