// ! https://leetcode.com/problems/process-string-with-special-operations-ii/description/

// *  Intuition
// Instead of building the string, simulate how its length changes.
// Use this to navigate back from the final string length and reverse-simulate which character was at position k.
// This works by thinking in terms of lengths rather than actual strings.
// Approach
// Forward pass:

// Track the length of the resulting string.
// Do not construct the string.
// Early exit:

// If k >= final_length, return ..
// Backward pass:

// Start from the end of the input and reverse simulate the operations.
// If #, halve the length and adjust k accordingly.
// If %, reverse the index (k = len - 1 - k).
// If character, check if it's at position k.

class Solution {
    public char processStr(String s, long k) {
        long len = 0;
        for (char c : s.toCharArray()) {
            if (Character.isLowerCase(c)) len++;
            else if (c == '*' && len > 0) len--;
            else if (c == '#') len *= 2;
        }
        if (k >= len) return '.';

        for (int i = s.length() - 1; i >= 0; i--) {
            char c = s.charAt(i);
            if (Character.isLowerCase(c)) {
                if (k == len - 1) return c;
                len--;
            } else if (c == '*') {
                len++;
            } else if (c == '#') {
                len /= 2;
                if (k >= len) k -= len;
            } else if (c == '%') {
                k = len - 1 - k;
            }
        }
        return '.';
    }
}