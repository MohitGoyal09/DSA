import java.util.*;
//Approach
//Dynamic Programming: We will use a 2D array dp where dp[i][j] represents the minimum number of print operations required to print the substring from index i to j.
//
//Recursive Function: The function Util(i, j) computes the minimum print operations for the substring s[i:j].
//
//If i > j, it returns 0 (base case).
//If dp[i][j] is already computed (not -1), it returns the stored value.
//The first print operation is always counted, and then we check for any repeated characters in the substring to potentially reduce the number of operations.
//Character Matching: For each character in the substring starting from i, if it matches the first character (s[i]), we can consider splitting the problem into two parts: printing from i to k-1 and from k+1 to j.
//
//Memoization: Store the results of subproblems in dp to avoid redundant calculations.
//
//Time and Space Complexity
//Time Complexity: The time complexity is O(n
//3
//), where n is the length of the string. This is due to the nested loops:
//The outer function calls are O(n
//2
//) (for each pair of indices).
//The inner loop iterates through the substring, leading to an overall complexity of O(n
//3
//).
//Space Complexity: The space complexity is O(n
//2
//) for the dp array that stores the results of subproblems.
//        Step-by-Step Explanation
//For Input "aaabbb"
//
//Let's trace the execution of the code with the input "aaabbb":
//
//Initialization:
//
//n = 6 (length of "aaabbb").
//dp is initialized to a 6x6 matrix filled with -1.
//First Call: strangePrinter("aaabbb") calls Util(0, 5).
//
//Util(0, 5):
//
//firstLetter = 'a'.
//Initial answer = 1 + Util(1, 5) (printing 'a' once and considering the rest).
//Util(1, 5):
//
//firstLetter = 'a'.
//Initial answer = 1 + Util(2, 5).
//        Util(2, 5):
//
//firstLetter = 'a'.
//Initial answer = 1 + Util(3, 5).
//        Util(3, 5):
//
//firstLetter = 'b'.
//Initial answer = 1 + Util(4, 5).
//        Util(4, 5):
//
//firstLetter = 'b'.
//Initial answer = 1 + Util(5, 5).
//        Util(5, 5):
//
//firstLetter = 'b'.
//Initial answer = 1 + Util(6, 5).
//        Util(6, 5) returns 0 (base case).
//Backtrack to Util(4, 5):
//
//answer = 1 + 1 = 2.
//Check for repeated characters:
//k = 5: s matches firstLetter ('b').
//Calculate betterAnswer = Util(4, 4) + Util(6, 5) = 1 + 0 = 1.
//Update answer = min(2, 1) = 1.
//Backtrack to Util(3, 5):
//
//answer = 1 + 1 = 2.
//Check for repeated characters:
//k = 4: s matches firstLetter ('b').
//Calculate betterAnswer = Util(3, 3) + Util(5, 5) = 1 + 1 = 2.
//Update `answer = min(2, 2) = 2.
//Backtrack to Util(2, 5):
//
//answer = 1 + 2 = 3.
//Check for repeated characters:
//k = 3: s matches firstLetter ('a').
//Calculate betterAnswer = Util(2, 2) + Util(4, 5) = 1 + 1 = 2.
//Update `answer = min(3, 2) = 2.
//Backtrack to Util(1, 5):
//
//answer = 1 + 2 = 3.
//Check for repeated characters:
//k = 2: s matches firstLetter ('a').
//Calculate betterAnswer = Util(1, 1) + Util(3, 5) = 1 + 1 = 2.
//Update `answer = min(3, 2) = 2.
//Backtrack to Util(0, 5):
//
//answer = 1 + 2 = 3.
//Check for repeated characters:
//k = 1: s matches firstLetter ('a').
//Calculate betterAnswer = Util(0, 0) + Util(2, 5) = 1 + 2 = 3.
//Update `answer = min(3, 3) = 3.
//Final Result: The final value of dp is 3, which means a minimum of 3 print operations are needed to print "aaabbb".
public class Strange_printer {
    class Solution {
        public int strangePrinter(String s) {
            int n = s.length();
            char[] sChar = s.toCharArray();
            int[][] dp = new int[n][n];
            for(int[] in : dp) Arrays.fill(in, -1);
            return Util(0, n - 1, sChar, dp);
        }
        public int Util(int i, int j, char[] sChar, int[][] dp) {
            if (i > j) {
                return 0;
            }

            if(dp[i][j] != -1) return dp[i][j];

            int firstLetter = sChar[i];
            // in case, current character is not repeated in the rest of the string
            int answer = 1 + Util(i + 1, j, sChar, dp);
            for (int k = i + 1; k <= j; k++) {
                // if repeated then update the answer
                if (sChar[k] == firstLetter) {
                    // splitting from i -> k - 1(remove the last character)
                    // and from k + 1 -> j
                    int betterAnswer = Util(i, k - 1, sChar, dp) + Util(k + 1, j, sChar, dp);
                    answer = Math.min(answer, betterAnswer);
                }
            }
            return dp[i][j] = answer;
        }
    }
}
