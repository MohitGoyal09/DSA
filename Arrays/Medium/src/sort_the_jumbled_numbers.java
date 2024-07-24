import java.util.ArrayList;
import java.util.List;

public class sort_the_jumbled_numbers {
    class Solution {
        public int[] sortJumbled(int[] mapping, int[] nums) {
            List<int[]> mappedlist = new ArrayList<>();
            // Step 1: Create a list to store original nums and their mapped values
            for (int i = 0 ; i < nums.length ; i++){
                String s = Integer.toString(nums[i]);
                StringBuilder n = new StringBuilder();
                for (char ch : s.toCharArray()){
                    n.append(mapping[ch - '0']);
                }
                mappedlist.add(new int[]{nums[i] , Integer.parseInt(n.toString()) , i});
            }
            // Step 2: Sort the list based on the mapped values and original indices for stability
            mappedlist.sort((a,b) -> {
                if (a[1] != b[1]){
                    return Integer.compare(a[1] , b[1]);
                } else {
                    return Integer.compare(a[2] , b[2]);
                }
            });

            // Step 3: Create a result array and fill it with the sorted original nums
            int[] sortedNums = new int[nums.length];
            for (int i= 0 ; i < mappedlist.size() ; i++){
                sortedNums[i] = mappedlist.get(i)[0];
            }
            return sortedNums;
        }
    }
}
