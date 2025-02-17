public class find_punishment_number {
    // Approach-2 : (Recursion + Memoization)
// T.C : O(n * 2^(log10(n^2)))
// S.C : O(log10(n^2))
    public int punishmentNumber(int n) {
        int punish = 0;
        for (int current = 1; current <= n; current++) {
            int squarenum = current * current;
            if (check(squarenum, 0, current)) {
                punish += squarenum;
            }
        }
        return punish;
    }

    public boolean check(int num, int current, int target) {
        if (num == 0)
            return current == target;
        return check(num / 10, current + num % 10, target) ||
                check(num / 100, current + num % 100, target) ||
                check(num / 1000, current + num % 1000, target) ||
                check(num / 10000, current + num % 10000, target);
    }
    // Approach-1 : (Recursion + Memoization)
// T.C : O(n * 2^(log10(n^2)))
// S.C : O(n * log10(n^2))
    class Solution {
        public boolean check(int i, int currsum, String s, int num, int[][] t) {
            if (i == s.length()) {
                return currsum == num;
            }
            if (currsum > num)
                return false;

            if (t[i][currsum] != -1) // we have repeating subproblems. Draw tree diagram of "1296"
                return t[i][currsum] == 1;

            boolean possible = false;
            for (int j = i; j < s.length(); j++) {
                String currentString = s.substring(i, j + 1);
                int addend = Integer.parseInt(currentString);

                if (addend > num) continue; // Optimization to prevent unnecessary recursion

                possible = possible || check(j + 1, currsum + addend, s, num, t);
                if (possible)
                    return t[i][currsum] = 1;
            }

            return t[i][currsum] = 0;
        }

        public int punishmentNumber(int n) {
            int punishmentNum = 0;
            for (int num = 1; num <= n; num++) {
                int squareNum = num * num;
                String s = Integer.toString(squareNum);

                int[][] t = new int[s.length()][n + 1]; // Use n+1 instead of num+1
                for (int[] row : t) {
                    java.util.Arrays.fill(row, -1);
                }

                if (check(0, 0, s, num, t)) {
                    punishmentNum += squareNum;
                }
            }
            return punishmentNum;
        }
    }
    class Solution {
        public boolean check(int i, int currsum, String s, int num, int[][] t) {
            if (i == s.length()) {
                return currsum == num;
            }
            if (currsum > num)
                return false;

            if (t[i][currsum] != -1) // we have repeating subproblems. Draw tree diagram of "1296"
                return t[i][currsum] == 1;

            boolean possible = false;
            for (int j = i; j < s.length(); j++) {
                String currentString = s.substring(i, j + 1);
                int addend = Integer.parseInt(currentString);

                if (addend > num) continue; // Optimization to prevent unnecessary recursion

                possible = possible || check(j + 1, currsum + addend, s, num, t);
                if (possible)
                    return t[i][currsum] = 1;
            }

            return t[i][currsum] = 0;
        }

        public int punishmentNumber(int n) {
            int punishmentNum = 0;
            for (int num = 1; num <= n; num++) {
                int squareNum = num * num;
                String s = Integer.toString(squareNum);

                int[][] t = new int[s.length()][n + 1]; // Use n+1 instead of num+1
                for (int[] row : t) {
                    java.util.Arrays.fill(row, -1);
                }

                if (check(0, 0, s, num, t)) {
                    punishmentNum += squareNum;
                }
            }
            return punishmentNum;
        }
    }
    class Solution {
        public boolean check(int i, int currsum, String s, int num, int[][] t) {
            if (i == s.length()) {
                return currsum == num;
            }
            if (currsum > num)
                return false;

            if (t[i][currsum] != -1) // we have repeating subproblems. Draw tree diagram of "1296"
                return t[i][currsum] == 1;

            boolean possible = false;
            for (int j = i; j < s.length(); j++) {
                String currentString = s.substring(i, j + 1);
                int addend = Integer.parseInt(currentString);

                if (addend > num) continue; // Optimization to prevent unnecessary recursion

                possible = possible || check(j + 1, currsum + addend, s, num, t);
                if (possible)
                    return t[i][currsum] = 1;
            }

            return t[i][currsum] = 0;
        }

        public int punishmentNumber(int n) {
            int punishmentNum = 0;
            for (int num = 1; num <= n; num++) {
                int squareNum = num * num;
                String s = Integer.toString(squareNum);

                int[][] t = new int[s.length()][n + 1]; // Use n+1 instead of num+1
                for (int[] row : t) {
                    java.util.Arrays.fill(row, -1);
                }

                if (check(0, 0, s, num, t)) {
                    punishmentNum += squareNum;
                }
            }
            return punishmentNum;
        }
    }

}
