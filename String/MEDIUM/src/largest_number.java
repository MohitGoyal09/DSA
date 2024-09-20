import java.util.*;
public class largest_number {
    public String largestNumber(int[] nums) {
        String[] numStrs = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            numStrs[i] = String.valueOf(nums[i]);
        }

        // Sort the strings based on custom comparator
        Arrays.sort(numStrs, (a, b) -> (b + a).compareTo(a + b));

        // Edge case: if the largest number is 0, return "0"
        if (numStrs[0].equals("0")) {
            return "0";
        }

        // Concatenate the sorted array to form the largest number
        StringBuilder result = new StringBuilder();
        for (String numStr : numStrs) {
            result.append(numStr);
        }

        return result.toString();
    }
}
