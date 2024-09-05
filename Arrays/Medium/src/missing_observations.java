public class missing_observations {
    class Solution {
        public int[] missingRolls(int[] rolls, int mean, int n) {
            int m = rolls.length;
            int totalSum = mean * (n + m);
            int observedSum = 0;

            for (int roll : rolls) {
                observedSum += roll;
            }

            int missingSum = totalSum - observedSum;

            if (missingSum < n || missingSum > 6 * n) {
                return new int[0];
            }

            int base = missingSum / n;
            int remainder = missingSum % n;

            int[] result = new int[n];
            for (int i = 0; i < n; i++) {
                result[i] = base + (i < remainder ? 1 : 0);
            }

            return result;
        }
    }
}
