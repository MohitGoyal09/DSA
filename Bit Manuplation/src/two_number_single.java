import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class two_number_single {
    public static void main(String[] args) {

    }
    // ! TC : O(N log M + M), where M = n/2 + 1
    // ! SC : O(M)
    static List<Integer> burutte(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        ArrayList<Integer> ans = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.get(nums[i]) == 1) {
                ans.add(nums[i]);
            }
        }
        return ans;
    }

}


