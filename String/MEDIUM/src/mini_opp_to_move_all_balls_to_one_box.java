public class mini_opp_to_move_all_balls_to_one_box {
    //Approach-2 (Brute Force with O(1) space)
//T.C : O(n^2)
//S.C : O(1)
    public int[] minOperations(String boxes) {
        int n = boxes.length();
        int[] answer = new int[n];

        for (int i = 0; i < n; i++) {
            if (boxes.charAt(i) == '1') {
                for (int j = 0; j < n; j++) {
                    answer[j] += Math.abs(j - i);
                }
            }
        }

        return answer;
    }
    //Approach-3 (Optimal Using Cumulative Sum)
//T.C : O(n)
//S.C : O(1)
    // ! Aprroach
    // * 1. We can find the moves required to move all balls to index i by using a cumulative sum.
    // * Left moves for all balls to index i = Cumulative sum of left balls to index i
    // * Right moves for all balls to index i = Cumulative sum of right balls to index i
    // * Total moves for all balls to index i = Left moves + Right moves
    class Solution {
        public int[] minOperations(String boxes) {
            int n = boxes.length();
            int[] answer = new int[n];

            int cumValue = 0;
            int cumValueSum = 0;

            // Find moves for all left balls to index i
            for (int i = 0; i < n; i++) {
                answer[i] = cumValueSum;

                cumValue += boxes.charAt(i) == '0' ? 0 : 1;
                cumValueSum += cumValue;
            }

            cumValue = 0;
            cumValueSum = 0;

            // Find moves for all right balls to index i
            for (int i = n - 1; i >= 0; i--) {
                answer[i] += cumValueSum;

                cumValue += boxes.charAt(i) == '0' ? 0 : 1;
                cumValueSum += cumValue;
            }

            return answer;
        }
    }
}
