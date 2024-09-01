import java.util.List;

public class max_sum_path_two_arrays {
// * https://www.geeksforgeeks.org/problems/max-sum-path-in-two-arrays/1
    class Solution {
        public int maxPathSum(List<Integer> arr1, List<Integer> arr2) {
            // code here
            int m = arr1.size();
            int n = arr2.size();
            int ptr1 = 0 , ptr2 = 0;
            int sum1 = 0 , sum2 = 0;
            int maxsum = 0;
            while (ptr1 < m && ptr2 < n){
                int x = arr1.get(ptr1);
                int y = arr2.get(ptr2);
                if (x != y){
                    if ( x > y ){
                        sum2 += y;
                        ptr2++;
                    } else {
                        sum1 += x;
                        ptr1++;
                    }
                } else {
                    sum1 +=x;
                    sum2 += y;
                    maxsum += Math.max(sum1 , sum2);
                    sum1 = sum2 = 0;
                    ptr1++;
                    ptr2++;
                }
            }
            while (ptr1 < m) {
                sum1 += arr1.get(ptr1++);
            }

            while (ptr2 < n) {
                sum2 += arr2.get(ptr2++);
            }

            maxsum += Math.max(sum1, sum2);

            return maxsum;
        }
    }
}
