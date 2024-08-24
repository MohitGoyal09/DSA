// * The key to this approach is considering all possible nearest palindromes efficiently.
// ! By generating just five candidates, we cover all cases:

// ? The palindrome formed by decrementing the left half covers cases where the nearest palindrome is slightly smaller.
// ? The palindrome formed by the left half as-is covers cases where the nearest palindrome is very close to the
// ? original number.
// ? The palindrome formed by incrementing the left half covers cases where the nearest palindrome is slightly larger.
// ? The all-9s number with one less digit covers cases like 1000, where 999 is the nearest palindrome.
// ? The number with 1 and trailing 0s with one more digit covers cases like 999, where 1001 is the nearest palindrome.

public class closet_palindrome {
    class Solution {
        public String nearestPalindromic(String numberStr) {
            long number = Long.parseLong(numberStr);
            if (number <= 10) return String.valueOf(number - 1);
            if (number == 11) return "9";

            int length = numberStr.length();
            long leftHalf = Long.parseLong(numberStr.substring(0, (length + 1) / 2));

            long[] palindromeCandidates = new long[5];
            palindromeCandidates[0] = generatePalindromeFromLeft(leftHalf - 1, length % 2 == 0);
            palindromeCandidates[1] = generatePalindromeFromLeft(leftHalf, length % 2 == 0);
            palindromeCandidates[2] = generatePalindromeFromLeft(leftHalf + 1, length % 2 == 0);
            palindromeCandidates[3] = (long)Math.pow(10, length - 1) - 1;
            palindromeCandidates[4] = (long)Math.pow(10, length) + 1;

            long nearestPalindrome = 0;
            long minDifference = Long.MAX_VALUE;

            for (long candidate : palindromeCandidates) {
                if (candidate == number) continue;
                long difference = Math.abs(candidate - number);
                if (difference < minDifference || (difference == minDifference && candidate < nearestPalindrome)) {
                    minDifference = difference;
                    nearestPalindrome = candidate;
                }
            }

            return String.valueOf(nearestPalindrome);
        }

        private long generatePalindromeFromLeft(long leftHalf, boolean isEvenLength) {
            long palindrome = leftHalf;
            if (!isEvenLength) leftHalf /= 10;
            while (leftHalf > 0) {
                palindrome = palindrome * 10 + leftHalf % 10;
                leftHalf /= 10;
            }
            return palindrome;
        }
    }

}
