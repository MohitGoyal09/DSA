import java.util.*;

 // *
// ! Problem Understanding
 //
 //The problem is to find the minimum length of a substring that can be transformed into
// a string of alternating characters ('0' and '1') using a limited number of operations. An operation
// allows you to change a character in the string.
 //
 // ! Approach
 //
 // * 1. Binary Search for Minimum Length:
 //   - The main function `minLength` uses a binary search to find the minimum length of the substring that can be transformed.
 //   - The search space is between `1` and the length of the string `s`.
 //   - For each midpoint `mid` in the search space, the function `isPossible` checks if it's feasible
 //   to transform a substring of length `mid` into an alternating string with the given number of operations.
 //
 // * 2. Checking Feasibility (`isPossible` function):
 //   - If `maxLength` is `1`, it checks if the entire string can be transformed into either all '0's or all
 //   1's using the `canTransform` function.
 //   - For longer substrings, it calculates how many operations are needed to make the substring alternating.
 //   - It iterates through the string, counting consecutive characters (`repeatCount`) and
 //   adjusting `numOps` based on how many operations are needed to break these sequences into alternating patterns.
 //   - The logic `numOps -= repeatCount / (maxLength + 1)` is used to determine
 //   how many operations are needed to transform a sequence of repeated characters into an alternating pattern.
 //
 //* 3. Transforming the String (`canTransform` function):
 //   - This function checks if the string can be transformed into an alternating pattern starting with a given character (`start`).
 //   - It iterates over the string, toggling the expected character between '0' and '1'.
 //   - If a character does not match the expected character, it decrements `numOps`.
 //   - The function returns `true` if the transformation is possible within the allowed number of operations.
 //
 // !  Key Points
 //
 //- Binary Search: Efficiently narrows down the minimum possible length by leveraging the sorted nature of the
//   problem (shorter lengths require fewer operations).
 //- Greedy Approach in `isPossible`: Attempts to minimize operations by breaking sequences of repeated characters.
 //- Toggle Logic in `canTransform`: Ensures the string alternates correctly by toggling between '0' and '1'.

public class smallest_substring_with_identical_characters {
    public int minLength(String s, int numOps) {
        int left = 1, right = s.length(), ans = s.length();
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (isPossible(s, numOps, mid)) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }

    public boolean isPossible(String s, int numOps, int maxLength) {
        if (maxLength == 1)
            return (canTransform(s, numOps, maxLength, '1') || canTransform(s, numOps, maxLength, '0'));

        int repeatCount = 0;
        char lastChar = '\0'; // Initialize with null character
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == lastChar) {
                repeatCount++;
            } else {
                numOps -= repeatCount / (maxLength + 1);
                lastChar = s.charAt(i);
                repeatCount = 1;
            }
        }
        numOps -= repeatCount / (maxLength + 1);
        return (numOps >= 0);
    }

    public boolean canTransform(String s, int numOps, int maxLength, char start) {
        for (char ch : s.toCharArray()) {
            if (ch != start) numOps--;
            start = (start == '0') ? '1' : '0'; // Toggle between '0' and '1'
        }
        return (numOps >= 0);
    }
}
